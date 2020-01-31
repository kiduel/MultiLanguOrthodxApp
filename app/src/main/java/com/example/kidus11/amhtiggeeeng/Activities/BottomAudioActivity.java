package com.example.kidus11.amhtiggeeeng.Activities;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kidus11.amhtiggeeeng.Adapters.BottomRecyclerViewAdapter;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.Utility;
import com.example.kidus11.amhtiggeeeng.data.Audio;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BottomAudioActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {


    androidx.constraintlayout.motion.widget.MotionLayout motionLayout;
    static final int REWIND_STEP = 10;
    static final int FORWARD_STEP = 30;
    String AMAZON_URL_WDASE_MARYAM = "https://s3.amazonaws.com/prayer-audio/";
    String AMAZON_URL_SEATAT = "https://s3.us-east-2.amazonaws.com/seatat-audio/";
    String AMAZON_URL_KIDASE = "https://s3.us-east-2.amazonaws.com/kidase-audio/";

    String JUKE_HOST = "https://audio.jukehost.co.uk/";
    String GOOGLE = "https://doc-0g-34-docs.googleusercontent.com/docs/securesc/";

    TextView elapsedTimeLabel;
    TextView remainingTimeLabel;
    SeekBar positionBar;
    static MediaPlayer mp = null;
    int totalTime;


    boolean initialStage = true;
    static final String CHANNEL_ID = "TEST_CHANNEL_ID";
    ArrayList<Audio> audio_to_be_passed_to_adapter;
    String prayerLanguage;


    Player player = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motionlayout_test);


        motionLayout = (MotionLayout)findViewById(R.id.motionLayout);

        findViewById(R.id.background).setOnTouchListener(this);

        findViewById(R.id.btnPlay).setOnClickListener(this);
        findViewById(R.id.btnRewind).setOnClickListener(this);
        findViewById(R.id.btnForward).setOnClickListener(this);
        findViewById(R.id.btnPlay_small).setOnClickListener(this);

        elapsedTimeLabel = (TextView)findViewById(R.id.elapsedTime);
        remainingTimeLabel = (TextView)findViewById(R.id.remainingTime);
        prayerLanguage = getIntent().getStringExtra("audio_passed");

        //provide back button on the actionBar
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        BottomRecyclerViewAdapter adapter = new BottomRecyclerViewAdapter(this,  initAudios());
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(BottomAudioActivity.this, 2);
        recyclerView.setLayoutManager(mGridLayoutManager);
        recyclerView.setAdapter(adapter);

        if (!Utility.isOnline(this)) {


        }

        createNotificationChannel();

        //added on 10/18 by Wayne
        if( mp != null ) {
            mp.stop();
            mp.reset();
        }
    }

    public void UpdateTimeline()
    {
        totalTime = mp.getDuration();
        positionBar = (SeekBar)findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if( fromUser )
                {
                    mp.seekTo(progress);
                    positionBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while( mp != null )
                {
                    try {
                        Message msg = new Message();
                        msg.what = mp.getCurrentPosition();

                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    }
                    catch(Exception e){}
                }
            }
        }).start();
    }

    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            int currentPosition = msg.what;
            positionBar.setProgress(currentPosition);

            String elapsedTime = createTimeLabel(currentPosition);
            elapsedTimeLabel.setText(elapsedTime);

            remainingTimeLabel.setText("-" + createTimeLabel(totalTime - currentPosition));
        }
    };

    private String createTimeLabel(int time)
    {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if( sec < 10 )
            timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        Log.d("TouchTest", "" + event.getAction());

        int spaceHeight = findViewById(R.id.space).getMeasuredHeight();

        switch(v.getId())
        {
            case R.id.background:
                if( spaceHeight > 0 )
                    motionLayout.transitionToStart();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {


        int nTargetPosition;

        switch (v.getId())
        {
            case R.id.btnRewind:
                if( initialStage || mp == null)
                    return;

                nTargetPosition = mp.getCurrentPosition() - REWIND_STEP * 1000;
                if( nTargetPosition < 0 )
                    nTargetPosition = 0;
                mp.seekTo(nTargetPosition);
                break;
            case R.id.btnPlay:
            case R.id.btnPlay_small:
                if( initialStage || mp == null) {
//                    prepareAudio(strCurrentUrl);
                }
                else {
                    if (!mp.isPlaying()) {
                        ((ImageView) findViewById(R.id.btnPlay)).setImageResource(R.drawable.round_pause_48);
                        ((ImageView) findViewById(R.id.btnPlay_small)).setImageResource(R.drawable.round_pause_24);
                        mp.start();
                    } else {
                        ((ImageView) findViewById(R.id.btnPlay)).setImageResource(R.drawable.round_play_48);
                        ((ImageView) findViewById(R.id.btnPlay_small)).setImageResource(R.drawable.round_play_24);
                        mp.pause();
                    }
                }
                break;
            case R.id.btnForward:
                if( initialStage || mp == null)
                    return;

                nTargetPosition = mp.getCurrentPosition() + FORWARD_STEP* 1000;
                if( nTargetPosition >= mp.getDuration() ) {
                    mp.stop();
                    mp.reset();
                    initialStage = true;


                    ((ImageView) findViewById(R.id.btnPlay)).setImageResource(R.drawable.round_play_48);
                    ((ImageView) findViewById(R.id.btnPlay_small)).setImageResource(R.drawable.round_play_24);
                }
                else
                    mp.seekTo(nTargetPosition);
                break;
        }
    }

    ProgressDialog progressDialog = null;

    class Player extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... strings) {
            Boolean prepared = false;

            try{
                mp.setDataSource(strings[0]);
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {

                        mp.stop();
                        mp.reset();
                        initialStage = true;
                        ((ImageView)findViewById(R.id.btnPlay)).setImageResource(R.drawable.round_play_48);
                        ((ImageView) findViewById(R.id.btnPlay_small)).setImageResource(R.drawable.round_play_24);
                    }
                });
                mp.prepare();
                prepared = true;

                ((ImageView) findViewById(R.id.btnPlay)).setImageResource(R.drawable.round_pause_48);
                ((ImageView) findViewById(R.id.btnPlay_small)).setImageResource(R.drawable.round_pause_24);
                mp.start();


            }
            catch(Exception e)
            {
                prepared = false;
            }
            return prepared;
        }


        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            if( progressDialog.isShowing() ) {
                progressDialog.dismiss();
            }

            initialStage = false;

            UpdateTimeline();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            try {

                progressDialog.setMessage("Buffering...");
                progressDialog.show();
            }
            catch (Exception e)
            {
                Log.e("KidusAudioPlayer", e.getMessage());
            }
        }
    }

    void showNotification(int icon, String title, String text)
    {

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setChannelId(CHANNEL_ID)
                        .setSmallIcon(icon)
                        .setContentTitle(title)
                        .setContentText(text)
                        .setDefaults(0);

        Intent notificationIntent = new Intent(this, BottomAudioActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    @Override
    protected void onStop() {
        super.onStop();

        showNotification(R.drawable.bete_selot_tool_image, ((TextView)findViewById(R.id.txtTitle)).getText().toString(), ((TextView)findViewById(R.id.txtDescription)).getText().toString());
    }


    private void createNotificationChannel() {
        String channel_name = "test_channel";
        String channel_description = "test_description";


        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channel_name, importance);
            channel.setDescription(channel_description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }

    private String strCurrentUrl = "";

    public void prepareAudio(String url)
    {
        try{
            mp.stop();
            mp.reset();
        }
        catch (Exception e)
        {
        }

        ((ImageView) findViewById(R.id.btnPlay)).setImageResource(R.drawable.round_play_48);
        ((ImageView) findViewById(R.id.btnPlay_small)).setImageResource(R.drawable.round_play_24);

        mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        strCurrentUrl = url;


        if( progressDialog != null )
        {
            progressDialog.dismiss();
        }

        progressDialog = new ProgressDialog(this);

        if( player != null && !player.isCancelled() )
        {
            player.cancel(true);
        }
        player = new Player();
        player.execute(url);
    }
    //
//    public void onAudioSelected(int iconId, String title, String description, String url)
    public void onAudioSelected(Audio audio)
    {
        TextView audioTitle = (TextView)findViewById(R.id.txtTitle);
        TextView audioDescription = (TextView)findViewById(R.id.txtDescription);
        TextView noAudio = (TextView)findViewById(R.id.no_audio);

        noAudio.setVisibility(View.INVISIBLE);
        audioDescription.setVisibility(View.VISIBLE);
        audioTitle.setVisibility(View.VISIBLE);

        audioTitle.setText(audio.getAudio_title());
        audioTitle.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        audioDescription.setText(audio.getArtist());
        ImageView imageView = ((ImageView)findViewById(R.id.imgAvatar));

        Picasso
                .get()
                .load(audio.getImageUrl())
                .placeholder(R.drawable.placeholder) // can also be a drawable
                .into(imageView);



        prepareAudio(audio.getAudioUrl());
    }


    ArrayList<Audio> initAudios()
    {

        ArrayList<Audio> wdaseMaryam = new ArrayList<>();
        wdaseMaryam.add(new Audio(" ሰላም ለኪ",getString(R.string.priest_name),R.drawable.maryam_image, "https://audio.jukehost.co.uk/p/79a4962643707ae238aca947564f44c18783e18c/500c9922e49"));
        wdaseMaryam.add(new Audio(" ዘሰኑይ",getString(R.string.priest_name),R.drawable.maryam_image, "https://docs.google.com/uc?export=open&id=1fKXQWtR_NmxIdQhVDUz5cZ5XZSy9WaVY"));
        wdaseMaryam.add(new Audio(" ዘሠሉስ",getString(R.string.priest_name),R.drawable.maryam_image, AMAZON_URL_WDASE_MARYAM+"Tuesday.mp3"));
        wdaseMaryam.add(new Audio(" ዘረቡዕ",getString(R.string.priest_name),R.drawable.maryam_image, AMAZON_URL_WDASE_MARYAM+"Wednesday.mp3"));
        wdaseMaryam.add(new Audio(" ዘኅሙስ",getString(R.string.priest_name),R.drawable.maryam_image, AMAZON_URL_WDASE_MARYAM+"Thursday.mp3"));
        wdaseMaryam.add(new Audio(" ዘዓርብ",getString(R.string.priest_name),R.drawable.maryam_image, AMAZON_URL_WDASE_MARYAM+"Firday.mp3"));
        wdaseMaryam.add(new Audio(" ዘቅዳሚት",getString(R.string.priest_name),R.drawable.maryam_image, AMAZON_URL_WDASE_MARYAM+"Satruday.mp3"));
        wdaseMaryam.add(new Audio(" ዘሰነበተ ክርስቲያን",getString(R.string.priest_name),R.drawable.maryam_image, AMAZON_URL_WDASE_MARYAM+"Sunday.mp3"));

        ArrayList<Audio> seatat = new ArrayList<>();
        seatat.add(new Audio(" ነሲእየ ማዕተበ - ንሴብሖ",getString(R.string.setatat_priest),R.drawable.maryam_image, AMAZON_URL_SEATAT+"part+1.mp3"));
        seatat.add(new Audio(" ገነይነ ለኪ - ኲሎሙ ርኢክዎ",getString(R.string.setatat_priest),R.drawable.maryam_image,AMAZON_URL_SEATAT+"part+2.mp3"));
        seatat.add(new Audio(" ኲሎሙ ወባቲ - ኲሎሙ ዘቊስቋም",getString(R.string.setatat_priest),R.drawable.maryam_image, AMAZON_URL_SEATAT+"part+3.mp3"));
        seatat.add(new Audio(" ኲሎሙ ዘኪዳነ ምሕረት - አቊርር",getString(R.string.setatat_priest),R.drawable.maryam_image, AMAZON_URL_SEATAT+"part+4.mp3"));
        seatat.add(new Audio(" ሚካኤል  -  ለኖኅ ሐመሩ",getString(R.string.setatat_priest),R.drawable.maryam_image, AMAZON_URL_SEATAT+"part+5.mp3"));
        seatat.add(new Audio(" ስብሐተ ኢየሱስ  - ስብሐተ ፍቁር ዘመላእክት",getString(R.string.setatat_priest),R.drawable.maryam_image, AMAZON_URL_SEATAT+"part+6.mp3"));
        seatat.add(new Audio(" መሐረነ አብ - መል.ውዳሴ ዘአንቀጸ ብርሃን",getString(R.string.setatat_priest),R.drawable.maryam_image, AMAZON_URL_SEATAT+"part+7.mp3"));
        seatat.add(new Audio(" መቅድመ ተአምር - እሴብሕ ጸጋኪ",getString(R.string.setatat_priest),R.drawable.maryam_image, AMAZON_URL_SEATAT+"part+8.mp3"));

        ArrayList<Audio> kidase_amharic = new ArrayList<>();
        kidase_amharic.add(new Audio("ሙሉ ቅዳሴ","በመምሕር የማነብርሀን",R.drawable.etan, AMAZON_URL_KIDASE+"kdase_amh.mp3"));

        ArrayList<Audio> kidase_tig = new ArrayList<>();
        kidase_tig.add(new Audio("ግዕዝ","ቀሲስ ዮሐንስ ገጋሲ",R.drawable.etan, AMAZON_URL_KIDASE+"tig_geez.mp3"));
        kidase_tig.add(new Audio("ዕዝል - ሰራዊተ","ቀሲስ ዮሐንስ ገጋሲ",R.drawable.etan, AMAZON_URL_KIDASE+"tig+_+ezil.mp3"));

        if (prayerLanguage.equals(getResources().getString(R.string.wdase_maryam))) {
            setTitle(getResources().getString(R.string.wdase_maryam));
            return wdaseMaryam;
        }  else if(prayerLanguage.equals(getResources().getString(R.string.seatat))) {
            setTitle(getResources().getString(R.string.seatat));
            return seatat;
        } else if(prayerLanguage.equals(getResources().getString(R.string.card_title_Tig))) {
            setTitle(getResources().getString(R.string.card_title_Tig));
            return kidase_tig;
        } else if(prayerLanguage.equals(getResources().getString(R.string.card_title_Amharic))) {
            setTitle(getResources().getString(R.string.card_title_Amharic));
            return kidase_amharic;
        }
        else {
            return null;
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.example.kidus11.amhtiggeeeng.Activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.Utility;
import com.example.kidus11.amhtiggeeeng.interfaces.OnSongDurationObrainedListener;
import com.example.kidus11.amhtiggeeeng.notifications.NotificationsHelper;
import com.example.kidus11.amhtiggeeeng.services.AudioService;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicPlayerAct extends AppCompatActivity implements OnSongDurationObrainedListener {

    private static final String FILE_PATH_DATA = "file_path_data";
    private static final String IMG_URL_DATA = "img_url_data";

    @BindView(R.id.music_title_tv)
     TextView music_title;
    @BindView(R.id.seek_bar_tv)
     SeekBar seek_bar;
    @BindView(R.id.audio_image_tv)
     ImageView audio_image;
    @BindView(R.id.duration_start_tv)
     TextView duration_elapsed;
    @BindView(R.id.duration_end_tv)
     TextView duration_end;
    @BindView(R.id.play_pause_image)
     Button play_pause_image;
    @BindView(R.id.adView)
    AdView banner_ad;

    private int duration;

    private String audio_file_received;
    private String image_file_received;
    private boolean musicIsPlaying = false;
    private boolean changeSong = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        ButterKnife.bind(this);
        audio_file_received = getIntent().getStringExtra("audio_url");
        image_file_received = getIntent().getStringExtra("img_url");
        String music_title_received = getIntent().getStringExtra("title_url");
       // save the audio file data
        if(audio_file_received == null)
            audio_file_received = getAudioFileData(this);
        if(image_file_received == null)
            image_file_received = getImgUrlData(this);

        //To request and load Ads that is already in the layout
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("0DEEF21400DD4AF964C51630FE5112C7")
                .build();
        banner_ad.loadAd(adRequest);

        //provide back button on the actionBar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (!Utility.isOnline(this)){
            Toast.makeText(this, "Please connect to the internet", Toast.LENGTH_LONG).show();
        }
        Picasso
                .with(this)
                .load(image_file_received)
                .placeholder(R.drawable.placeholder) // can also be a drawable
                .into(audio_image);
        // open media player to find the length of the audio track, release it after that
        try {
            requestSongDuration(this, audio_file_received);
        } catch (Exception e) {
            Log.i("exception", "onCreate: ");
        }
        seek_bar.setMax(duration);
        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if ( fromUser ) {
                            startAudioService(progress, "seekto");
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        play_pause_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( !musicIsPlaying) {
                    musicIsPlaying = true;

                    if(changeSong) {
                        changeSong = false;
                        seek_bar.setProgress(0);
                        duration_elapsed.setText(createTimeLable(0));
                        requestSongDuration(MusicPlayerAct.this, audio_file_received);
                    }
                    startAudioService(0, AudioService.PLAY);
                    NotificationsHelper.showNotification(MusicPlayerAct.this);

                    // save data
                    saveAudioFileData(MusicPlayerAct.this, audio_file_received);
                    saveImgUrlData(MusicPlayerAct.this, image_file_received);

                    if (!Utility.isOnline(getApplicationContext())){
                        Toast.makeText(getApplicationContext(), "Please connect to the internet", Toast.LENGTH_LONG).show();
                    }

                    play_pause_image.setBackgroundResource(R.drawable.ic_pause_black_48dp);
                } else {
                    musicIsPlaying = false;
                    startAudioService(0, AudioService.PAUSE);
                    play_pause_image.setBackgroundResource(R.drawable.ic_play_arrow_black_48dp);

                    if (!Utility.isOnline(getApplicationContext())){
                        Toast.makeText(getApplicationContext(), "Please connect to the internet", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        //To save the title
        music_title.setText(music_title_received);
    }



    @Override
    public void onSongDurationObtained(int duration) {
        Log.e("duration", Integer.toString(duration));
        duration_end.setText(createTimeLable(duration));
        seek_bar.setMax(duration);
    }


    private String createTimeLable(int time) {
        String timeLabel;
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if ( sec < 10 ) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    private BroadcastReceiver br = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle bundle = intent.getExtras();
            if (bundle != null) {

                String current_playing_file = bundle.getString(AudioService.FILE);
                   // if music is playing background and the activity doesn't know about it
                if(!musicIsPlaying && !current_playing_file.equals(AudioService.NO_FILE)){
                    // if in background is playing same song as the current user selection, update ui accordingly
                    if(audio_file_received.equals(current_playing_file)){
                        musicIsPlaying = true;
                        play_pause_image.setBackgroundResource(R.drawable.ic_pause_black_48dp);
                    }
                    else { // if in background is playing a different song, set flag to tell to audio service to load
                        // the right one when user selects play
                        changeSong = true;
                        play_pause_image.setBackgroundResource(R.drawable.ic_play_arrow_black_48dp);
                    }
                }
                else {
                    int progress = bundle.getInt(AudioService.PROGRESS, 0);
                    String elapsedTime = createTimeLable(progress);
                    seek_bar.setProgress(progress);
                    duration_elapsed.setText(elapsedTime);
                }
            }
        }
    };
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        registerReceiver(br, new IntentFilter(AudioService.UPDATE_PROGRESS_INTENT_FILTER));

    }
    @Override
    public void onPause ()
    {

        super.onPause();
    }

    @Override
    public void onBackPressed ()
    {

        super.onBackPressed();
        finish();
        Log.e("on back pressed", "onbackpressed");
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(br);
        super.onDestroy();
    }

    private void startAudioService(int seekto, String action)
    {
        Intent intent = new Intent(MusicPlayerAct.this, AudioService.class);
        intent.putExtra(AudioService.PROGRESS, seekto);
        intent.putExtra(AudioService.ACTION, action);
        intent.putExtra(AudioService.FILE, audio_file_received);
        startService(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void requestSongDuration(final OnSongDurationObrainedListener listener, String song_file)
    {
        try {
            final MediaPlayer mp = new MediaPlayer();
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp.setDataSource(audio_file_received);
            mp.prepareAsync();
            mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    duration = mp.getDuration();
                   listener.onSongDurationObtained(duration);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void saveAudioFileData(Context context, String audio_file)
    {
        getSharedPrefs(context).edit().putString(FILE_PATH_DATA, audio_file).apply();
    }

    private String getAudioFileData(Context context)
    {
        return getSharedPrefs(context).getString(FILE_PATH_DATA, AudioService.NO_FILE);
    }

    private void saveImgUrlData(Context context, String url)
    {
        getSharedPrefs(context).edit().putString(IMG_URL_DATA, url).apply();
    }

    private String getImgUrlData(Context context)
    {
        return getSharedPrefs(context).getString(IMG_URL_DATA, AudioService.NO_FILE);
    }

    private SharedPreferences getSharedPrefs(Context context)
    {
        return context.getSharedPreferences("SharedPrefsAudioAct", MODE_PRIVATE);
    }

}

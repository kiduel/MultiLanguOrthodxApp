package com.example.kidus11.amhtiggeeeng.services;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import androidx.annotation.Nullable;
import android.util.Log;

/**
 * Created by Kidus on 1/11/2018.
 */

public class AudioService extends Service
{
    public static final String UPDATE_PROGRESS_INTENT_FILTER = "updateProgress";
    public static final String PROGRESS = "updateProgress";
    private static final String SEEKTO = "seekto";
    public static final String PAUSE = "pause";
    public static final String PLAY = "play";
    public static final String ACTION = "action";
    public static final String FILE = "file";
    public static final String NO_FILE = "no_FILE";
    private String audio_file_received = NO_FILE;
    private boolean mpPrepared = true;

    private static MediaPlayer mp;
    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        if(intent!=null) {
            String file = intent.getStringExtra(FILE);

            final int seekto = intent.getIntExtra(PROGRESS, 0);
            final String action = intent.getStringExtra(ACTION);
            // if player is playing but user song is different from actual song, change songs
            if (mp == null || !audio_file_received.equals(file)) {

                if (mp != null) {
                    Log.e("blaa", "blaa");
                    if(mp.isPlaying())
                        mp.stop();
                    mp.release();
                }
                try {
                    audio_file_received = file;
                    mp = new MediaPlayer();
                    mpPrepared = false;
                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mp.setDataSource(audio_file_received);
                    mp.prepareAsync();
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if(action.equals(PLAY))
                                mp.start();
                            mp.seekTo(seekto);
                            mp.setLooping(true);
                            mp.setVolume(0.5f, 0.5f);
                            mpPrepared = true;
                        }
                    });
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (mp != null) {
                                try {
                                    //Log.e("here", "here");
                                    if(mpPrepared)
                                        if(mp.isPlaying())
                                            updateSeekBar(mp.getCurrentPosition());
                                    Thread.sleep(300);

                                } catch (InterruptedException ignored) {

                                }
                            }

                        }
                    }).start();


                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i("exception", "onCreate: ");
                }
            } else {
                switch (action) {
                    case PLAY:
                        Log.e("start called", "start called");
                        if(mpPrepared)
                            if(!mp.isPlaying())
                                mp.start();
                        break;
                    case SEEKTO:
                        mp.seekTo(seekto);
                        break;
                    case PAUSE:
                        mp.pause();
                        break;
                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onDestroy() {
        mp.stop();
        mp.release();
        super.onDestroy();
    }

    private void updateSeekBar(int progress) {

        Intent intent = new Intent(UPDATE_PROGRESS_INTENT_FILTER);
        intent.putExtra(PROGRESS, progress);
        intent.putExtra(FILE, audio_file_received);
        sendBroadcast(intent);
    }
}

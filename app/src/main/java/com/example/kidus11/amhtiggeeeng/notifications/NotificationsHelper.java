package com.example.kidus11.amhtiggeeeng.notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.kidus11.amhtiggeeeng.Activities.MusicPlayerAct;
import com.example.kidus11.amhtiggeeeng.R;

/**
 * Created by valerica.spoiala on 2/23/2018.
 */

public class NotificationsHelper
{
    private static final String ANDROID_CHANNEL_ID = "com.example.kidus11.amhtiggeeeng.notifications";
    private static final String ANDROID_CHANNEL_NAME = "CHANNEL";
    public static void showNotification(Activity activity)
    {


        Context context = activity.getApplicationContext();
        final Intent emptyIntent = new Intent(context, MusicPlayerAct.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, emptyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder notifBuilder;
       
        // Actions are just fake
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT == Build.VERSION_CODES.O)
        {
            NotificationChannel channel = createChannels();
            notifBuilder = new Notification.Builder(context,ANDROID_CHANNEL_ID);
            notificationManager.createNotificationChannel(channel);
        }
        else
            notifBuilder = new Notification.Builder(context);

        notifBuilder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Audio is playing")
                .setContentText("click to open audio")
                .setOnlyAlertOnce(true)
                .setSmallIcon(R.drawable.ic_play_arrow_black_48dp)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);
            notificationManager.notify(0, notifBuilder.build());
        

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static NotificationChannel createChannels() {

        // create android channel
        NotificationChannel androidChannel = new NotificationChannel(ANDROID_CHANNEL_ID,
                ANDROID_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        // Sets whether notifications posted to this channel should display notification lights
        androidChannel.enableLights(true);
        // Sets whether notification posted to this channel should vibrate.
        androidChannel.enableVibration(true);
        // Sets the notification light color for notifications posted to this channel
        androidChannel.setLightColor(Color.GREEN);
        // Sets whether notifications posted to this channel appear on the lockscreen or not
        androidChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        return androidChannel;
    }
}

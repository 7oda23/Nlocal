package com.example.a7oda.AccountSaver;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

public class MediaService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String Show  = intent.getStringExtra("show");
        Intent notiintent = new Intent(this , MainActivity.class);
        PendingIntent    pendingIntent = PendingIntent.getActivity(this , 0 , notiintent,0 );
        Notification noti   = new NotificationCompat.Builder(this,"Channel1")
                .setSmallIcon(R.drawable.person)
                .setContentTitle("U now can show All ")
                .setContentText("Don't foreget to resecure")
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentIntent(pendingIntent)
                .build();
        startForeground(2,noti);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

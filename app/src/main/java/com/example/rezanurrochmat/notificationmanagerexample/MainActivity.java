package com.example.rezanurrochmat.notificationmanagerexample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void createNotification(View view){
        Intent intent = new Intent(this, NotificationReceiverActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int)System.currentTimeMillis(),intent,0);
        Notification noti = new Notification.Builder(this)
                .setContentTitle("New message from golab")
                .setContentText("Subject").setSmallIcon(R.drawable.icon)
                                            .setContentIntent(pIntent)
                                            .addAction(R.drawable.icon, "Call", pIntent)
                                            .addAction(R.drawable.icon, "More", pIntent)
                                            .addAction(R.drawable.icon, "And more", pIntent).build();

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        noti.flags |= Notification.FLAG_AUTO_CANCEL;
        noti.defaults |= Notification.DEFAULT_SOUND;
        noti.defaults |= Notification.DEFAULT_VIBRATE;
        notificationManager.notify(0,noti);
    }
}

package com.example.innovaneers;

import static android.content.Context.NOTIFICATION_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public class AlarmReceiver extends BroadcastReceiver {
    private static final String CHANNEL_ID="My Channel";
    private static final int NOTIFICATION_ID=100;
String globalDescription ;
    @Override
    public void onReceive(Context context, Intent intent) {
       // Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.baseline_circle_notifications_24_orange,null);
      //  BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
      //  Bitmap largeIcon =bitmapDrawable.getBitmap();
       // String value = getIntent.getExtra("worklink");
       // Intent i = ((Activity)context).getIntent();
      //  if (i != null){
      //      String Description = i.getStringExtra("Description");
      //      globalDescription = Description;
      //  }
        NotificationManager nm=(NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification =new Notification.Builder(context)
                 //   .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.innovaneers)
                    .setColor(ContextCompat.getColor(context, R.color.primary))
                    .setContentText("your Meeting")
                    .setSubText("")
                    .setChannelId(CHANNEL_ID)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New Channel",NotificationManager.IMPORTANCE_HIGH));
        }else{
            notification =new Notification.Builder(context)
                  //  .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.innovaneers)
                    .setContentText("New Message")
                    .setSubText("New Message from Raman")
                    .build();
        }
        nm.notify(NOTIFICATION_ID,notification);




        Toast.makeText(context, "Alarm Triggered", Toast.LENGTH_SHORT).show();
    }
}

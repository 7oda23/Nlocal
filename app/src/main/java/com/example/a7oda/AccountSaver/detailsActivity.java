package com.example.a7oda.AccountSaver;

import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class detailsActivity extends AppCompatActivity {
    private static final String TAG = null;
    private TextView name;
    private TextView pass;
    private TextView email;
    private TextView phone;
    public NotificationCompat.Builder noti;
    private  int id = 0 ;
    private person y=new person();
    private PersonsDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name = findViewById(R.id.nameview);
        pass = findViewById(R.id.passview);
        email = findViewById(R.id.emailview);
        phone = findViewById(R.id.phoneview);
        y = (person) getIntent().getSerializableExtra("personclicked");
        name.setText(y.getName());
        pass.setText(y.getPass());
        email.setText(y.getEmail());
        phone.setText("+20" + y.getPhone());
        noti   = new NotificationCompat.Builder(this,"Channel1"+id)
                .setSmallIcon(R.drawable.person)
                .setContentTitle(y.getName())
                .setContentText("u Viewed this person"+y.getName())
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(id,noti.build());
        id++;
        }
    }

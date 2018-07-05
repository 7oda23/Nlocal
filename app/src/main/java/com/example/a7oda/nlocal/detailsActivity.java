package com.example.a7oda.nlocal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class detailsActivity extends AppCompatActivity {
    private TextView name;
    private TextView pass;
    private TextView email;
    private TextView phone;
    private person2 y=new person2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name = findViewById(R.id.nameview);
        pass = findViewById(R.id.passview);
        email = findViewById(R.id.emailview);
        phone = findViewById(R.id.phoneview);
        y = (person2) getIntent().getSerializableExtra("person");
    /*y = getIntent().getExtras().getParcelable("person");
        Bundle data = getIntent().getExtras();
        y= data.getParcelable("person");*/
        name.setText(y.getName());
        pass.setText(y.getPass());
        email.setText(y.getEmail());
        phone.setText("+20" + y.getPhone());
    }
}

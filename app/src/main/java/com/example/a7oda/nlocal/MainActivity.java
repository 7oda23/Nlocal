package com.example.a7oda.nlocal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public person2 x = new person2();
    private EditText name;
    private EditText email;
    private EditText phone;
    private EditText pass;
    private Button go;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        go = findViewById(R.id.makeB);


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x.setName(name.getText().toString());
                x.setEmail(email.getText().toString());
                x.setPass(pass.getText().toString());
                x.setPhone(Integer.parseInt((phone.getText().toString())));
                Intent intent = new Intent(MainActivity.this, detailsActivity.class);
                intent.putExtra("person", x);
                startActivity(intent);
            }
        });

    }
}

package com.example.a7oda.nlocal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    public person2 x = new person2();
    private EditText name;
    private EditText email;
    private EditText phone;
    private EditText pass;
    private Button go;
    private int flag = 0;
    private Pattern p = Pattern.compile("[a-zA-z]") ;
    public Boolean isempty(EditText x)
    {
        if(x.getText().length()==0)
        {
            return true;
        }
        else return false;
    }

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
                flag = 0 ;
                if(isempty(name)  )
                {
                    flag++;
                //    Toast.makeText(MainActivity.this,"name is empty",Toast.LENGTH_SHORT ).show();
                    name.setError("name is requierd ");
                }
                else
                {
                    x.setName(name.getText().toString());
                }
                if(isempty(phone))
                {
                    flag++;
                  //  Toast.makeText(MainActivity.this,"phone is empty",Toast.LENGTH_SHORT ).show();
                    phone.setError("phone is requierd ");
                }
                else if(!Patterns.PHONE.matcher(phone.getText()).matches())
                {
                    phone.setError("phone form is wrong");
                    flag++;

                }
                else
                {
                    x.setPhone(Integer.parseInt((phone.getText().toString())));
                }
                if(isempty(pass))
                {
                    flag++;
                  //  Toast.makeText(MainActivity.this,"pass is empty",Toast.LENGTH_SHORT ).show();
                    pass.setError("pass is requierd ");

                }
                else
                {
                    x.setPass(pass.getText().toString());
                }
                if(isempty(email))
                {
                    flag++;
               //     Toast.makeText(MainActivity.this,"email is empty",Toast.LENGTH_SHORT ).show();
                    email.setError("email is requierd ");

                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches())
                {
                    email.setError("email form is wrong");
                    flag++;
                }
                else
                {
                    x.setEmail(email.getText().toString());
                }
                if(flag==0) {
                    Intent intent = new Intent(MainActivity.this, detailsActivity.class);
                    intent.putExtra("person", x);
                    startActivity(intent);
                }
            }
        });

    }
}

package com.example.a7oda.nlocal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static android.view.View.GONE;


public class MainActivity extends AppCompatActivity {
    PersonsDB db ;
    public ArrayList<person> y=new ArrayList<>();
    private EditText name;
    private int flag;
    private EditText email;
    private EditText phone;
    private EditText pass;
    private Button add;
    private Button show;
    private Button update;
    person x=new person();
    person updatep=new person();
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
        add = findViewById(R.id.makeB);
        show = findViewById(R.id.showB);
        update = findViewById(R.id.Update);
        db = new PersonsDB(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 0 ;
                x= new person();
                if(isempty(name)  )
                {
                    flag++;
                    name.setError("name is requierd ");
                }
                if(isempty(phone))
                {
                    flag++;
                    phone.setError("phone is requierd ");
                }
                else if(!Patterns.PHONE.matcher(phone.getText()).matches())
                {
                    phone.setError("phone form is wrong");
                    flag++;

                }
                if(isempty(pass))
                {
                    flag++;
                    pass.setError("pass is requierd ");

                }
                if(isempty(email))
                {
                    flag++;
                    email.setError("email is requierd ");

                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches())
                {
                    email.setError("email form is wrong");
                    flag++;
                }
                if(flag==0) {
                   x= new person(name.getText().toString(),pass.getText().toString(),email.getText().toString(),Integer.parseInt(phone.getText().toString()));
                    x.setName(name.getText().toString());
                    x.setEmail(email.getText().toString());
                    x.setPhone(Integer.parseInt(phone.getText().toString()));
                    x.setPass(pass.getText().toString());
                  if(db.insertD(x))
                    {
                        Toast.makeText(MainActivity.this, "person is added  ", Toast.LENGTH_SHORT).show();
                    }
                    name.setText("");
                    pass.setText("");
                    phone.setText("");
                    email.setText("");
                }
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y.clear();
                y.addAll(db.showall());
                if(y.size()==0)
                {
                    Toast.makeText(MainActivity.this, "no persons yet", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, PersonActivity.class);
                    intent.putExtra("person", y);
                    startActivity(intent);
                    startservice(show);
                }
            }
        });
//          update part
        updatep = (person) getIntent().getSerializableExtra("Pupdate");
        if(updatep != null) {
           show.setVisibility(View.INVISIBLE);
           add.setVisibility(View.INVISIBLE);
           update.setVisibility(View.VISIBLE);
            name.setText(updatep.getName());
            pass.setText(updatep.getPass());
            phone.setText(""+updatep.getPhone());
            email.setText(updatep.getEmail());
        }
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 0 ;
                x= new person();
                if(isempty(name)  )
                {
                    flag++;
                    name.setError("name is requierd ");
                }
                if(isempty(phone))
                {
                    flag++;
                    phone.setError("phone is requierd ");
                }
                else if(!Patterns.PHONE.matcher(phone.getText()).matches())
                {
                    phone.setError("phone form is wrong");
                    flag++;

                }
                if(isempty(pass))
                {
                    flag++;
                    pass.setError("pass is requierd ");

                }
                if(isempty(email))
                {
                    flag++;
                    email.setError("email is requierd ");

                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches())
                {
                    email.setError("email form is wrong");
                    flag++;
                }
                if(flag==0) {
                    x= new person(name.getText().toString(),pass.getText().toString(),email.getText().toString(),Integer.parseInt(phone.getText().toString()));
                    x.setName(name.getText().toString());
                    x.setEmail(email.getText().toString());
                    x.setPhone(Integer.parseInt(phone.getText().toString()));
                    x.setPass(pass.getText().toString());
                    if(db.updateperson(x,updatep))
                    {
                        Toast.makeText(MainActivity.this, "person is updated  ", Toast.LENGTH_SHORT).show();
                    }
                }
                y.clear();
                y.addAll(db.showall());
                if(y.size()==0)
                {
                    Toast.makeText(MainActivity.this, "no persons yet", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, PersonActivity.class);
                    intent.putExtra("person", y);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    public void startservice(View v )
    {
        String show = "U can now see All .";
        Intent service = new Intent(this , MediaService.class);
        service.putExtra("show",show);
        startService(service);
    }
    public void stopservice(View v){
        Intent service = new Intent(this , MediaService.class);
        stopService(service);
    }

}

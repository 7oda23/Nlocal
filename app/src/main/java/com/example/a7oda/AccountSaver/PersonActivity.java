package com.example.a7oda.AccountSaver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class PersonActivity extends AppCompatActivity {
    public RecyclerView rec;
    public PersonAdpter adapter;
    public ArrayList<person> y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_l);
        rec = findViewById(R.id.recycle);
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this);
        rec.setLayoutManager(LinearLayoutManager);
        y2 = new ArrayList<>();
        y2 = (ArrayList<person>) getIntent().getSerializableExtra("person");
        adapter = new PersonAdpter(PersonActivity.this, y2);
        rec.setAdapter(adapter);
    }
}

package com.example.a7oda.nlocal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class PersonsDB extends SQLiteOpenHelper {
    int i ;
    public PersonsDB(Context context) {
        super(context, "Persons", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Person (ID INTEGER PRIMARY KEY AUTOINCREMENT  ,Name TEXT ,phone INTEGER ,Email TEXT ,PASSWORD TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Person");
        onCreate(db);
    }
    public boolean insertD(person p )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("Name",p.getName());
        contentvalues.put("Email",p.getEmail());
        contentvalues.put("phone",p.getPhone());
        contentvalues.put("PASSWORD",p.getPass());
        if(db.insert("Person",null,contentvalues)== -1)
        {
            return false;
        }
        else return true;
    }
    public ArrayList<person> showall()
    {
         ArrayList<person> personList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from person", null);
        while (res.moveToNext())
        {
            person p = new person();
            if(res.getString(0)!=null ) {
                p.setName(res.getString(1));
                p.setEmail(res.getString(3));
                p.setPhone(res.getInt(2));
                p.setPass(res.getString(4));
                personList.add(p);
            }
        }

        return personList;
    }
    public  boolean deletePerson(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
            return db.delete("Person","Name ='"+name+"'",null)>0;
    }
    public boolean updateperson(person p,person old ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("Name",p.getName());
        contentvalues.put("Email",p.getEmail());
        contentvalues.put("phone",p.getPhone());
        contentvalues.put("PASSWORD",p.getPass());
        return db.update("Person",contentvalues,"Name = '"+old.getName()+"'",null)>0;
    }
}

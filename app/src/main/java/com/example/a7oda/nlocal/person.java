package com.example.a7oda.nlocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;

public class person implements Parcelable{
        public String name,pass,email;
        int phone;
        public Button GO;
        person(){}

    protected person(Parcel in) {
    }

    public static final Creator<person> CREATOR = new Creator<person>() {
        @Override
        public person createFromParcel(Parcel in) {
            return new person(in);
        }

        @Override
        public person[] newArray(int size) {
            return new person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }
}

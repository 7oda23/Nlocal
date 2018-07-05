package com.example.a7oda.nlocal;

import android.widget.Button;

import java.io.Serializable;

public class person2 implements Serializable {
        public String name,pass,email;
        int phone;
        public Button GO;
        public person2(){}
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getPass() {
                return pass;
        }

        public void setPass(String pass) {
                this.pass = pass;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public int getPhone() {
                return phone;
        }

        public void setPhone(int phone) {
                this.phone = phone;
        }

        public Button getGO() {
                return GO;
        }

        public void setGO(Button GO) {
                this.GO = GO;
        }


}

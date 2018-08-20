package com.example.a7oda.AccountSaver;

import java.io.Serializable;

public class person implements Serializable {
        public String name,pass,email;
        int phone;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        int id;

        public person(String name, String pass, String email, int phone) {
                this.name = name;
                this.pass = pass;
                this.email = email;
                this.phone = phone;
        }
        public person(String name, String email) {
                this.name = name;
                this.email= email;
        }
        public person(){}
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



}

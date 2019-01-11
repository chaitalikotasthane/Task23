package com.example.android.firebasecloud;



public class UsersClass {

        private String name;
        private int age;
    public UsersClass()
    {

    }
        public UsersClass(String name, int age){
            this.name=name;
            this.age=age;
        }
        public String getName()
        {
            return name;
        }
        public int getAge()
        {
            return age;
        }

    }


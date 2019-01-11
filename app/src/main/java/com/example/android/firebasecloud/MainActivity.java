package com.example.android.firebasecloud;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<UsersClass> li=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final RecyclerView mrecyclerview;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mrecyclerview=(RecyclerView)findViewById(R.id.recyclerview);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users");


        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            Adapter madapter;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    li.add(new UsersClass(childSnapshot.child("Name").getValue(String.class),childSnapshot.child("Age").getValue(Integer.class)));
                }

                madapter=new Adapter(getApplicationContext(),li);

                madapter.notifyDataSetChanged();
                mrecyclerview.setAdapter(madapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }



        });

    }




}






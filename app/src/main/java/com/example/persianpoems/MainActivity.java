package com.example.persianpoems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String s1[],s2[],s3[];
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting string arrays
        s1=getResources().getStringArray(R.array.title);
        s2=getResources().getStringArray(R.array.category);
        s3=getResources().getStringArray(R.array.poem);
        //getting recycler view id
        recyclerView = findViewById(R.id.RecyclerView);
        // intializing Adapter - making an object from class and sending datas
        MYAdapter myAdapter = new MYAdapter(this,s1,s2,s3);
        //binding activity to adapter class
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}
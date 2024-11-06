package com.example.noteapmain;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        floatingActionButton = findViewById(R.id.add);



        NoteDBHelper noteDBHelper = NoteDBHelper.getdb(this);
        List<NoteEntity> noteList = noteDBHelper.noteDao().getAllNotes();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        NoteAdapterRecylerView adapter = new NoteAdapterRecylerView(noteList,this);

        recyclerView.setAdapter(adapter);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext = new Intent(MainActivity.this, addUpdateActivity.class);
                startActivity(inext);
                finish();
            }
        });

    }





}


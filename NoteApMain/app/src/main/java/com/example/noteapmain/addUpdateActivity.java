package com.example.noteapmain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class addUpdateActivity extends AppCompatActivity {

    EditText content;
    EditText tittle;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_update);

        content=findViewById(R.id.Notecontent);
        btn=findViewById(R.id.addBtn);
        tittle=findViewById(R.id.noteTitle);



        NoteDBHelper noteDBHelper=NoteDBHelper.getdb(this);

        Intent intent=getIntent();

        // extracting value from intent
        String contentStr=intent.getStringExtra("content");
        String titleStr=intent.getStringExtra("title");
        int id=intent.getIntExtra("id",0);

//        content.setText( intent.getStringExtra("content"));
//        id.setText( intent.getStringExtra("id"));

        if (contentStr!=null && titleStr!=null) {
            btn.setText("Update");
            content.setText( contentStr);
            tittle.setText(titleStr);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String updatedContent = content.getText().toString();
                    String updateTitle=tittle.getText().toString();
                    noteDBHelper.noteDao().updateData(new NoteEntity(id,updatedContent,updateTitle));
                    Intent intent=new Intent(addUpdateActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });


        }
        else  {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String contentInStr=content.getText().toString();
                    String tittleInStr=tittle.getText().toString();
                    if (!tittleInStr.equals("") && !contentInStr.equals("")) {
                        noteDBHelper.noteDao().addNote(new NoteEntity(contentInStr,tittleInStr));
                        Intent intent=new Intent(addUpdateActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }


                }
            });

        }


        /*Activity
        //1. onCreate
        //2. onStart
        //3. onResume
        4. onPause
        5. onStop
        6. onRestart
        7. onDestory

        Fragment--
        1. onAttach
        2. onCreate
        3. onCreateView
        4. onViewCreated //
        5. onStart
        6. onResume
        7. onPause
        8. onStop
        9. onDestoryView
        10. onDestory
        11 . onDetach


         */

    }
}
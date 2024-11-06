package com.example.noteapmain;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = NoteEntity.class,exportSchema = false,version = 1)
public abstract class NoteDBHelper extends RoomDatabase {
    public static final String DB_NAME="notedb";

    public abstract NoteDao noteDao();
    public static NoteDBHelper instance;

    public static synchronized NoteDBHelper getdb(Context context){

        if (instance == null) {
            instance= Room.databaseBuilder(context, NoteDBHelper.class,DB_NAME).allowMainThreadQueries().build();

        }

        return instance;
    }
}

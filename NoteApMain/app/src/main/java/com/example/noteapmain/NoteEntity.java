package com.example.noteapmain;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class NoteEntity {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo
    String noteData;

    @ColumnInfo
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteData() {
        return noteData;
    }

    public void setNoteData(String noteData) {
        this.noteData = noteData;
    }

    NoteEntity(String noteData,String title){
        this.noteData=noteData;
        this.title=title;
    }

    @Ignore
    NoteEntity(int id,String noteData,String title){
        this.id=id;
        this.noteData=noteData;
        this.title=title;

    }
}

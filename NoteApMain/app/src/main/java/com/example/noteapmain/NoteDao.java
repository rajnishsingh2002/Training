package com.example.noteapmain;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void addNote(NoteEntity noteEntity);

    @Query("SELECT * FROM notes")
    List<NoteEntity> getAllNotes();

    @Delete
    void deleteNoteById(NoteEntity noteEntity);

    @Update
    void updateData(NoteEntity noteEntity);
}

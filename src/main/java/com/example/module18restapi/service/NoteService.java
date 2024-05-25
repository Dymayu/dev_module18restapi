package com.example.module18restapi.service;

import com.example.module18restapi.entity.Note;

import java.util.List;

public interface NoteService {

    List<Note> getAllNotes();
    Note createNote(Note note);
    Note getNoteById(long id);
    Note updateNote(Note note);
    void deleteNote(long id);

}

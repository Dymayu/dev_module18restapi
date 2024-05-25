package com.example.module18restapi.service;

import com.example.module18restapi.entity.Note;
import com.example.module18restapi.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note getNoteById(long id) {
        return noteRepository.getReferenceById(id);
    }

    @Override
    public Note updateNote(Note note) {
        Note updNote = noteRepository.getReferenceById(note.getId());
        updNote.setTitle(note.getTitle());
        updNote.setContent(note.getContent());
        noteRepository.save(updNote);
        return updNote;
    }

    @Override
    public void deleteNote(long id) {
        noteRepository.deleteById(id);
    }
}

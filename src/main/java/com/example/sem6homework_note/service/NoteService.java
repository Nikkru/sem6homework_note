package com.example.sem6homework_note.service;

import com.example.sem6homework_note.model.Note;
import com.example.sem6homework_note.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id){
        return noteRepository.findById(id).orElse(null);
    }

    public Note saveOreUpdate(Note note){
        return noteRepository.save(note);
    }

    public void deleteNoteById(Long id){
        noteRepository.deleteById(id);
    }
}

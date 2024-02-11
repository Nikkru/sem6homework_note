package com.example.sem6homework_note.controller;

import com.example.sem6homework_note.model.Note;
import com.example.sem6homework_note.repository.NoteRepository;
import com.example.sem6homework_note.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final NoteRepository noteRepository;
    private final NoteService noteService;

    @GetMapping
    public List<Note> getAll(){
        return noteService.getAllNotes();
    }

    @PutMapping("/add")
    public Note updateNote(@RequestBody Note updateNote, @PathVariable("id") Long id){
        Note note = noteService.getNoteById(id);
        note.setTitle(updateNote.getTitle());
        note.setContent(updateNote.getContent());
        return noteService.saveOreUpdate(note);
    }

    @GetMapping("/{id}")
    public Note getById(@PathVariable("id") Long id){
        return noteService.getNoteById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        noteService.deleteNoteById(id);
    }

    @PostMapping("/{id}")
    public Note createNote(@RequestBody Note note){
        return noteService.saveOreUpdate(note);
    }
}

package com.example.sem6homework_note.controller;

import com.example.sem6homework_note.model.Note;
import com.example.sem6homework_note.repository.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final NoteRepository noteRepository;

    @GetMapping
    public List<Note> getAll(){
        return noteRepository.findAll();
    }

    @PostMapping("/add")
    public Note addNew(@RequestBody Note note){
        return noteRepository.save(note);
    }


}

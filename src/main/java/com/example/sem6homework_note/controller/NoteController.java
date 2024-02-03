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

    @GetMapping("/{id}")
    public Note getById(@PathVariable("id") Long id){
        return noteRepository.findById(id).orElseThrow();
    }

    /**
     *
     * @param note редактированная запись
     * @param id - идентификатор редактируемой записи
     * @return отредактированная запись
     */
    @PutMapping("/{id}")
    public Note editById(@RequestBody Note note, @PathVariable("id") Long id){
        note.setId(id);
        return noteRepository.save(note);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long id){
        noteRepository.deleteById(id);
    }
}

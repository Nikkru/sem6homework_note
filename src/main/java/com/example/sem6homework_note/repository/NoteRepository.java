package com.example.sem6homework_note.repository;

import com.example.sem6homework_note.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}

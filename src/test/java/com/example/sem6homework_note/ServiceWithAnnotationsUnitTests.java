package com.example.sem6homework_note;

import com.example.sem6homework_note.model.Note;
import com.example.sem6homework_note.repository.NoteRepository;
import com.example.sem6homework_note.service.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceWithAnnotationsUnitTests {
    @Mock
    public NoteRepository noteRepository;
    @InjectMocks
    public NoteService noteService;

    /**
     * проверка метода молучения списка всех записей
     */
    @Test
    public void getAllNotesTest(){
        Note note = new Note();
        note.setTitle("New test tittle");
        note.setContent("Try add new note right now.");
        List<Note> expectedNotes = Collections.singletonList(note);
        when(noteRepository.findAll()).thenReturn(expectedNotes);
        List<Note> actualNotes = noteService.getAllNotes();
        assertEquals(expectedNotes, actualNotes);
//        assertEquals(1, actualNotes.size());
    }

    /**
     * проверка получения метода по id
     */
    @Test
    public void getNoteById(){
        Note note = new Note();
        note.setTitle("New test by id");
        note.setContent("Try get new note right now.");
        Note expectedNote = note;
        Long id = note.getId();
        when(noteRepository.findById(id)).thenReturn(Optional.of(note));
        Note actualNote = noteService.getNoteById(id);
        assertEquals(expectedNote, actualNote);
    }

    /**
     * проверка метода создания записи
     */
    @Test
    public void createNote(){
        Note note = new Note();
        note.setTitle("New test create");
        note.setContent("Try get new note right now.");
        note.setId(1L);
        Note expectedNote = note;
        List<Note> expectedNotes = Collections.singletonList(note);
        when(noteRepository.findAll()).thenReturn(expectedNotes);
        noteService.saveOreUpdate(note);
        Note actualNote = noteService.getAllNotes().get(0);
        assertEquals(expectedNote, actualNote);
    }

    /**
     * проверка метода удаления записи
     * @throws Exception
     */
    @Test
    public void deleteNoteById() throws Exception{
        Note note = new Note();
        note.setTitle("New test create");
        note.setContent("Try get new note right now.");
        Long id = note.getId();
        noteRepository.save(note);
        assertAll(()-> noteService.deleteNoteById(id));
    }

    /**
     * проверка метода обновления записи
     */
    @Test
    public void updateNoteById(){
        Note note = new Note();
        note.setTitle("New test create");
        note.setContent("Try get new note right now.");
        Long id = note.getId();
        when(noteRepository.save(Mockito.any(Note.class))).thenReturn(note);
        Note savedNote = noteService.saveOreUpdate(note);
        assertThat(savedNote).isNotNull();
    }
}

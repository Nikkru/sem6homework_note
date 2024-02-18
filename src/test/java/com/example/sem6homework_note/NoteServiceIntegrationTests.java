package com.example.sem6homework_note;
import com.example.sem6homework_note.model.Note;
import com.example.sem6homework_note.repository.NoteRepository;
import com.example.sem6homework_note.service.NoteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
public class NoteServiceIntegrationTests {

    @MockBean
    private NoteRepository noteRepository;

    @Autowired
    private NoteService noteService;

    @Test
    void updateNoteTest(){
        Note note = new Note();
        note.setTitle("First");
        note.setContent("First Content");
        note.setId(1L);
        noteService.saveOreUpdate(note);
        assertNotNull(note.getId());

    }
}

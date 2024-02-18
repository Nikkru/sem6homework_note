package com.example.sem6homework_note;

import ch.qos.logback.core.net.server.Client;
import com.example.sem6homework_note.model.Note;
import com.example.sem6homework_note.repository.NoteRepository;
import com.example.sem6homework_note.service.NoteService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
//@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteServiceIntegrationTests {

    @MockBean
    private NoteRepository noteRepository;

    @Autowired
    private NoteService noteService;

//    @Autowired
//    private TestRestTemplate restTemplate;

    @Test
    void updateNoteTest(){
        Note note = new Note();
        note.setTitle("First");
        note.setContent("First Content");
        noteService.saveOreUpdate(note);
        assertNotNull(note.getId());

    }
}

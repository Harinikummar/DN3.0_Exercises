package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookController bookController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    void testGetBooks() throws Exception {
        Book book = new Book(1L, "Title", "Author", 20.0, "1234567890");
        List<Book> books = new ArrayList<>();
        books.add(book);
        when(bookRepository.findAll()).thenReturn(books);

        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title").value("Title"));
    }

    @Test
    void testGetBookById() throws Exception {
        Book book = new Book(1L, "Title", "Author", 20.0, "1234567890");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        mockMvc.perform(MockMvcRequestBuilders.get("/books/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("Title"));
    }

    @Test
    void testCreateBook() throws Exception {
        Book book = new Book(1L, "Title", "Author", 20.0, "1234567890");
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("Title"));
    }

    @Test
    void testUpdateBook() throws Exception {
        Book book = new Book(1L, "Updated Title", "Updated Author", 25.0, "1234567890");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.put("/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("Updated Title"));
    }

    @Test
    void testDeleteBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/books/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}

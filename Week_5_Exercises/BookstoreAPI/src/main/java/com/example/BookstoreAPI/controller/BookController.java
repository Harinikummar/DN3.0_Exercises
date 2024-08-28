package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.model.BookModel;
import com.example.BookstoreAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.BookstoreAPI.assembler.BookModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    private List<Book> bookList = new ArrayList<>();

    @Autowired
    private BookModelAssembler assembler;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Create a new book
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Read all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Read a single book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET all books
    public CollectionModel<BookModel> getBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {

        List<BookModel> books = new ArrayList<>();
        for (Book book : bookList) {
            books.add(assembler.toModel(book));
        }

        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(BookController.class).getBooks(null, null));

        if (title != null || author != null) {
            linkBuilder = linkTo(methodOn(BookController.class).getBooks(title, author));
        }

        return CollectionModel.of(books, linkBuilder.withSelfRel());
    }

    // Update a book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book bookDetails) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(bookDetails.getTitle());
                    book.setAuthor(bookDetails.getAuthor());
                    book.setPrice(bookDetails.getPrice());
                    book.setIsbn(bookDetails.getIsbn());
                    Book updatedBook = bookRepository.save(book);
                    return ResponseEntity.ok(updatedBook);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a book
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}

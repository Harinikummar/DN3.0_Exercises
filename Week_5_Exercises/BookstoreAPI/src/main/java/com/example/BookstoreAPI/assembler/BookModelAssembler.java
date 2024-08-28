package com.example.BookstoreAPI.assembler;

import com.example.BookstoreAPI.controller.BookController;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.model.BookModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class BookModelAssembler extends RepresentationModelAssemblerSupport<Book, BookModel> {

    public BookModelAssembler() {
        super(BookController.class, BookModel.class);
    }

    @Override
    public BookModel toModel(Book book) {
        BookModel bookModel = new BookModel();
        bookModel.setId(book.getId());
        bookModel.setTitle(book.getTitle());
        bookModel.setAuthor(book.getAuthor());
        bookModel.setPrice(book.getPrice());
        bookModel.setIsbn(book.getIsbn());

        // Add self link
        bookModel.add(linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel());

        bookModel.add(linkTo(methodOn(BookController.class).getBooks(null, null)).withRel("books"));

        return bookModel;
    }
}


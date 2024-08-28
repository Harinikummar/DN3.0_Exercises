package com.example.BookstoreAPI.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
public class BookModel extends RepresentationModel<BookModel> {
    private Long id;
    private String title;
    private String author;
    private double price;
    private String isbn;
}

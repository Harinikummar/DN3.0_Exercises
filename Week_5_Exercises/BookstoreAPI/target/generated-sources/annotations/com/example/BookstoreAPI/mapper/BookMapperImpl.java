package com.example.BookstoreAPI.mapper;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.model.Book;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T14:51:17+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO bookToBookDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setId( book.getId() );
        bookDTO.setTitle( book.getTitle() );
        bookDTO.setAuthor( book.getAuthor() );
        bookDTO.setPrice( book.getPrice() );
        bookDTO.setIsbn( book.getIsbn() );

        return bookDTO;
    }

    @Override
    public Book bookDTOToBook(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDTO.getId() );
        book.setTitle( bookDTO.getTitle() );
        book.setAuthor( bookDTO.getAuthor() );
        book.setPrice( bookDTO.getPrice() );
        book.setIsbn( bookDTO.getIsbn() );

        return book;
    }
}

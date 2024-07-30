package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(101, "Book1", "Author1"));
        books.add(new Book(102, "Book4", "Author4"));
        books.add(new Book(103, "Book2", "Author2"));
        books.add(new Book(104, "Book5", "Author5"));
        books.add(new Book(105, "Book3", "Author3"));

        // Linear search
        String searchTitle = "Book3";
        Book foundBook = Library.linearSearchByTitle(books, searchTitle);
        System.out.println("Linear Search:");
        if (foundBook != null) {
            System.out.println("Found: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }

        Collections.sort(books, Comparator.comparing(Book::getTitle));

        // Binary search
        foundBook = Library.binarySearchByTitle(books, searchTitle);
        System.out.println("\nBinary Search:");
        if (foundBook != null) {
            System.out.println("Found: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }
    }
}


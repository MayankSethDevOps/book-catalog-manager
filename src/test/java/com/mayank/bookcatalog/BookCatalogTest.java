package com.mayank.bookcatalog;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class BookCatalogTest {

    @Test
    public void testAddBook() {
        BookCatalog catalog = new BookCatalog();
        Book book = new Book("Test Book", "Test Author", 2023);
        catalog.addBook(book);

        List<Book> books = catalog.listBooks();
        assertEquals(1, books.size());
        assertEquals("Test Book", books.get(0).getTitle());
    }

    @Test
    public void testSearchByTitle() {
        BookCatalog catalog = new BookCatalog();
        catalog.addBook(new Book("Clean Code", "Robert Martin", 2008));
        catalog.addBook(new Book("The Clean Coder", "Robert Martin", 2011));

        List<Book> results = catalog.searchByTitle("Clean");
        assertEquals(2, results.size());
    }

    @Test
    public void testSortByAuthor() {
        BookCatalog catalog = new BookCatalog();
        catalog.addBook(new Book("Z Book", "Charlie", 2020));
        catalog.addBook(new Book("A Book", "Alice", 2018));
        catalog.addBook(new Book("B Book", "Bob", 2019));

        List<Book> sorted = catalog.sortByAuthor();
        assertEquals("Alice", sorted.get(0).getAuthor());
        assertEquals("Bob", sorted.get(1).getAuthor());
        assertEquals("Charlie", sorted.get(2).getAuthor());
    }

    @Test
    public void testSortByYear() {
        BookCatalog catalog = new BookCatalog();
        catalog.addBook(new Book("Old Book", "Author A", 1995));
        catalog.addBook(new Book("New Book", "Author B", 2020));

        List<Book> sorted = catalog.sortByYear();
        assertEquals(1995, sorted.get(0).getYear());
        assertEquals(2020, sorted.get(1).getYear());
    }
}

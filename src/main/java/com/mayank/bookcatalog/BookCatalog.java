package com.mayank.bookcatalog;

import java.util.*;

public class BookCatalog {
    private List<Book> catalog = new ArrayList<>();

    public void addBook(Book book) {
        catalog.add(book);
    }

    public List<Book> listBooks() {
        return catalog;
    }

    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : catalog) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> sortByAuthor() {
        List<Book> sorted = new ArrayList<>(catalog);
        sorted.sort(Comparator.comparing(Book::getAuthor));
        return sorted;
    }

    public List<Book> sortByYear() {
        List<Book> sorted = new ArrayList<>(catalog);
        sorted.sort(Comparator.comparingInt(Book::getYear));
        return sorted;
    }

    public static void main(String[] args) {
        BookCatalog catalog = new BookCatalog();

        // Sample input using args (optional enhancement)
        if (args.length >= 3) {
            String title = args[0];
            String author = args[1];
            int year = Integer.parseInt(args[2]);
            catalog.addBook(new Book(title, author, year));
        }

        // Add some hardcoded books for testing
        catalog.addBook(new Book("Atomic Habits", "James Clear", 2018));
        catalog.addBook(new Book("Clean Code", "Robert Martin", 2008));
        catalog.addBook(new Book("The Alchemist", "Paulo Coelho", 1988));

        System.out.println("All Books:");
        for (Book b : catalog.listBooks()) {
            System.out.println(b);
        }

        System.out.println("\nSorted by Author:");
        for (Book b : catalog.sortByAuthor()) {
            System.out.println(b);
        }

        System.out.println("\nSorted by Year:");
        for (Book b : catalog.sortByYear()) {
            System.out.println(b);
        }

        System.out.println("\nSearch by Title (e.g., 'clean'):");
        for (Book b : catalog.searchByTitle("clean")) {
            System.out.println(b);
        }
    }
}

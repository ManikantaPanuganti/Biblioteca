package com.twu.biblioteca;

import java.util.List;

public class Biblioteca {

    Library library;
    public void start() {
        System.out.println(welcome());
        setLibrary(new Library(List.of(new Book("Title","Author",2020))));
        showBooks();
    }

    String welcome() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    void setLibrary(Library library) {
        this.library = library;
    }

    void showBooks() {
        library.getBooks().stream().map(Book::getString).forEach(System.out::println);
    }
}

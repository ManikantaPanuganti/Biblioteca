package com.twu.biblioteca;

public class Biblioteca {

    Library library;
    public void start() {
        System.out.println(welcome());
        showBooks();
    }

    String welcome() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    void setLibrary(Library library) {
        this.library = library;
    }

    void showBooks() {
        library.getBooks().stream().map(Book::getTitle).forEach(System.out::println);
    }
}

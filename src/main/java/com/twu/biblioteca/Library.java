package com.twu.biblioteca;

import java.util.List;

public class Library {

    private final List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    boolean isAvailable(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                return true;
            }
        }
        return false;
    }

    Book getABook(String bookTitle) throws UnknownBook {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        throw new UnknownBook();
    }
}

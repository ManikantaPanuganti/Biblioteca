package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private ArrayList<Book> books;
    private Map<String,Book> checkOutBooks = new HashMap<>();

    public Library(ArrayList<Book> books) {
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

    void checkOut(String title) throws UnknownBook {
        if (isAvailable(title)) {
            Book book = getABook(title);
            checkOutBooks.put(title,book);
            books.remove(book);
            return;
        }
        throw new UnknownBook();
    }
    boolean isCheckedOut(String title) {
        return checkOutBooks.containsKey(title);
    }

    void returnBook(String title) throws UnknownBook {
        if (isCheckedOut(title)) {
            books.add(checkOutBooks.remove(title));
            return;
        }
        throw new UnknownBook();

    }
}

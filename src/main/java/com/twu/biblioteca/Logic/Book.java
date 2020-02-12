package com.twu.biblioteca.Logic;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final int publication_year;

    public Book(String title, String author, int publication_Year) {
        this.title = title;
        this.author = author;
        publication_year = publication_Year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publication_year;
    }

    public String getString() {
        return title + " " + author + " " + publication_year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}

package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    public void shouldReturnListOfBooks() {
        Book book1 = new Book("Title", "author", 2020);
        Library library = new Library(List.of(book1));

        assertThat(List.of(book1), is(equalTo(library.getBooks())));
    }

    @Test
    public void shouldTellIfABookIsThereInTheLibrary() {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);

        assertTrue(library.isAvailable("Title"));
    }

    @Test
    public void shouldGetABookIfABookIsThereInTheLibrary() throws UnknownBook {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);

        Book book = library.getABook("Title");

        assertThat(book1, is(equalTo(book)));
    }

    @Test
    public void shouldThrowExceptionIfBookIsNotThereInTheLibrary() {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);

        assertThrows(UnknownBook.class, () -> library.getABook("Title2"));
    }

}

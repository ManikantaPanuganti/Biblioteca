package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}

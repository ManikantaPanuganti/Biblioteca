package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class LibraryTest {

    @Test
    public void shouldReturnListOfBooks() {
        Book book1 = new Book("Title");
        Library library = new Library(List.of(book1));

        assertThat(List.of(book1), is(equalTo(library.getBooks())));
    }
}

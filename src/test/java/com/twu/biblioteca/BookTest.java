package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class BookTest {

    @Test
    public void shouldEqualTwoBooksWithSameTitle() {
        Book book1 = new Book("Title1", "author", 2020);
        Book book2 = new Book("Title1", "author", 2020);

        assertThat(book1, is(equalTo(book2)));
    }

    @Test
    public void shouldReturnTitleOfTheBook() {
        Book book = new Book("Title", "author", 2020);

        assertThat(book.getTitle(), is(equalTo("Title")));
    }

    @Test
    public void shouldReturnAuthorOfTheBook() {
        Book book = new Book("Title", "author", 2020);

        assertThat(book.getAuthor(), is(equalTo("author")));
    }
}

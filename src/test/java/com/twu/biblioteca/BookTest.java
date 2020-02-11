package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void shouldEqualTwoBooksWithSameTitle() {
        Book book1 = new Book("Title1");
        Book book2 = new Book("Title1");

        assertEquals(book1,book2);
    }
}

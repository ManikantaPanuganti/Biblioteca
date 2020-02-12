package com.twu.biblioteca.Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    @Test
    public void shouldGetAMovieName() {
        Movie movie = new Movie("Title",2020,"Director",1);

        assertEquals("Title",movie.getTitle());
    }
}
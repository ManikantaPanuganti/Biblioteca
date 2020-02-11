package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    Biblioteca biblioteca;

    @Test
    public void aWelcomeMessageShouldBeReturned() {
        biblioteca = new Biblioteca();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!",
                biblioteca.welcome());
    }
}

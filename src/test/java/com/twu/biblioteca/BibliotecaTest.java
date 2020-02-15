package com.twu.biblioteca;

import com.twu.biblioteca.Logic.Book;
import com.twu.biblioteca.Logic.Library;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BibliotecaTest {

    Biblioteca biblioteca;

    @Test
    public void aWelcomeMessageShouldBeReturned() {
        biblioteca = new Biblioteca();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!",
                biblioteca.welcome());
    }

    @Test
    public void shouldDisplayAListOfBooks() {
        biblioteca = new Biblioteca();
        Library library = mock(Library.class);
        when(library.getBooks()).thenReturn((ArrayList<Book>) List.of(mock(Book.class)));
        biblioteca.setLibrary(library);

        biblioteca.showBooks();

        verify(library, times(1)).getBooks();
    }
}

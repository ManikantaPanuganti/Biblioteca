package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class ListBooksTest {

    @Test
    public void shouldDisplayBooks() {
        UI ui = mock(UI.class);
        Book book = mock(Book.class);
        ListBooks listBooks = new ListBooks();
        when(ui.getLibrary()).thenReturn(new Library(List.of(book)));

        listBooks.onSelect(ui);

        verify(ui,times(1)).displayBooks();
    }
}

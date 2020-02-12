package com.twu.biblioteca.Logic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ListBooksTest {

    @Test
    public void shouldDisplayBooks() {
        LibraryUI libraryUi = mock(LibraryUI.class);
        Book book = mock(Book.class);
        when(book.getString()).thenReturn("BOOK");
        ListBooks listBooks = new ListBooks();
        Library library = mock(Library.class);
        when(library.getBooks()).thenReturn(List.of(book));

        listBooks.onSelect(libraryUi,library);

        verify(libraryUi, times(1)).display("BOOK");
    }

    @Test
    public void shouldEqualTwoSameMenuOptionListBooks() {
        ListBooks listBooks = new ListBooks();
        ListBooks listBooks2 = new ListBooks();

        assertEquals(listBooks, listBooks2);
    }
}

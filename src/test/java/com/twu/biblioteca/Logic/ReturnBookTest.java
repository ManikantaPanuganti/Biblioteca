package com.twu.biblioteca.Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class ReturnBookTest {

    @Test
    public void shouldReturnBook() throws UnknownBook {
        LibraryUI libraryUi = mock(LibraryUI.class);
        when(libraryUi.getBookTitle()).thenReturn("BOOK");
        Library library = mock(Library.class);
        ReturnBook returnBook = new ReturnBook();
        doNothing().when(library).returnBook("BOOK");

        returnBook.onSelect(libraryUi, library);

        verify(libraryUi, times(1)).handleSuccessFulReturn();
    }

    @Test
    public void shouldNotReturnBookIfBookIsNotTaken() throws UnknownBook {
        LibraryUI libraryUi = mock(LibraryUI.class);
        when(libraryUi.getBookTitle()).thenReturn("BOOK");
        Library library = mock(Library.class);
        ReturnBook returnBook = new ReturnBook();
        doThrow(UnknownBook.class).when(library).returnBook("BOOK");

        returnBook.onSelect(libraryUi, library);

        verify(libraryUi, times(1)).handleUnSuccessfulReturn();

    }

    @Test
    public void shouldGiveDescription() {

        assertEquals("Return Book",new ReturnBook().description());
    }
}

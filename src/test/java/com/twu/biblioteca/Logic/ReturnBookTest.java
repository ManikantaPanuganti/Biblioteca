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
        when(libraryUi.isLoggedIn()).thenReturn(true);
        ReturnBook returnBook = new ReturnBook();
        when(libraryUi.getUser()).thenReturn(new User("User"));
        doNothing().when(libraryUi).loginMessage();
        doNothing().when(library).returnBook("BOOK", new User("User"));

        returnBook.onSelect(libraryUi, library);

        verify(libraryUi, times(1)).handleSuccessFulReturn();
    }

    @Test
    public void shouldNotReturnBookIfBookIsNotTaken() throws UnknownBook {
        LibraryUI libraryUi = mock(LibraryUI.class);
        when(libraryUi.getBookTitle()).thenReturn("BOOK");
        Library library = mock(Library.class);
        ReturnBook returnBook = new ReturnBook();
        when(libraryUi.isLoggedIn()).thenReturn(true);
        when(libraryUi.getUser()).thenReturn(new User("User"));
        doNothing().when(libraryUi).loginMessage();
        doThrow(UnknownBook.class).when(library).returnBook("BOOK", new User("User"));

        returnBook.onSelect(libraryUi, library);

        verify(libraryUi, times(1)).handleUnSuccessfulReturn();

    }

    @Test
    public void shouldGiveDescription() {
        assertEquals("Return Book",new ReturnBook().description());
    }
}

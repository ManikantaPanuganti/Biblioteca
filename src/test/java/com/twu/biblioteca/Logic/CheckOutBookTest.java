package com.twu.biblioteca.Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CheckOutBookTest {

    @Test
    public void shouldCheckOutABook() throws UnknownBook {
        LibraryUI libraryUi = mock(LibraryUI.class);
        when(libraryUi.getBookTitle()).thenReturn("BOOK");
        Library library = mock(Library.class);
        CheckOutBook checkOutBook = new CheckOutBook();
        when(libraryUi.isLoggedIn()).thenReturn(true);
        doNothing().when(library).checkOut("BOOK", new User(""));


        checkOutBook.onSelect(libraryUi, library);

        verify(libraryUi, times(1)).handleSuccessfulCheckOut();
    }

    @Test
    public void shouldNotCheckOutABook() throws UnknownBook {
        LibraryUI libraryUi = mock(LibraryUI.class);
        when(libraryUi.getBookTitle()).thenReturn("BOOK");
        Library library = mock(Library.class);
        CheckOutBook checkOutBook = new CheckOutBook();
        when(libraryUi.isLoggedIn()).thenReturn(true);
        when(libraryUi.getUser()).thenReturn(new User("User"));
        doThrow(UnknownBook.class).when(library).checkOut("BOOK", new User("User"));


        checkOutBook.onSelect(libraryUi, library);

        verify(libraryUi, times(1)).handleUnSuccessfulCheckedOut();
    }

    @Test
    public void shouldGiveDescription() {

        assertEquals("CheckOut", new CheckOutBook().description());
    }

    @Test
    public void shouldShowLoginMessageIfTheUserNotLoggedIn() {
        LibraryUI libraryUI = mock(LibraryUI.class);
        CheckOutBook checkOutBook = new CheckOutBook();
        Library library = mock(Library.class);
        when(libraryUI.isLoggedIn()).thenReturn(false);

        checkOutBook.onSelect(libraryUI,library);

        verify(libraryUI,times(1)).loginMessage();
    }
}
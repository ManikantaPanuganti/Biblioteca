package com.twu.biblioteca.Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CheckOutTest {

    @Test
    public void shouldCheckOutABook() throws UnknownBook {
        LibraryUI libraryUi = mock(LibraryUI.class);
        when(libraryUi.getBookTitle()).thenReturn("BOOK");
        Library library = mock(Library.class);
        CheckOut checkOut = new CheckOut();
        doNothing().when(library).checkOut("BOOK");


        checkOut.onSelect(libraryUi, library);

        verify(libraryUi, times(1)).handleSuccessfulCheckOut();
    }

    @Test
    public void shouldNotCheckOutABook() throws UnknownBook {
        LibraryUI libraryUi = mock(LibraryUI.class);
        when(libraryUi.getBookTitle()).thenReturn("BOOK");
        Library library = mock(Library.class);
        CheckOut checkOut = new CheckOut();
        doThrow(UnknownBook.class).when(library).checkOut("BOOK");


        checkOut.onSelect(libraryUi, library);

        verify(libraryUi, times(1)).handleUnSuccessfulCheckedOut();
    }

    @Test
    public void shouldGiveDescription() {

        assertEquals("CheckOut",new CheckOut().description());
    }
}
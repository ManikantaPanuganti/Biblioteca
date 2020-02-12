package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CheckOutTest {

    @Test
    public void shouldCheckOutABook() throws UnknownBook {
        UI ui = mock(UI.class);
        when(ui.getBookTitle()).thenReturn("BOOK");
        Library library = mock(Library.class);
        CheckOut checkOut = new CheckOut();
        doNothing().when(library).checkOut("BOOK");


        checkOut.onSelect(ui, library);

        verify(ui, times(1)).handleSuccessfulCheckOut();
    }
}
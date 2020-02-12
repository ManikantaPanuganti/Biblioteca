package com.twu.biblioteca.Logic;

import com.twu.biblioteca.Logic.CheckOut;
import com.twu.biblioteca.Logic.Library;
import com.twu.biblioteca.Logic.UI;
import com.twu.biblioteca.Logic.UnknownBook;
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

    @Test
    public void shouldNotCheckOutABook() throws UnknownBook {
        UI ui = mock(UI.class);
        when(ui.getBookTitle()).thenReturn("BOOK");
        Library library = mock(Library.class);
        CheckOut checkOut = new CheckOut();
        doThrow(UnknownBook.class).when(library).checkOut("BOOK");


        checkOut.onSelect(ui, library);

        verify(ui, times(1)).handleUnSuccessfulCheckedOut();
    }

    @Test
    public void shouldGiveDescription() {

        assertEquals("CheckOut",new CheckOut().description());
    }
}
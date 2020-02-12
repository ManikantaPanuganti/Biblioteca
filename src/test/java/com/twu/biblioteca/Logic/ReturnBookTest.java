package com.twu.biblioteca.Logic;

import com.twu.biblioteca.Logic.Library;
import com.twu.biblioteca.Logic.ReturnBook;
import com.twu.biblioteca.Logic.UI;
import com.twu.biblioteca.Logic.UnknownBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class ReturnBookTest {

    @Test
    public void shouldReturnBook() throws UnknownBook {
        UI ui = mock(UI.class);
        when(ui.getBookTitle()).thenReturn("BOOK");
        Library library = mock(Library.class);
        ReturnBook returnBook = new ReturnBook();
        doNothing().when(library).returnBook("BOOK");

        returnBook.onSelect(ui, library);

        verify(ui, times(1)).handleSuccessFulReturn();
    }

    @Test
    public void shouldNotReturnBookIfBookIsNotTaken() throws UnknownBook {
        UI ui = mock(UI.class);
        when(ui.getBookTitle()).thenReturn("BOOK");
        Library library = mock(Library.class);
        ReturnBook returnBook = new ReturnBook();
        doThrow(UnknownBook.class).when(library).returnBook("BOOK");

        returnBook.onSelect(ui, library);

        verify(ui, times(1)).handleUnSuccessfulReturn();

    }

    @Test
    public void shouldGiveDescription() {

        assertEquals("Return Book",new ReturnBook().description());
    }
}

package com.twu.biblioteca.Logic;

import com.twu.biblioteca.Logic.Book;
import com.twu.biblioteca.Logic.Library;
import com.twu.biblioteca.Logic.ListBooks;
import com.twu.biblioteca.Logic.UI;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ListBooksTest {

    @Test
    public void shouldDisplayBooks() {
        UI ui = mock(UI.class);
        Book book = mock(Book.class);
        when(book.getString()).thenReturn("BOOK");
        ListBooks listBooks = new ListBooks();
        Library library = mock(Library.class);
        when(library.getBooks()).thenReturn(List.of(book));

        listBooks.onSelect(ui,library);

        verify(ui, times(1)).displayBooks("BOOK");
    }

    @Test
    public void shouldEqualTwoSameMenuOptionListBooks() {
        ListBooks listBooks = new ListBooks();
        ListBooks listBooks2 = new ListBooks();

        assertEquals(listBooks, listBooks2);
    }
}

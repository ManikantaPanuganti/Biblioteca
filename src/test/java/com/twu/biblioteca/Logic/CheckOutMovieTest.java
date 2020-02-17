package com.twu.biblioteca.Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CheckOutMovieTest {

    @Test
    public void shouldGiveDescriptionOfTheMenuOption() {
        CheckOutMovie checkOutMovie = new CheckOutMovie();

        assertEquals("Check out Movie", checkOutMovie.description());
    }

    @Test
    public void shouldPromptUserForLoginIfUserIsNotLoggedInOutAMovie() throws UnknownMovie {
        LibraryUI libraryUi = mock(LibraryUI.class);
        Library library = mock(Library.class);
        CheckOutMovie checkOutMovie = new CheckOutMovie();
        when(libraryUi.isLoggedIn()).thenReturn(false);

        checkOutMovie.onSelect(libraryUi, library);

        verify(libraryUi, times(1)).loginMessage();
    }
}

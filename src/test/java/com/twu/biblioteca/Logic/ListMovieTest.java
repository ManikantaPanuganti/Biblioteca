package com.twu.biblioteca.Logic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class ListMovieTest {

    @Test
    public void shouldDisplayMovies() {
        Library library = mock(Library.class);
        LibraryUI ui = mock(LibraryUI.class);
        Movie movie = mock(Movie.class);
        ListMovie listMovie = new ListMovie();
        when(library.getMovies()).thenReturn((ArrayList<Movie>) List.of(movie));
        when(movie.getString()).thenReturn("Movie");

        listMovie.onSelect(ui, library);

        verify(ui,times(1)).display("Movie");

    }
}

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
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);
        when(library.getMovies()).thenReturn(movies);
        when(movie.getString()).thenReturn("Movie");

        listMovie.onSelect(ui, library);

        verify(ui,times(1)).display("Movie");

    }
}

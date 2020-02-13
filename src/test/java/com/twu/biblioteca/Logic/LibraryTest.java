package com.twu.biblioteca.Logic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LibraryTest {

    @Test
    public void shouldReturnListOfBooks() {
        Book book1 = new Book("Title", "author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);

        Library library = new Library(books);

        assertThat(List.of(book1), is(equalTo(library.getBooks())));
    }

    @Test
    public void shouldTellIfABookIsThereInTheLibrary() {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);

        assertTrue(library.isAvailable("Title"));
    }

    @Test
    public void shouldGetABookIfABookIsThereInTheLibrary() throws UnknownBook {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);

        Book book = library.getABook("Title");

        assertThat(book1, is(equalTo(book)));
    }

    @Test
    public void shouldThrowExceptionIfBookIsNotThereInTheLibrary() {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);

        assertThrows(UnknownBook.class, () -> library.getABook("Title2"));
    }

    @Test
    public void shouldCheckOutABook() throws UnknownBook {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);

        library.checkOut("Title");

        assertFalse(library.isAvailable("Title"));
    }

    @Test
    public void shouldThrowExceptionIfUnknownBookCheckingOut() {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);


        assertThrows(UnknownBook.class, () -> library.checkOut("Title2"));
    }

    @Test
    public void shouldTellIfABookIsCheckedOut() throws UnknownBook {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);

        library.checkOut("Title");

        assertTrue(library.isCheckedOut("Title"));
    }

    @Test
    public void shouldReturnFalseIfABookIsNotCheckedOut() throws UnknownBook {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);

        library.checkOut("Title");

        assertFalse(library.isCheckedOut("Title2"));
    }

    @Test
    public void shouldReturnABookWhichIsCheckedOut() throws UnknownBook {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);
        library.checkOut("Title");

        library.returnBook("Title");

        assertTrue(library.isAvailable("Title"));

    }

    @Test
    public void shouldNotReturnABookWhichIsNotCheckedOut() throws UnknownBook {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);
        library.checkOut("Title");

        assertThrows(UnknownBook.class, () -> library.returnBook("Title2"));
    }

    @Test
    public void shouldCheckIfAMovieIsAvailable() {
        ArrayList<Book> books = new ArrayList<>();
        Movie movie = mock(Movie.class);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);
        when(movie.getTitle()).thenReturn("Title");
        Library library = new Library(books);
        library.setMovies(movies);

        assertTrue(library.isAvailableMovie("Title"));

    }

    @Test
    public void checkedMovieShouldNotBeAvailable() throws UnknownMovie {
        ArrayList<Book> books = new ArrayList<>();
        Library library = new Library(books);
        Movie movie = new Movie("Title",2020,"Director",2);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);
        library.setMovies(movies);

        library.checkOutMovie("Title");

        assertFalse(library.isAvailableMovie("Title"));
    }

}

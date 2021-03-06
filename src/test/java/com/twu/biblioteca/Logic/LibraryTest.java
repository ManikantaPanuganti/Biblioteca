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

        library.checkOut("Title", new User(""));

        assertFalse(library.isAvailable("Title"));
    }

    @Test
    public void shouldThrowExceptionIfUnknownBookCheckingOut() {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);


        assertThrows(UnknownBook.class, () -> library.checkOut("Title2", new User("")));
    }

    @Test
    public void shouldThrowExceptionIfUnknownMovieCheckingOut() {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Movie movie = new Movie("Title",2020,"Director",1);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);
        Library library = new Library(books);
        library.setMovies(movies);


        assertThrows(UnknownMovie.class, () -> library.checkOutMovie("Title2", new User("User")));
    }

    @Test
    public void shouldTellIfABookIsCheckedOut() throws UnknownBook {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);

        library.checkOut("Title", new User("User"));

        assertTrue(library.isCheckedOut("Title", new User("User")));
    }

    @Test
    public void shouldCheckOutABookEvenIfTheUserAlreadyCheckedOutAnotherBook() throws UnknownBook {
        Book book1 = new Book("Title", "Author", 2020);
        Book book2 = new Book("Title2", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        Library library = new Library(books);
        User user = new User("User");
        library.checkOut("Title", user);
        library.checkOut("Title2",user);

        assertTrue(library.isCheckedOut("Title2", user));
    }

    @Test
    public void shouldReturnFalseIfABookIsNotCheckedOut() throws UnknownBook {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);

        library.checkOut("Title", new User(""));

        assertFalse(library.isCheckedOut("Title2", new User("User")));
    }

    @Test
    public void shouldReturnABookWhichIsCheckedOut() throws UnknownBook {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);
        library.checkOut("Title", new User(""));

        library.returnBook("Title", new User(""));

        assertTrue(library.isAvailable("Title"));

    }

    @Test
    public void shouldNotReturnABookWhichIsNotCheckedOut() throws UnknownBook {
        Book book1 = new Book("Title", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        Library library = new Library(books);
        library.checkOut("Title", new User(""));

        assertThrows(UnknownBook.class, () -> library.returnBook("Title2", new User("")));
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

        library.checkOutMovie("Title", new User("User"));

        assertFalse(library.isAvailableMovie("Title"));
    }

    @Test
    public void shouldCheckOutSecondMovie() throws UnknownMovie {
        ArrayList<Book> books = new ArrayList<>();
        Library library = new Library(books);
        Movie movie = new Movie("Title",2020,"Director",2);
        Movie movie2 = new Movie("Title2",2020,"Director",2);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);
        movies.add(movie2);
        library.setMovies(movies);
        library.checkOutMovie("Title", new User("User"));

        library.checkOutMovie("Title2", new User("User"));

        assertFalse(library.isAvailableMovie("Title2"));
    }

}

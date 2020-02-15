package com.twu.biblioteca.Logic;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Movie> movies;
    private Map<String, Movie> checkedOutMovies = new HashMap<>();

    private Map<User, ArrayList<Book>> checkedOutBooksUsers = new HashMap<>();

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    boolean isAvailable(String bookTitle) {
        if (books.stream().anyMatch(book -> book.getTitle().equals(bookTitle))) return true;
        else return false;
    }

    Book getABook(String bookTitle) throws UnknownBook {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        throw new UnknownBook();
    }

    void checkOut(String title, User user) throws UnknownBook {
        if (isAvailable(title)) {
            Book book = getABook(title);
            ArrayList<Book> bookList = new ArrayList<>();
            if (checkedOutBooksUsers.containsKey(user)) {
                bookList = checkedOutBooksUsers.get(user);
                bookList.add(book);
                checkedOutBooksUsers.put(user, bookList);
                return;
            }
            bookList.add(book);
            checkedOutBooksUsers.put(user, bookList);
            books.remove(book);
            return;
        }
        throw new UnknownBook();
    }

    boolean isCheckedOut(String title, User user) {
        if(checkedOutBooksUsers.containsKey(user)) {
            ArrayList<Book> booksList = checkedOutBooksUsers.get(user);
            return booksList.stream().anyMatch(book -> book.getTitle().equals(title));
        }
        return false;
    }



    void returnBook(String title, User user) throws UnknownBook {
        if (isCheckedOut(title, user)) {
            ArrayList<Book> booksList = checkedOutBooksUsers.get(user);
            return;
        }
        throw new UnknownBook();

    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    boolean isAvailableMovie(String movieTitle) {
        return movies.stream().anyMatch(movie -> movie.getTitle().equals(movieTitle));
    }

    void checkOutMovie(String title) throws UnknownMovie {
        if (isAvailableMovie(title)) {
            Movie movie = getAMovie(title);
            checkedOutMovies.put(title, movie);
            movies.remove(movie);
            return;
        }
        throw new UnknownMovie();
    }

    public Movie getAMovie(String title) throws UnknownMovie {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        throw new UnknownMovie();
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

}

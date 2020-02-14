package com.twu.biblioteca.Logic;

import java.util.*;

import static java.util.List.*;

public class Library {

    private ArrayList<Book> books;
    private Map<String, Book> checkOutBooks = new HashMap<>();
    private ArrayList<Movie> movies;
    private Map<String, Movie> checkedOutMovies = new HashMap<>();

    private Map<User, ArrayList<Book>> checkedOutBooksUsers = new HashMap<>();

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    boolean isAvailable(String bookTitle) {
        return books.stream()
                .anyMatch(book -> book.getTitle()
                        .equals(bookTitle));
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
            if (checkedOutBooksUsers.containsKey(user)) {
                ArrayList<Book> bookList = new ArrayList<>();
                bookList = checkedOutBooksUsers.get(user);
                bookList.add(book);
                checkedOutBooksUsers.put(user, bookList);
                return;
            }
            checkedOutBooksUsers.put(user, (ArrayList<Book>) of(book));
            books.remove(book);
            return;
        }
        throw new UnknownBook();
    }

    boolean isCheckedOut(String title) {

        Collection<ArrayList<Book>> arrayListsOfBooks = checkedOutBooksUsers.values();
        arrayListsOfBooks.forEach(booksList -> booksList.stream().anyMatch(book -> book.getTitle().equals(title)));
        for (ArrayList<Book> list : arrayListsOfBooks) {
            if(list.stream().anyMatch(book -> book.getTitle().equals(title))){
                return true;
            }
        }
        return false;
    }

    void returnBook(String title) throws UnknownBook {
        if (isCheckedOut(title)) {
            books.add(checkOutBooks.remove(title));
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

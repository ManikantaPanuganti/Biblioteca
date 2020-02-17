package com.twu.biblioteca.Logic;


import java.util.*;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Movie> movies;
    private Map<User, ArrayList<Movie>> checkedOutMovies = new HashMap<>();

    private Map<User, ArrayList<Book>> checkedOutBooksUsers = new HashMap<>();

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    boolean isAvailable(String bookTitle) {
        return books.stream().anyMatch(book -> book.getTitle().equals(bookTitle));
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
                books.remove(book);
                return;
            }
            bookList.add(book);
            checkedOutBooksUsers.put(user, bookList);
            books.remove(book);
            return;
        }
        throw new UnknownBook();
    }

    void checkOutMovie(String title, User user) throws UnknownMovie {
        if (isAvailableMovie(title)) {
            Movie movie = getAMovie(title);
            ArrayList<Movie> movieList = new ArrayList<>();
            if (checkedOutMovies.containsKey(user)) {
                movieList = checkedOutMovies.get(user);
                movieList.add(movie);
                checkedOutMovies.put(user, movieList);
                movies.remove(movie);
                return;
            }
            movieList.add(movie);
            checkedOutMovies.put(user, movieList);
            movies.remove(movie);
            return;
        }
        throw new UnknownMovie();
    }

    boolean isCheckedOut(String title, User user) {
        if (checkedOutBooksUsers.containsKey(user)) {
            ArrayList<Book> booksList = checkedOutBooksUsers.get(user);
            return booksList.stream().anyMatch(book -> book.getTitle().equals(title));
        }
        return false;
    }


    void returnBook(String title, User user) throws UnknownBook {
        if (isCheckedOut(title, user)) {
            ArrayList<Book> booksList = checkedOutBooksUsers.get(user);
            Optional<Book> found = Optional.empty();
            for (Book book : booksList) {
                if (book.getTitle().equals(title)) {
                    found = Optional.of(book);
                    break;
                }
            }
            Book book1 = found.get();
            booksList.remove(book1);
            books.add(book1);
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

    public Map<User, ArrayList<Book>> getCheckedOutBooks() {
        return checkedOutBooksUsers;
    }
}

package com.twu.biblioteca;

import com.twu.biblioteca.Logic.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Biblioteca {
    Scanner scanner = new Scanner(System.in);
    Library library;

    public void start() {
        out.println(welcome());
        Book book = new Book("Title", "Author", 2020);
        Book book2 = new Book("Title2", "Author", 2020);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);
        setLibrary(new Library(books));
        Menu menu = new Menu();
        List<MenuOption> menuOptions = menu.getOptions();
        ConsoleLibraryUI consoleUI = new ConsoleLibraryUI();
        Movie movie = new Movie("Title", 2020, "Director", 1);
        Movie movie2 = new Movie("Title2", 2020, "Director", 1);
        Movie movie3 = new Movie("Title3", 2020, "Director", 1);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);
        movies.add(movie2);
        library.setMovies(movies);

        while (true) {
            if (isLoggedIn(consoleUI)) {
                menuOptions = new UserMenu().getOptions();
            } else {
                menuOptions = menu.getOptions();
            }
            displayMenu(menuOptions);
            int option = promptOption();
            if (option <= menuOptions.size()) {
                menuOptions.get(option - 1).onSelect(consoleUI, library);

            } else if (option == menuOptions.size() + 1) {
                break;
            } else {
                out.println("Please select a valid option");
            }
        }
    }

    private void displayMenu(List<MenuOption> options) {
        int index;
        for (index = 0; index < options.size(); index++) {
            out.println(1 + index + "." + options.get(index).description());
        }
        out.println(1 + index + ".Quit");
    }

    int promptOption() {
        out.println("Enter an option ");
        return scanner.nextInt();
    }

    String welcome() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    void setLibrary(Library library) {
        this.library = library;
    }

    void showBooks() {
        library.getBooks().stream().map(Book::getString).forEach(System.out::println);
    }

    boolean isLoggedIn(ConsoleLibraryUI ui) {
        return ui.isLoggedIn();
    }
}

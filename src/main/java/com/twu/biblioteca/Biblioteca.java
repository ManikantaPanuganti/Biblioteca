package com.twu.biblioteca;

import java.util.List;

import static java.lang.System.out;

public class Biblioteca {

    Library library;
    public void start() {
        System.out.println(welcome());
        setLibrary(new Library(List.of(new Book("Title","Author",2020))));
        Menu menu = new Menu();
        List<MenuOption> menuOptions = menu.getOptions();
        displayMenu(menuOptions);
    }

    private void displayMenu(List<MenuOption> options) {
        int index;
        for (index = 0; index < options.size(); index++) {
            out.println(1 + index + "." + options.get(index).description());
        }
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
}

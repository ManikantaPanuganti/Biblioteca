package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Biblioteca {
    Scanner scanner = new Scanner(System.in);
    Library library;
    public void start() {
        out.println(welcome());
        setLibrary(new Library(List.of(new Book("Title","Author",2020))));
        Menu menu = new Menu();
        List<MenuOption> menuOptions = menu.getOptions();
        displayMenu(menuOptions);
        ConsoleUI consoleUI = new ConsoleUI();
        int option = promptOption();
        while(true)
        if(option==1){
            menuOptions.get(option-1).onSelect(consoleUI,library);
            break;
        }
        else{
            out.println("Please select a valid option");
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
}

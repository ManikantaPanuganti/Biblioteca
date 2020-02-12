package com.twu.biblioteca;

import com.twu.biblioteca.Logic.LibraryUI;

import java.util.Scanner;

public class ConsoleLibraryUI implements LibraryUI {
    @Override
    public void display(String book) {
        System.out.println(book);
    }

    @Override
    public String getBookTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title");
        return scanner.next();
    }

    @Override
    public void handleUnSuccessfulCheckedOut() {
        System.out.println("Sorry, that book is not available");
    }

    @Override
    public void handleSuccessfulCheckOut() {
        System.out.println("Thank you! Enjoy the book");
    }

    @Override
    public void handleSuccessFulReturn() {
        System.out.println("Thank you for returning the book");
    }

    @Override
    public void handleUnSuccessfulReturn() {
        System.out.println("That is not a valid book to return");
    }

    @Override
    public String getMovieTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Movie title");
        return scanner.next();
    }
}


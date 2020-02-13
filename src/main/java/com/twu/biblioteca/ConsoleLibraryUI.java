package com.twu.biblioteca;

import com.twu.biblioteca.Logic.LibraryUI;
import com.twu.biblioteca.Logic.Login;

import java.util.Scanner;

public class ConsoleLibraryUI implements LibraryUI {
    Login login;

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

    @Override
    public void handleSuccessfulMovieCheckout() {
        System.out.println("Thank you! Enjoy the Movie");
    }

    @Override
    public void handleUnSuccessfulMovieCheckedOut() {
        System.out.println("Sorry that movie is not there");
    }

    @Override
    public String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name:");
        return scanner.next();
    }

    @Override
    public String getPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password:");
        return scanner.next();
    }

    @Override
    public void handleSuccessfulLogin() {
        System.out.println("Successfully logged in");
    }

    @Override
    public void handleUnSuccessfulLogin() {
        System.out.println("Sorry! Username or Password is wrong");
    }

    @Override
    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    public void logOut() {
        login.setValid(false);
        login = null;
    }

    boolean isLoggedIn() {
        boolean value;
        try {
            value = login.isValid();
        } catch (Exception e) {
            value = false;
        }
        return value;
    }
}

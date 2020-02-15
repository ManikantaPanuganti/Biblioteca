package com.twu.biblioteca;

import com.twu.biblioteca.Logic.LibraryUI;
import com.twu.biblioteca.Logic.LoginManager;
import com.twu.biblioteca.Logic.User;

import java.util.Scanner;

public class ConsoleLibraryUI implements LibraryUI {
    LoginManager loginManager;

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
    public void setLoginManager(LoginManager loginManager) {
        this.loginManager = loginManager;
    }

    @Override
    public void logOut() {
        loginManager.setValid(false);
        loginManager = null;
    }

    @Override
    public User getUser() {
        return loginManager.getUser();
    }

    boolean isLoggedIn() {
        boolean value;
        try {
            value = loginManager.isValid();
        } catch (Exception e) {
            value = false;
        }
        return value;
    }
    boolean isAdmin() {

    }
}

package com.twu.biblioteca;

public class ConsoleUI implements UI {
    @Override
    public void displayBooks(String book) {
        System.out.println(book);
    }
}


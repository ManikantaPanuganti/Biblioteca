package com.twu.biblioteca;

public class consoleUI implements UI {
    @Override
    public void displayBooks(String book) {
        System.out.println(book);
    }

    @Override
    public Library getLibrary() {
        return null;
    }
}

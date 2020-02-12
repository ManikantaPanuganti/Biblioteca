package com.twu.biblioteca;

import java.util.Scanner;

public class ConsoleUI implements UI {
    @Override
    public void displayBooks(String book) {
        System.out.println(book);
    }

    @Override
    public String getBookTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title");
        return scanner.next();
    }
}


package com.twu.biblioteca.Logic;

public interface LibraryUI {
    void displayBooks(String book);

    String getBookTitle();

    void handleUnSuccessfulCheckedOut();

    void handleSuccessfulCheckOut();

    void handleSuccessFulReturn();

    void handleUnSuccessfulReturn();
}

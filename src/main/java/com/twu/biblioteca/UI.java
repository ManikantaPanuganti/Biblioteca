package com.twu.biblioteca;

public interface UI {
    void displayBooks(String book);

    String getBookTitle();

    void handleUnSuccessfulCheckedOut();

    void handleSuccessfulCheckOut();

    void handleSuccessFulReturn();

    void handleUnSuccessfulReturn();
}

package com.twu.biblioteca.Logic;

public interface LibraryUI {
    void display(String book);

    String getBookTitle();

    void handleUnSuccessfulCheckedOut();

    void handleSuccessfulCheckOut();

    void handleSuccessFulReturn();

    void handleUnSuccessfulReturn();
}

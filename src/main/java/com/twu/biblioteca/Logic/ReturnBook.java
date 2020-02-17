package com.twu.biblioteca.Logic;

public class ReturnBook implements MenuOption {
    @Override
    public void onSelect(LibraryUI libraryUi, Library library) {
        if (!libraryUi.isLoggedIn()) {
            libraryUi.loginMessage();
            return;
        }
        String book = libraryUi.getBookTitle();
        try {
            library.returnBook(book, libraryUi.getUser());
            libraryUi.handleSuccessFulReturn();

        } catch (UnknownBook unknownBook) {
            libraryUi.handleUnSuccessfulReturn();
        }
    }

    @Override
    public String description() {
        return "Return Book";
    }
}

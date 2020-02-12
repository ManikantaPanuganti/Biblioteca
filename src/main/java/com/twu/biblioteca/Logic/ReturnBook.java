package com.twu.biblioteca.Logic;

public class ReturnBook implements MenuOption {
    @Override
    public void onSelect(LibraryUI libraryUi, Library library) {
        String book = libraryUi.getBookTitle();
        try {
            library.returnBook(book);
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

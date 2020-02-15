package com.twu.biblioteca.Logic;

public class CheckOutBook implements MenuOption {
    @Override
    public void onSelect(LibraryUI libraryUi, Library library) {
        String book = libraryUi.getBookTitle();
        try {
            library.checkOut(book, libraryUi.getUser());
            libraryUi.handleSuccessfulCheckOut();

        } catch (UnknownBook unknownBook) {
            libraryUi.handleUnSuccessfulCheckedOut();
        }
    }

    @Override
    public String description() {
        return "CheckOut";
    }
}

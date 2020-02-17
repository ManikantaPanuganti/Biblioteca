package com.twu.biblioteca.Logic;

public class CheckOutMovie implements MenuOption {
    @Override
    public void onSelect(LibraryUI libraryUi, Library library) {
        if (!libraryUi.isLoggedIn()) {
            libraryUi.loginMessage();
            return;
        }
        String movie = libraryUi.getMovieTitle();
        try {
            library.checkOutMovie(movie, libraryUi.getUser());
            libraryUi.handleSuccessfulMovieCheckout();
        } catch (UnknownMovie unknownMovie) {
            libraryUi.handleUnSuccessfulMovieCheckedOut();
        }
    }

    @Override
    public String description() {
        return "Check out Movie";
    }
}

package com.twu.biblioteca.Logic;

public class CheckOutMovie implements MenuOption {
    @Override
    public void onSelect(LibraryUI libraryUi, Library library) {
        String movie = libraryUi.getMovieTitle();
        if (libraryUi.isLoggedIn()) {
            libraryUi.display("Please login first");
            return;
        }
        try {
            library.checkOutMovie(movie);
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

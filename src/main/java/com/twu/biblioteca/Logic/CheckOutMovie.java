package com.twu.biblioteca.Logic;

public class CheckOutMovie implements MenuOption {
    @Override
    public void onSelect(LibraryUI libraryUi, Library library) {
        String movie = libraryUi.getMovieTitle();

        try {
            library.getAMovie(movie);
            libraryUi.handleSuccessfulMovieCheckout();
        } catch (UnknownMovie unknownMovie) {
            libraryUi.handleUnSuccessfulMovieCheckedOut();
        }

    }

    @Override
    public String description() {
        return null;
    }
}

package com.twu.biblioteca.Logic;

public class ListMovie implements MenuOption {
    @Override
    public void onSelect(LibraryUI libraryUi, Library library) {
        library.getMovies().forEach(movie -> libraryUi.display(movie.getString()));
    }

    @Override
    public String description() {
        return "List Movies";
    }
}

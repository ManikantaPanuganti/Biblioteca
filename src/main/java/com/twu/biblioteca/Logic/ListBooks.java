package com.twu.biblioteca.Logic;

public class ListBooks implements MenuOption {
    @Override
    public void onSelect(LibraryUI libraryUi, Library library) {
        library.getBooks().forEach(book -> libraryUi.displayBooks(book.getString()));
    }

    @Override
    public String description() {
        return "ListBooks";
    }

    @Override
    public boolean equals(Object obj) {
        MenuOption other = (ListBooks) obj;
        return description().equals(other.description());
    }
}

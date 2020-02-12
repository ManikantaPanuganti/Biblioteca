package com.twu.biblioteca;

public class ListBooks implements MenuOption {
    @Override
    public void onSelect(UI ui) {
        Library library = ui.getLibrary();
        library.getBooks().forEach(book -> ui.displayBooks(book.getString()));
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

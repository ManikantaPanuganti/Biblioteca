package com.twu.biblioteca.Logic;

public class ListBooks implements MenuOption {
    @Override
    public void onSelect(UI ui, Library library) {
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

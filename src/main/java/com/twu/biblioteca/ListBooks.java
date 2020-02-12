package com.twu.biblioteca;

public class ListBooks implements MenuOption {
    @Override
    public void onSelect(UI ui) {
        Library library = ui.getLibrary();
        library.getBooks().forEach(book -> ui.displayBooks());
    }

    @Override
    public String description() {
        return "ListBooks";
    }
}

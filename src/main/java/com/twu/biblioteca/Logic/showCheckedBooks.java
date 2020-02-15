package com.twu.biblioteca.Logic;

import java.util.ArrayList;
import java.util.Map;

public class showCheckedBooks implements MenuOption {
    @Override
    public void onSelect(LibraryUI libraryUi, Library library) {
        Map<User, ArrayList<Book>> booksUsers = library.getCheckedOutBooks();
        booksUsers.forEach((user, books) -> books.forEach(book -> libraryUi.display(book.getString() + " " + user.getName())));
    }

    @Override
    public String description() {
        return "Show checkedOut books";
    }
}

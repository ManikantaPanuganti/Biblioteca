package com.twu.biblioteca.Logic;

public interface MenuOption {
    void onSelect(LibraryUI libraryUi, Library library);
    String description();
}

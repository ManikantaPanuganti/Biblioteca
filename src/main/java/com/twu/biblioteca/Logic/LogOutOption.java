package com.twu.biblioteca.Logic;

public class LogOutOption implements MenuOption {
    @Override
    public void onSelect(LibraryUI libraryUi, Library library) {
        libraryUi.logOut();
    }

    @Override
    public String description() {
        return "Logout";
    }
}

package com.twu.biblioteca.Logic;

public class LoginOption implements MenuOption {
    @Override
    public void onSelect(LibraryUI libraryUi, Library library) {
            String userName = libraryUi.getUserName();
            Login login = new Login()
    }

    @Override
    public String description() {
        return "Login";
    }
}

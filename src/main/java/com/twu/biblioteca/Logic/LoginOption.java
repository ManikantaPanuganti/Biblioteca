package com.twu.biblioteca.Logic;

public class LoginOption implements MenuOption {
    static Login login;
    @Override
    public void onSelect(LibraryUI libraryUi, Library library) {
            String userName = libraryUi.getUserName();
            String password = libraryUi.getPassword();
            login = new Login(new User(userName));
            login.valid(password);
            if(login.isValid()) {
                libraryUi.handleSuccessfulLogin();
            }
            else{
                libraryUi.handleUnSuccessfulLogin();
            }

    }

    @Override
    public String description() {
        return "Login";
    }
}

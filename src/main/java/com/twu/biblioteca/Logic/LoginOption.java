package com.twu.biblioteca.Logic;

public class LoginOption implements MenuOption {

    @Override
    public void onSelect(LibraryUI libraryUi, Library library) {
            String userName = libraryUi.getUserName();
            String password = libraryUi.getPassword();
            Login login;
            login = new Login(new User(userName));
            login.valid(password);
            if(login.isValid()) {
                libraryUi.handleSuccessfulLogin();
                libraryUi.setLogin(login);
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

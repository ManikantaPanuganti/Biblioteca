package com.twu.biblioteca.Logic;

public class LoginOption implements MenuOption {

    @Override
    public void onSelect(LibraryUI libraryUi, Library library) {
            String userName = libraryUi.getUserName();
            String password = libraryUi.getPassword();
            LoginManager loginManager;
            loginManager = new LoginManager(new User(userName));
            loginManager.valid(password);
            if(loginManager.isValid()) {
                libraryUi.handleSuccessfulLogin();
                libraryUi.setLoginManager(loginManager);
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

package com.twu.biblioteca.Logic;

public class LoginManager {
    private final User user;
    private boolean valid;

    public LoginManager(User user) {
        this.user = user;
    }

    public void valid(String password) {
        valid = password.equals("password");
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public User getUser() {
        return user;
    }

    public boolean isAdmin() {
        return user.getName().equals("Admin");
    }
}

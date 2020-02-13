package com.twu.biblioteca.Logic;

public class Login {
    private final User user;
    private boolean valid;

    public Login(User user) {
        this.user = user;
    }

    public void valid(String password) {
        valid = password.equals("password");
    }

    public boolean isValid() {
        return valid;
    }
}

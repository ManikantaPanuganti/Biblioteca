package com.twu.biblioteca.Logic;

public class User {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return name.equals("Admin");
    }
}

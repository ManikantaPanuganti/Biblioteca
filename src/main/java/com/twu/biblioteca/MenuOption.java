package com.twu.biblioteca;

public interface MenuOption {
    void onSelect(UI ui,Library library);
    String description();
}

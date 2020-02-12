package com.twu.biblioteca.Logic;

public interface MenuOption {
    void onSelect(UI ui, Library library);
    String description();
}

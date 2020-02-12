package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<MenuOption> menuOptions = new ArrayList<>();

    Menu() {
        menuOptions.add(new ListBooks());
        menuOptions.add(new CheckOut());
        menuOptions.add(new ReturnBook());
    }

    List<MenuOption> getOptions() {
        return menuOptions;
    }

}

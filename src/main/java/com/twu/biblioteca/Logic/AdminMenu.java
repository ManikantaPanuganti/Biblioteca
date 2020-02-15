package com.twu.biblioteca.Logic;

import java.util.ArrayList;
import java.util.List;

public class AdminMenu  {
    List<MenuOption> menuOptions = new ArrayList<>();

    public AdminMenu() {
        menuOptions.add(new ListBooks());
        menuOptions.add(new CheckOutBook());
        menuOptions.add(new ReturnBook());
        menuOptions.add(new ListMovie());
        menuOptions.add(new CheckOutMovie());
        menuOptions.add(new showCheckedBooks());
        menuOptions.add(new LogOutOption());
    }

    public List<MenuOption> getOptions() {
        return menuOptions;
    }
}

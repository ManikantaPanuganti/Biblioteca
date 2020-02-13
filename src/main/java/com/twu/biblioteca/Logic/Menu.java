package com.twu.biblioteca.Logic;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<MenuOption> menuOptions = new ArrayList<>();

    public Menu() {
        menuOptions.add(new LoginOption());
        menuOptions.add(new ListBooks());
        menuOptions.add(new CheckOutBook());
        menuOptions.add(new ReturnBook());
        menuOptions.add(new ListMovie());
        menuOptions.add(new CheckOutMovie());
    }

    public List<MenuOption> getOptions() {
        return menuOptions;
    }

    public void remove(MenuOption option) {
        menuOptions.remove(option);
    }

}

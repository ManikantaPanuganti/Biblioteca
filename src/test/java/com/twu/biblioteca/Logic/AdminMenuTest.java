package com.twu.biblioteca.Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminMenuTest {

    @Test
    public void shouldReturnMenuOptionOf7lengthList() {
        AdminMenu adminMenu = new AdminMenu();

        assertEquals(7,adminMenu.getOptions().size());
    }
}

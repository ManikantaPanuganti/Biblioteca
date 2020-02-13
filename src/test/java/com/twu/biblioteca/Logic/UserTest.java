package com.twu.biblioteca.Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void shouldReturnUserName() {
        User name = new User("Name");

        assertEquals("Name",name.getName());
    }

    @Test
    public void shouldReturnTrueIfTheUserIsAdmin() {
        User user = new User("Admin");

        assertTrue(user.isAdmin());
    }
}
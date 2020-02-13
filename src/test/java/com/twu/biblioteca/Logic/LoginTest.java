package com.twu.biblioteca.Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LoginTest {

    @Test
    public void shouldTellIfAUserIsLoggedInWithValidCredentials() {
        User user = mock(User.class);
        Login login = new Login(user);

        login.valid("password");

        assertTrue(login.isValid());

    }
}
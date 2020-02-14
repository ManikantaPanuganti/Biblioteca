package com.twu.biblioteca.Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LoginManagerTest {

    @Test
    public void shouldTellIfAUserIsLoggedInWithValidCredentials() {
        User user = mock(User.class);
        LoginManager loginManager = new LoginManager(user);

        loginManager.valid("password");

        assertTrue(loginManager.isValid());

    }
}
package com.twu.biblioteca.Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginManagerOptionTest {
    @Test
    public void shouldReturnDescription() {
        LoginOption loginOption = new  LoginOption();

        assertEquals("Login",loginOption.description());
    }
}

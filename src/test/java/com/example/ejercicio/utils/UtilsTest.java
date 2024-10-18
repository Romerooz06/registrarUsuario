package com.example.ejercicio.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilsTest {

    @InjectMocks
    private Utils utils;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        utils = new Utils();
        utils.patternPass = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
    }

    @Test
    void validatePassword_ShouldReturnTrueForValidPassword() {
        String validPassword = "aaAA2#bb";
        assertTrue(utils.validatePassword(validPassword));
    }

    @Test
    void validatePassword_ShouldReturnFalseForInvalidPassword() {
        String invalidPassword = "pass";
        assertFalse(utils.validatePassword(invalidPassword));
    }
}

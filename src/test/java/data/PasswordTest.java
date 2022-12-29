package data;

import exceptions.BadFormatPasswordException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {

    @Test
    public void nullPassword() {
        Throwable ex =
                assertThrows(
                        NullPointerException.class,
                        () -> {
                            new Password(null);
                        });
        assertEquals("Password shouldn't reference to null", ex.getMessage());
    }

    @Test
    public void invalidLengthPassword() {
        Throwable ex =
                assertThrows(
                        BadFormatPasswordException.class,
                        () -> {
                            new Password("1234567");
                        });
        assertEquals("Password must be 8-20 characters long", ex.getMessage());
    }

    @Test
    public void mixedValidCharactersPassword() throws BadFormatPasswordException {
        Password password = new Password("1a2B3c4D5e6F7g8H9i0J");
        assertEquals("1a2B3c4D5e6F7g8H9i0J", password.getPassword());
    }

    @Test
    public void correctPassword() throws BadFormatPasswordException {
        Password password = new Password("1234567890");
        assertEquals("1234567890", password.getPassword());
    }

    @Test
    @DisplayName("Equals on different reference with same values")
    public void equalsDiffTest() throws BadFormatPasswordException {
        Password password1 = new Password("1234567890");
        Password password2 = new Password("1234567890");
        assertTrue(password1.equals(password2));
    }

    @Test
    @DisplayName("Equals on same reference")
    public void equalsSameTest() throws BadFormatPasswordException {
        Password password1 = new Password("1234567890");
        assertTrue(password1.equals(password1));
    }

    @Test
    @DisplayName("Equals on different reference with different values")
    public void notEqualsTest() throws BadFormatPasswordException {
        Password password1 = new Password("1234567890");
        Password password2 = new Password("0987654321");
        assertFalse(password1.equals(password2));
    }

    @Test
    @DisplayName("toString on valid password")
    public void toStringTest() throws BadFormatPasswordException {
        Password password = new Password("1234567890");
        assertEquals("Password{password='1234567890'}", password.toString());
    }

    @Test
    @DisplayName("hashCode on different reference with same values")
    public void hashCodeDiffTest() throws BadFormatPasswordException {
        Password password1 = new Password("1234567890");
        Password password2 = new Password("1234567890");
        assertEquals(password1.hashCode(), password2.hashCode());
    }

    @Test
    @DisplayName("hashCode on same reference")
    public void hashCodeSameTest() throws BadFormatPasswordException {
        Password password1 = new Password("1234567890");
        assertEquals(password1.hashCode(), password1.hashCode());
    }

    @Test
    @DisplayName("hashCode on different reference with different values")
    public void hashCodeNotEqualsTest() throws BadFormatPasswordException {
        Password password1 = new Password("1234567890");
        Password password2 = new Password("0987654321");
        assertNotEquals(password1.hashCode(), password2.hashCode());
    }

}
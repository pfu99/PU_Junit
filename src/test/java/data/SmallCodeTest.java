package data;

import exceptions.BadFormatSmallCodeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmallCodeTest {

    @Test
    public void nullSmallCode() {
        Throwable ex =
                assertThrows(
                        NullPointerException.class,
                        () -> {
                            new SmallCode(null);
                        });
        assertEquals("SmallCode is null.", ex.getMessage());
    }

    @Test
    public void invalidFormatSmallCode() {
        Throwable ex =
                assertThrows(
                        BadFormatSmallCodeException.class,
                        () -> {
                            new SmallCode("abc");
                        });
        assertEquals("SmallCode should be 3 digits and contain only numeric characters", ex.getMessage());
    }

    @Test
    public void invalidLengthSmallCode() {
        Throwable ex =
                assertThrows(
                        BadFormatSmallCodeException.class,
                        () -> {
                            new SmallCode("123456");
                        });
        assertEquals("SmallCode should be 3 digits", ex.getMessage());
    }

    @Test
    public void correctSmallCode() throws BadFormatSmallCodeException {
        SmallCode smallCode = new SmallCode("123");
        assertEquals("123", smallCode.getSmallCode());
    }
    @Test
    @DisplayName("Equals on different reference with same values")
    public void equalsDiffTest() throws BadFormatSmallCodeException {
        SmallCode smallCode1 = new SmallCode("123");
        SmallCode smallCode2 = new SmallCode("123");
        assertTrue(smallCode1.equals(smallCode2));
    }

    @Test
    @DisplayName("Equals on same reference")
    public void equalsSameTest() throws BadFormatSmallCodeException {
        SmallCode smallCode1 = new SmallCode("123");
        assertTrue(smallCode1.equals(smallCode1));
    }

    @Test
    @DisplayName("Equals on different reference with different values")
    public void notEqualsTest() throws BadFormatSmallCodeException {
        SmallCode smallCode1 = new SmallCode("123");
        SmallCode smallCode2 = new SmallCode("456");
        assertFalse(smallCode1.equals(smallCode2));
    }

    @Test
    @DisplayName("toString on valid small code")
    public void toStringTest() throws BadFormatSmallCodeException {
        SmallCode smallCode = new SmallCode("123");
        assertEquals("123", smallCode.toString());
    }

    @Test
    @DisplayName("hashCode on different reference with same values")
    public void hashCodeDiffTest() throws BadFormatSmallCodeException {
        SmallCode smallCode1 = new SmallCode("123");
        SmallCode smallCode2 = new SmallCode("123");
        assertEquals(smallCode1.hashCode(), smallCode2.hashCode());
    }

    @Test
    @DisplayName("hashCode on same reference")
    public void hashCodeSameTest() throws BadFormatSmallCodeException {
        SmallCode smallCode1 = new SmallCode("123");
        assertEquals(smallCode1.hashCode(), smallCode1.hashCode());
    }

    @Test
    @DisplayName("hashCode on different reference with different values")
    public void hashCodeNotEqualsTest() throws BadFormatSmallCodeException {
        SmallCode smallCode1 = new SmallCode("123");
        SmallCode smallCode2 = new SmallCode("456");
        assertNotEquals(smallCode1.hashCode(), smallCode2.hashCode());
    }
}
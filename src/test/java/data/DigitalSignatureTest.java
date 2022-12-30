package data;

import exceptions.BadFormatSignatureException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DigitalSignatureTest {

    @Test
    public void nullSignature() {
        Throwable ex =
                assertThrows(
                        NullPointerException.class,
                        () -> {
                            new DigitalSignature(null);
                        });
        assertEquals("Digital signature code is null.", ex.getMessage());
    }

    @Test
    public void correctSignature() throws BadFormatSignatureException {
        DigitalSignature signature = new DigitalSignature("abcdefg123456");
        assertEquals("abcdefg123456", signature.getSignature());
    }

    @Test
    public void equalsDiffTest() throws BadFormatSignatureException {
        DigitalSignature signature1 = new DigitalSignature("abcdefg123456");
        DigitalSignature signature2 = new DigitalSignature("abcdefg123456");
        assertTrue(signature1.equals(signature2));
    }

    @Test
    public void equalsSameTest() throws BadFormatSignatureException {
        DigitalSignature signature1 = new DigitalSignature("abcdefg123456");
        assertTrue(signature1.equals(signature1));
    }

    @Test
    public void notEqualsTest() throws BadFormatSignatureException {
        DigitalSignature signature1 = new DigitalSignature("abcdefg123456");
        DigitalSignature signature2 = new DigitalSignature("zyxwvuts987654");
        assertFalse(signature1.equals(signature2));
    }

    @Test
    public void toStringTest() throws BadFormatSignatureException {
        DigitalSignature signature = new DigitalSignature("abcdefg123456");
        assertEquals("abcdefg123456", signature.toString());
    }

    @Test
    public void hashCodeDiffTest() throws BadFormatSignatureException {
        DigitalSignature signature1 = new DigitalSignature("abcdefg123456");
        DigitalSignature signature2 = new DigitalSignature("abcdefg123456");
        assertEquals(signature1.hashCode(), signature2.hashCode());
    }

    @Test
    public void hashCodeSameTest() throws BadFormatSignatureException {
        DigitalSignature signature1 = new DigitalSignature("abcdefg123456");
        assertEquals(signature1.hashCode(), signature1.hashCode());
    }

    @Test
    public void hashCodeNotEqualsTest() throws BadFormatSignatureException {
        DigitalSignature signature1 = new DigitalSignature("abcdefg123456");
        DigitalSignature signature2 = new DigitalSignature("zyxwvuts987654");
        assertNotEquals(signature1.hashCode(), signature2.hashCode());
    }
}

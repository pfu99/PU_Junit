package data;

import exceptions.BadPathException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DocPathTest {

    @Test
    public void nullPath() {
        Throwable ex =
                assertThrows(
                        NullPointerException.class,
                        () -> {
                            new DocPath(null);
                        });
        assertEquals("Path is null.", ex.getMessage());
    }

    @Test
    public void equalsDiffTest() throws BadPathException {
        DocPath path1 = new DocPath("/users/documents/file.txt");
        DocPath path2 = new DocPath("/users/documents/file.txt");
        assertTrue(path1.equals(path2));
    }

    @Test
    public void equalsSameTest() throws BadPathException {
        DocPath path1 = new DocPath("/users/documents/file.txt");
        assertTrue(path1.equals(path1));
    }

    @Test
    public void notEqualsTest() throws BadPathException {
        DocPath path1 = new DocPath("/users/documents/file.txt");
        DocPath path2 = new DocPath("/users/documents/other_file.txt");
        assertFalse(path1.equals(path2));
    }
}
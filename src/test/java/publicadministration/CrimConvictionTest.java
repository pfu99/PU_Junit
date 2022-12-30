package publicadministration;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrimConvictionTest {
    @Test
    public void testCrimConviction(){
        Date date1 = new Date();
        CrimConviction conviction = new CrimConviction(date1, "Robbery", "10 years");
        assertEquals(date1, conviction.getCommitDate());
        assertEquals("Robbery", conviction.getOffense());
        assertEquals("10 years", conviction.getSentence());
    }
}

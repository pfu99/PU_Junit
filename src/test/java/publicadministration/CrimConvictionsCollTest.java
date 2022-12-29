package publicadministration;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CrimConvictionsCollTest {
    @Test
    public void testCrimConvictionsColl(){
        CrimConvictionsColl crimConvictionsColl = new CrimConvictionsColl();
        Date date1 = new Date();
        CrimConviction conviction1 = new CrimConviction(date1, "Robbery", "10 years");
        crimConvictionsColl.addCriminalConviction(conviction1);
        assertEquals(conviction1, crimConvictionsColl.getCriminalConviction(date1));
        assertNull(crimConvictionsColl.getCriminalConviction(new Date()));
        Date date2 = new Date();
        CrimConviction conviction2 = new CrimConviction(date2, "Fraud", "2 years in prision");
        assertEquals(conviction2, crimConvictionsColl.getCriminalConviction(date2));
        assertEquals(2, crimConvictionsColl.getConvictions().size());
    }
}

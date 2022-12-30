package publicadministration;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CrimConvictionsCollTest {
    @Test
    public void testCrimConvictionsColl() throws InterruptedException {
        CrimConvictionsColl crimConvictionsColl = new CrimConvictionsColl();
        Date date1 = new Date(2020, Calendar.MAY, 15);
        CrimConviction conviction1 = new CrimConviction(date1, "Robbery", "10 years");
        crimConvictionsColl.addCriminalConviction(conviction1);

        assertEquals(conviction1, crimConvictionsColl.getCriminalConviction(date1));
        Date date2 = new Date(2021, Calendar.AUGUST, 1);
        assertNull(crimConvictionsColl.getCriminalConviction(date2));

        Date date3 = new Date(2020, Calendar.JANUARY, 31);
        CrimConviction conviction2 = new CrimConviction(date3, "Fraud", "2 years in prison");
        crimConvictionsColl.addCriminalConviction(conviction2);

        assertEquals(conviction2, crimConvictionsColl.getCriminalConviction(date3));
        assertEquals(2, crimConvictionsColl.getConvictions().size());
    }
}

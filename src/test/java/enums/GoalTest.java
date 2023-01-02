package enums;

import data.DigitalSignature;
import data.Nif;
import exceptions.BadFormatNifException;
import exceptions.BadFormatSignatureException;
import exceptions.BadPathException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import publicadministration.CrimConvictionsColl;
import publicadministration.CriminalRecordCertf;

import static org.junit.jupiter.api.Assertions.*;

public class GoalTest {

    @Test
    public void testGoalValues() {
        assertEquals(Goal.WORKWITHMINORS.getDescription(), "Trabajar con menores");
        assertEquals(Goal.GAMESECTOR.getDescription(), "Sector del juego");
        assertEquals(Goal.PUBLICWORKERS.getDescription(), "Trabajadores públicos");
        assertEquals(Goal.PUBLICADMINCONSORTIUM.getDescription(), "Consorcio de administración pública");
    }

    @Test
    public void testGoalEquals() {
        assertEquals(Goal.WORKWITHMINORS, Goal.WORKWITHMINORS);
        assertNotEquals(Goal.GAMESECTOR, Goal.PUBLICWORKERS);
    }

    @Test
    public void testGoalToString() {
        assertEquals(Goal.WORKWITHMINORS.toString(), "WORKWITHMINORS");
        assertEquals(Goal.GAMESECTOR.toString(), "GAMESECTOR");
    }

    @Test
    public void testCriminalRecordCertf() throws BadFormatNifException, BadFormatSignatureException, BadPathException {
        Nif nif = new Nif("12345678Z");
        String name = "John Doe";
        Goal goal = Goal.WORKWITHMINORS;
        DigitalSignature digSign = new DigitalSignature("123456");
        CrimConvictionsColl crimConvs = new CrimConvictionsColl();
        CriminalRecordCertf certf = new CriminalRecordCertf(nif, name, goal, digSign, crimConvs);

        assertEquals(nif, certf.getNif());
        assertEquals(name, certf.getName());
        assertEquals(goal, certf.getGoal());
        assertEquals(digSign, certf.getDigSign());
        assertEquals(crimConvs, certf.getCrimConvs());
    }

    @Test
    void getDescription() {
        assertEquals("Trabajar con menores", Goal.WORKWITHMINORS.getDescription());
        assertEquals("Sector del juego", Goal.GAMESECTOR.getDescription());
        assertEquals("Trabajadores públicos", Goal.PUBLICWORKERS.getDescription());
        assertEquals("Consorcio de administración pública", Goal.PUBLICADMINCONSORTIUM.getDescription());
    }

    @Test
    void testHashCode() {
        assertEquals(Goal.WORKWITHMINORS.hashCode(), Goal.WORKWITHMINORS.hashCode());
        assertEquals(Goal.GAMESECTOR.hashCode(), Goal.GAMESECTOR.hashCode());
        assertNotEquals(Goal.WORKWITHMINORS.hashCode(), Goal.GAMESECTOR.hashCode());
    }

    @Test
    void values() {
        Goal[] values = Goal.values();
        assertEquals(4, values.length);
        assertEquals(Goal.WORKWITHMINORS, values[0]);
        assertEquals(Goal.GAMESECTOR, values[1]);
        assertEquals(Goal.PUBLICWORKERS, values[2]);
        assertEquals(Goal.PUBLICADMINCONSORTIUM, values[3]);
    }

    @Test
    void valueOf() {
        assertEquals(Goal.WORKWITHMINORS, Goal.valueOf("WORKWITHMINORS"));
        assertEquals(Goal.GAMESECTOR, Goal.valueOf("GAMESECTOR"));
        assertEquals(Goal.PUBLICWORKERS, Goal.valueOf("PUBLICWORKERS"));
        assertEquals(Goal.PUBLICADMINCONSORTIUM, Goal.valueOf("PUBLICADMINCONSORTIUM"));
    }
}

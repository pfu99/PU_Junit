package publicadministration;

import data.DigitalSignature;
import data.Nif;
import exceptions.BadFormatNifException;
import exceptions.BadFormatSignatureException;
import exceptions.BadPathException;
import org.junit.jupiter.api.Test;
import enums.Goal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriminalRecordCertfTest {
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
}

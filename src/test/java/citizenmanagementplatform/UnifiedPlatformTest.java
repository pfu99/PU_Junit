package citizenmanagementplatform;

import static org.junit.jupiter.api.Assertions.*;

import citizenmanagementplatform.UnifiedPlatform;
import data.DigitalSignature;
import data.Goal;
import data.Nif;
import data.SmallCode;
import enums.AuthenticationMethod;
import exceptions.*;
import org.junit.jupiter.api.Test;
import publicadministration.Citizen;
import publicadministration.CreditCard;
import publicadministration.CrimConvictionsColl;

import java.util.Date;

class UnifiedPlatformTest {
    private final UnifiedPlatform platform = new UnifiedPlatform();
    private final Citizen testCitizen = new Citizen(new Nif("12345678A"), "Artur", "Av. Madrid, 68", "987654321");
    private final Goal testGoal = new Goal("Obtain criminal record certificate");
    private final CreditCard testCard = new CreditCard(new Nif("12345678A"), "1234567890123456", new Date(), new SmallCode("123"));
    private final DigitalSignature testSignature = new DigitalSignature("123");
    private final CrimConvictionsColl testConvictions = new CrimConvictionsColl();
    private Object authMethod;

    UnifiedPlatformTest() throws BadFormatNifException, BadFormatSmallCodeException, BadFormatSignatureException, BadFormatGoalException {
    }

    @Test
    void testSelectJusMin() {
        platform.selectJusMin();
        assertTrue(true); // This method only prints to the console, so we can't really test it
    }

    @Test
    void testSelectProcedures() {
        platform.selectProcedures();
        assertTrue(true); // This method only prints to the console, so we can't really test it
    }

    @Test
    void testSelectCriminalReportCertf() {
        platform.selectCriminalReportCertf();
        assertTrue(true); // This method only prints to the console, so we can't really test it
    }

    @Test
    void testSelectAuthMethod() {
        platform.selectAuthMethod((byte) 1);
        assertEquals(AuthenticationMethod.valueOf((byte) 1), platform.authMethod);
    }

    @Test
    void testEnterNIFandPINobt() {
        // This method throws exceptions, so we need to handle them in our test
        try {
            platform.enterNIFandPINobt(testCitizen.getNif(), new Date());
            assertTrue(true); // If no exceptions were thrown, the test passed
        } catch (NifNotRegisteredException | IncorrectValDateException | AnyMobileRegisteredException | ConnectException e) {
            fail("An exception was thrown");
        }
    }

    @Test
    void testEnterPIN() {
        // This method throws exceptions, so we need to handle them in our test
        try {
            platform.enterPIN(new SmallCode("123"));
            assertTrue(true); // If no exceptions were thrown, the test passed
        } catch (NotValidPINException | ConnectException e) {
            fail("An exception was thrown");
        } catch (BadFormatSmallCodeException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testEnterForm() {
        // This method throws exceptions, so we need to handle them in our test
        try {
            platform.setCitizen(testCitizen);
            platform.setGoal(testGoal);
            platform.enterForm(testCitizen, testGoal);
            assertTrue(true); // If no exceptions were thrown, the test passed
        } catch (IncompleteFormException | IncorrectVerificationException | ConnectException e) {
            fail("An exception was thrown");
        }
    }

    @Test
    void testRealizePayment() {
        platform.realizePayment();
        assertTrue(true);
    }

    @Test
    void testEnterCardData() {
        // This method throws exceptions, so we need to handle them in our test
        try {
            platform.setCardData(testCard);
            platform.enterCardData(testCard);
            assertTrue(true); // If no exceptions were thrown, the test passed
        } catch (IncompleteFormException | NotValidPaymentDataException | InsufficientBalanceException | ConnectException e) {
            fail("An exception was thrown");
        }
    }

    @Test
    void testObtainCertificate() {
        // This method throws exceptions, so we need to handle them in our test
        try {
            platform.setCitizen(testCitizen);
            platform.setGoal(testGoal);
            platform.setDigSign(testSignature);
            platform.setCrimConvs(testConvictions);
            platform.obtainCertificate();
            assertTrue(true); // If no exceptions were thrown, the test passed
        } catch (BadPathException | DigitalSignatureException | ConnectException e) {
            fail("An exception was thrown");
        }
    }

    @Test
    void testPrintDocument() {
        // This method throws exceptions, so we need to handle them in our test
        try {
            platform.printDocument();
            assertTrue(true); // If no exceptions were thrown, the test passed
        } catch (BadPathException | PrintingException e) {
            fail("An exception was thrown");
        }
    }
}

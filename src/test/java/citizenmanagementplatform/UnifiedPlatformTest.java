package citizenmanagementplatform;

import citizenmanagementplatform.UnifiedPlatform;
import data.DigitalSignature;
import data.Goal;
import data.Nif;
import data.SmallCode;
import org.junit.Test;
import org.junit.Before;
import publicadministration.Citizen;
import publicadministration.CreditCard;
import publicadministration.CrimConvictionsColl;
import services.CAS;
import services.CertificationAuthority;
import services.GPD;
import services.JusticeMinistry;
import java.net.ConnectException;
//import data.BadPathException;
import exceptions.PrintingException;


import java.math.BigDecimal;
import java.util.Date;

import static java.lang.Boolean.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class UnifiedPlatformTest {
    // Test dependencies
    private CertificationAuthority certificationAuthority;
    private GPD gpd;
    private CAS cas;
    private JusticeMinistry justiceMinistry;
    // Test data
    private Citizen citizen;
    private Goal goal;
    private CreditCard cardData;
    private DigitalSignature digSign;
    private CrimConvictionsColl crimConvs;
    private Nif nif;
    private Date valDate;
    private SmallCode pin;

    @Before
    public void setUp() throws Exception {
        // Initialize test dependencies
        certificationAuthority = mock(CertificationAuthority.class);
        gpd = mock(GPD.class);
        cas = mock(CAS.class);
        justiceMinistry = mock(JusticeMinistry.class);
        // Initialize test data
        nif = new Nif("12345678A");
        valDate = new Date();
        pin = new SmallCode("123");
        citizen = new Citizen(nif, "Artur", "Av. Madrid, 68", "123456789");
        goal = new Goal("Get a job");
        cardData = new CreditCard(nif, "987654321", new Date(), new SmallCode("123"));
        digSign = new DigitalSignature("abcdefg123456");
        crimConvs = new CrimConvictionsColl();
        // Set up mock behavior
        when(certificationAuthority.sendPIN(nif, valDate)).thenReturn(true);
        when(certificationAuthority.checkPIN(nif, pin)).thenReturn(true);
        when(gpd.verifyData(citizen, goal)).thenReturn(true);
        when(cas.askForApproval(anyString(), any(CreditCard.class), any(Date.class), any(BigDecimal.class))).thenReturn(true);
    }

    @Test
    public void testObtainCriminalRecordCertificate() throws Exception {
        // Create UnifiedPlatform object and inject dependencies
        UnifiedPlatform platform = new UnifiedPlatform();
        platform.setCertificationAuthority(certificationAuthority);
        platform.setGPD(gpd);
        platform.setCAS(cas);
        platform.setJusticeMinistry(justiceMinistry);
        // Set up mock behavior for obtaining certificate
        //when(justiceMinistry.getCriminalRecordCertf(citizen, goal)).thenReturn(true);
        doAnswer(invocation -> {
            return TRUE;
        }).when(justiceMinistry).getCriminalRecordCertf(citizen, goal);

        // Execute use case
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod((byte) 0);
        platform.enterNIFandPINobt(nif, valDate);
        platform.enterPIN(pin);
        platform.enterForm(citizen, goal);
        platform.realizePayment();
        platform.enterCardData(cardData);
        platform.obtainCertificate();
        // Verify that certificate was obtained
        verify(justiceMinistry).getCriminalRecordCertf(citizen, goal);
    }
}
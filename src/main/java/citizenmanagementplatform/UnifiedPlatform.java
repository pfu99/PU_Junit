package citizenmanagementplatform;

import data.*;
import enums.Goal;
import exceptions.*;
import publicadministration.*;
import services.CertificationAuthority;
import enums.AuthenticationMethod;
import services.GPD;
import services.CAS;
import services.JusticeMinistry;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class UnifiedPlatform {
    private Citizen citizen;
    private Goal goal;
    private CreditCard cardData;
    private DigitalSignature digSign;
    private CrimConvictionsColl crimConvs;
    private CertificationAuthority certificationAuthority;
    private Object authMethod;
    private GPD gpd;
    private CAS cas;
    private JusticeMinistry justiceMinistry;

    public UnifiedPlatform() {
        this.citizen = null;
        this.goal = null;
        this.cardData = null;
        this.digSign = null;
        this.crimConvs = null;
    }

    // Input events
    public void selectJusMin() {
        System.out.println("Entering to Ministerio de Justicia");
    }
    ;

    public void selectProcedures() {
        System.out.println("Selected Trámites");
    }

    ;

    public void selectCriminalReportCertf() {
        System.out.println("Procedure selected for obtaining a Criminal Report");
    }

    ;

    public void selectAuthMethod(byte opc) {
        this.authMethod = AuthenticationMethod.valueOf(opc);
        System.out.println("Showing authentication form");
    }

    ;

    public void enterNIFandPINobt(Nif nif, Date valDate)
            throws NifNotRegisteredException, IncorrectValDateException,
            AnyMobileRegisteredException, ConnectException {
        if (this.certificationAuthority.sendPIN(nif, valDate))
            System.out.println("PIN has been sent correctly");
    }

    public void enterPIN(SmallCode pin) throws NotValidPINException,
            ConnectException {
        if (this.certificationAuthority.checkPIN(citizen.getNif(), pin))
            System.out.println("PIN checked correctly");
        else
            throw new NotValidPINException("The entered PIN is not valid");
    }

    private void enterForm(Citizen citz, Goal goal) throws IncompleteFormException, IncorrectVerificationException,
            ConnectException {
        if (citz == null || goal == null)
            throw new IncompleteFormException("Please fill all the required fields in the form");
        if (!gpd.verifyData(citz, goal))
            throw new IncorrectVerificationException("The DGP could not verify the entered information");
        this.citizen = citz;
        this.goal = goal;
    }

    private void realizePayment() {
        System.out.println("Ready to pay");
    }

    private void enterCardData(CreditCard cardD) throws IncompleteFormException, NotValidPaymentDataException,
            InsufficientBalanceException, ConnectException {
        if (cardD == null) {
            throw new IncompleteFormException("Credit card information is missing");
        }
        CardPayment cardPayment = new CardPayment(citizen.getNif(), crimConvs.getPrice());
        if (!cas.askForApproval(cardPayment.getReference(), cardD, cardPayment.getDate(), cardPayment.getImportValue())) {
            throw new NotValidPaymentDataException("Credit card information is incorrect");
        }
        this.cardData = cardD;
    }

    private void obtainCertificate () throws BadPathException, DigitalSignatureException, ConnectException {
        justiceMinistry.getCriminalRecordCertf(citizen, goal);
    }

    private void printDocument () throws BadPathException,
            PrintingException{

    }

// The setter methods for injecting the dependences

    public void setCitizen(Citizen citizen){
        this.citizen = citizen;
    }

    public void setGoal(Goal goal){
        this.goal = goal;
    }

    public void setDigSign(DigitalSignature digSign){
        this.digSign = digSign;
    }

    public void setCardData(CreditCard cardData){
        this.cardData = cardData;
    }

    public void setCrimConvs(CrimConvictionsColl crimConvs){
        this.crimConvs = crimConvs;
    }

    // Other input events (not required)
    public void enterCred (Nif nif, Password passw) throws
            NifNotRegisteredException, NotValidCredException,
            AnyMobileRegisteredException, ConnectException{
        certificationAuthority.ckeckCredent(nif, passw);
        //enterPIN(certificationAuthority.ckeckCredent(nif, passw));

    }

    // Other internal operations (not required)
    private void registerPayment () { }
    private void openDocument (DocPath path) throws BadPathException{

    }
    private void printDocument (DocPath path) throws BadPathException, PrintingException{

    }
}
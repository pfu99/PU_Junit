package citizenmanagementplatform;
import exceptions.*;
import data.*;
import publicadministration.*;

import java.util.Date;


public class UnifiedPlatform {
    public UnifiedPlatform(){

    }
    // Input events
    public void selectJusMin () {
        System.out.println("Entering to Ministerio de Justicia");
    };
    public void selectProcedures () {
        System.out.println("Selected Trámites");
    };
    public void selectCriminalReportCertf () {
        System.out.println("Procedure selected for obtaining a Criminal Report");
    };
    public void selectAuthMethod (byte opc) {
        this.authMethod = AuthenticationMethod.valueOf(opc);
        System.out.println("Showing authentication form");
    };
    public void enterNIFandPINobt (Nif nif, Date valDate)
            throws NifNotRegisteredException, IncorrectValDateException,
            AnyMobileRegisteredException, ConnectException{

    }
    public void enterPIN (SmallCode pin) throws NotValidPINException,
            ConnectException {

    }
    private void enterForm (Citizen citz, Goal goal) throws IncompleteFormException, IncorrectVerificationException,
    ConnectException{

    }
    private void realizePayment () {

    }
    private void enterCardData (CreditCard cardD) throws IncompleteFormException, NotValidPaymentDataException,
    InsufficientBalanceException, ConnectException{

    }
    private void obtainCertificate () throws BadPathException,
    DigitalSignatureException, ConnectException{

    }
    private void printDocument () throws BadPathException,
    PrintingException{

    }

 (. . .) // The setter methods for injecting the dependences

         (. . .) // Other input events (not required)
    // Other internal operations (not required)
    private void registerPayment () { }
    private void openDocument (DocPath path) throws BadPathException{

    }
    private void printDocument (DocPath path) throws BadPathException, PrintingException{

    }
}
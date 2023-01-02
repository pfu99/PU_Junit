package citizenmanagementplatform;
import exceptions.*;
import data.*;
import jdk.internal.org.objectweb.asm.util.Printer;
import publicadministration.*;
import enums.*;
import java.util.Date;

public class UnifiedPlatform {
    private AuthenticationMethod authMethod;
    private Citizen citizen;
    private DigitalSignature digSign;
    private Printer printer;
    private CrimConvictionsColl crimConvs;

    public UnifiedPlatform(AuthenticationMethod authMethod, Printer printer) {
        this.authMethod = authMethod;
        this.printer = printer;
    }

    // Input events
    public void selectJusMin () {
        System.out.println("Entering to Ministerio de Justicia");
    }
    public void selectProcedures () {
        System.out.println("Selected Trámites");
    }
    public void selectCriminalReportCertf () {
        System.out.println("Procedure selected for obtaining a Criminal Report");
    }
    public void selectAuthMethod (byte opc) {
        this.authMethod = AuthenticationMethod.valueOf(opc);
        System.out.println("Selected authentication method: " + this.authMethod);
    }
    }
    public void enterNIFandPINobt (Nif nif, Date valDate)
            throws NifNotRegisteredException, IncorrectValDateException,
            AnyMobileRegisteredException, ConnectException{
        this.authMethod.obtainPIN(nif, valDate);
    }
    public void enterPIN (SmallCode pin) throws NotValidPINException,
            ConnectException {
        this.authMethod.authenticate(pin);
    }
    private void enterForm (Citizen citz, Goal goal) throws IncompleteFormException, IncorrectVerificationException,
            ConnectException {
        this.citizen = citz;
        this.crimConvs = this.authMethod.checkCriminalRecords(citz, goal);
    }
    private void realizePayment () {}
    private void obtainCertificate () throws BadPathException,
            DigitalSignatureException, ConnectException {
        this.digSign = this.authMethod.signDoc(this.crimConvs);
    }
    private void printDocument () throws BadPathException, PrintingException {
        this.printer.print(this.crimConvs, this.digSign);
    }
    // The setter methods for injecting the dependences
    public void setAuthenticationMethod (AuthenticationMethod authMethod) {
        this.authMethod = authMethod;
    }
    public void setPrinter (Printer printer) {
        this.printer = printer;
    }
    // Other input events (not required)
// Other internal operations (not required)
    private void registerPayment () {
        this.crimConvs.registerPayment();
    }
    private void openDocument (DocPath path) throws BadPathException {
        this.digSign.openDoc(path);
    }
    private void printDocument (DocPath path) throws BadPathException, PrintingException {
        this.printer.print(path);
    }
}
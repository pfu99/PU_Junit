package publicadministration;

public class CriminalRecordCertf extends PDFDocument { // Representskd
    the Criminal Record Certificate
    private Nif nif;
    private String name;
    private Goal goal;
    private DigitalSignature digSign;
    private CrimConvictionsColl crimConvs;

    public CriminalRecordCertf (Nif nif, String name, Goal g,
                                DigitalSignature ds, CrimConvictionsColl crmC)
    { . . . } // Initializes attributes
 (. . .) // the getters
}


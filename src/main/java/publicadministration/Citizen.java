package publicadministration;

import data.Nif;

public class Citizen {
    // Represents all the information required for a citizen
    private final Nif nif;
    private final String name;
    private final String address;
    private final String mobileNumber;
    private PDFDocument document;


    public Citizen (Nif nif, String name, String address, String mobileNumber) {
        this.nif = nif;
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    public Nif getNif() {
        return nif;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public PDFDocument getDocument() {
        return document;
    }

    public void setDocument(PDFDocument document) {
        this.document = document;
    }

    @Override
    public String toString () {
        return "Citizen{" +
                "nif=" + nif +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}

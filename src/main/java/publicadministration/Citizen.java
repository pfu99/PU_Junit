package publicadministration;

import data.Nif;

public class Citizen {
    // Represents all the information required for a citizen
    private Nif nif;
    private String name;
    private String address;
    private String mobileNumber;

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

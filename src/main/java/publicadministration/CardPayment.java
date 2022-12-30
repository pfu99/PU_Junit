package publicadministration;

import java.math.BigDecimal;
import java.util.Date;
import data.Nif;

public class CardPayment {
    // The information associated to the payment realized via internet
    private final String reference; // The code of the operation
    private final Nif nif; // The nif of the user
    private final Date date; // The date of the operation
    private final BigDecimal importValue; // The import of the payment

    public CardPayment (Nif nif, BigDecimal importValue) {
        this.nif = nif;
        this.importValue = importValue;
        this.date = new Date();
        this.reference = "";
    }

    public String getReference() {
        return reference;
    }

    public Nif getNif() {
        return nif;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getImportValue() {
        return importValue;
    }

    @Override
    public String toString() {
        return "CardPayment{" +
                "reference='" + reference + '\'' +
                ", nif=" + nif +
                ", date=" + date +
                ", importValue=" + importValue +
                '}';
    }
}

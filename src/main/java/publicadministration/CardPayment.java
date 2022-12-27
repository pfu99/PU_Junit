package publicadministration;

public class CardPayment {
    // The information associated to the payment realized via internet
    private final String reference; // The code of the operation
    private final Nif nif; // The nif of the user
    private final Date date; // The date of the operation
    private final BigDecimal import; // The import of the payment
    public CardPayment (Nif nif, BigDecimel imp) { . . . }
// Initializes attributes
 (. . .) // the getters
    @Override
    public String toString () { . . . } // converts to String
}

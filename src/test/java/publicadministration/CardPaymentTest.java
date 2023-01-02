package publicadministration;

import data.Nif;
import exceptions.BadFormatNifException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CardPaymentTest {

    @Test
    public void testCardPayment() throws BadFormatNifException {
        CardPayment card = new CardPayment(new Nif("12345678A"), new BigDecimal(82));
        assertEquals(new Nif("12345678A"), card.getNif());
        assertEquals(new BigDecimal(82), card.getImportValue());
        assertNotNull(card.getReference());
        assertNotNull(card.getDate());
    }
}

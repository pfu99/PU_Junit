package publicadministration;

import data.Nif;
import data.SmallCode;
import exceptions.BadFormatNifException;
import exceptions.BadFormatSmallCodeException;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardTest {
    @Test
    public void testCreditCard() throws BadFormatNifException, BadFormatSmallCodeException {
        CreditCard creditCard = new CreditCard(new Nif("123456789A"), "987654321", new Date(), new SmallCode("1234"));
        assertEquals(new Nif("123456789A"), creditCard.getNif());
        assertEquals("987654321", creditCard.getCardNumb());
        assertEquals(new Date(), creditCard.getExpirDate());
        assertEquals(new SmallCode("1234"), creditCard.getSvc());
    }
}

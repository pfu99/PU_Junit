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
        Date date1 = new Date();
        CreditCard creditCard = new CreditCard(new Nif("12345678A"), "987654321", date1, new SmallCode("123"));
        assertEquals(new Nif("12345678A"), creditCard.getNif());
        assertEquals("987654321", creditCard.getCardNumb());
        assertEquals(date1, creditCard.getExpirDate());
        assertEquals(new SmallCode("123"), creditCard.getSvc());
    }
}

package publicadministration;

import data.Nif;
import exceptions.BadFormatNifException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CitizenTest {
    @Test
    public void testCitizen() throws BadFormatNifException {
        Citizen citizen = new Citizen(new Nif("12345678A"), "Nil Ojeda", "Av. Madrid, 68", "123456789");
        assertEquals(new Nif("12345678A"), citizen.getNif());
        assertEquals("Nil Ojeda", citizen.getName());
        assertEquals("Av. Madrid, 68", citizen.getAddress());
        assertEquals("123456789", citizen.getMobileNumber());
    }

}

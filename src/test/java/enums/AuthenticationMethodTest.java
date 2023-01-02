package enums;

import exceptions.BadFormatNifException;
import org.junit.jupiter.api.Test;
import data.Nif;
import java.util.Date;

public class AuthenticationMethodTest {
    @Test
    public void testObtainPIN() throws BadFormatNifException {
        Nif nif = new Nif("12345678A");
        Date valDate = new Date();
        AuthenticationMethod.CLAVE_PIN.obtainPIN(nif, valDate);
    }
}

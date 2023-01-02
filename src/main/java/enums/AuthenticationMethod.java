package enums;

import data.Nif;
import data.SmallCode;
import exceptions.*;
import services.CertificationAuthority;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

public enum AuthenticationMethod {
    CLAVE_PIN((byte) 0),
    CLAVE_PERMANENTE((byte) 1),
    CERTIFICADO_DIGITAL((byte) 2);

    private final byte value;

    AuthenticationMethod(byte value) {
        this.value = value;
    }

    public static String getAuthOptions() {
        return Arrays.stream(AuthenticationMethod.values())
                .map(AuthenticationMethod::toString)
                .collect(Collectors.joining());
    }

    public static AuthenticationMethod valueOf(byte value) {
        for (AuthenticationMethod method : AuthenticationMethod.values()) {
            if (method.value == value) return method;
        }
        throw new IllegalArgumentException(value + " isn't an AuthenticationMethod");
    }

    public byte getByte() {
        return value;
    }

    @Override
    public String toString() {
        return "Authentication Method: " + name() + " has byte value: " + value;
    }

    public void obtainPIN(Nif nif, Date valDate) {
        AuthenticationMethod authMethod = AuthenticationMethod.CLAVE_PIN;

        authMethod.obtainPIN(nif, valDate);
    }

    public void authenticate(SmallCode pin) throws NotValidPINException, ConnectException {
        // Connect to the certification authority's service
        CertificationAuthority certAuth = new CertificationAuthority();
        boolean valid = certAuth.checkPIN(pin);

        if (!valid) {
            throw new NotValidPINException();
        }
    }
}

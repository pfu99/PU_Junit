package data;

import exceptions.BadFormatSignatureException;

final public class DigitalSignature {
    private final String signature;
    public DigitalSignature(String code) throws BadFormatSignatureException {
        if (code == null) throw new NullPointerException("Digital signature code is null.");
        this.signature = code;
    }
    public String getSignature() { return signature; }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalSignature dSignature = (DigitalSignature) o;
        return signature.equals(dSignature.signature);
    }
    @Override
    public int hashCode () { return signature.hashCode(); }
    @Override
    public String toString () {
        return signature;
    }

}
package data;

import exceptions.BadFormatSmallCodeException;

final public class SmallCode {
    private static final String CODE_REGEX = "^[0-9]+$";
    private static final int CODE_LENGTH = 3;
    private final String smallCode;
    public SmallCode (String code) throws BadFormatSmallCodeException {
        if (code == null) throw new NullPointerException("SmallCode is null.");
        if (!code.matches(CODE_REGEX)) throw new BadFormatSmallCodeException("SmallCode should be in numeric format");
        if (code.length() != CODE_LENGTH)
            throw new BadFormatSmallCodeException("SmallCode should be " + CODE_LENGTH + " digits");
        this.smallCode = code;
    }
    public String getSmallCode () { return smallCode; }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmallCode niff = (SmallCode) o;
        return smallCode.equals(niff.smallCode);
    }
    @Override
    public int hashCode () { return smallCode.hashCode(); }
    @Override
    public String toString () {
        return smallCode;
    }
}
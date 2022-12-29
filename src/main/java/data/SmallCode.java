package data;

import exceptions.BadFormatSmallCodeException;

final public class SmallCode {
    private static final String CODE_REGEX = "^[0-9]+$";
    private static final int CODE_LENGTH = 3;
    private final String smallCode;
    public SmallCode (String code) throws BadFormatSmallCodeException {
        if (code == null) throw new NullPointerException("SmallCode is null.");
        if (!code.matches(CODE_REGEX))
            throw new BadFormatSmallCodeException("SmallCode should be 3 digits and contain only numeric characters");
        if (code.length() != CODE_LENGTH)
            throw new BadFormatSmallCodeException("SmallCode should be " + CODE_LENGTH + " digits");
        this.smallCode = code;
    }
    public String getSmallCode () { return smallCode; }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmallCode other = (SmallCode) o;
        if (smallCode == null || other.smallCode == null) return false;
        return smallCode.equals(other.smallCode);
    }
    @Override
    public int hashCode () { return smallCode.hashCode(); }
    @Override
    public String toString () {
        return smallCode;
    }
}
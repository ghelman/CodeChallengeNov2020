package com.gabrielhelman.challenge;

import java.util.Objects;

/**
 * Encapsulates a US-style zipcode. Once created, ZipCode objects should be treated as an immutable.
 * <p>
 * Note that this is a ZipCode, not an international Postal Code.
 *
 * <p>
 * <b>Note:</b> In real life, US Zip codes are a 5-digit main code and a 4 digit "plus4" code.
 * The plus4 value is currently surplus to requirements, and has been left out of this implementation.
 * Should that no longer be the case, adding a second stored property should be a reasonably trivial exercise.
 * </p>
 */
public class ZipCode implements Comparable<ZipCode> {

    /*
    The core 5-digit code.  This class does no validation on the value, that's assumed to be the responsibility of another class.
     */
    private final Integer code;

    /**
     * Construct a new zipcode object.
     *
     * @param code the numeric value of this zip code.
     */
    public ZipCode(Integer code) {
        this.code = code;
    }

    /**
     * Gets the numeric value of this zip code.
     *
     * @return the zip code as an integer.
     */
    public Integer getCode() {
        return code;
    }

    @Override
    public int compareTo(ZipCode o) {
        return this.code.compareTo(o.code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipCode zipCode = (ZipCode) o;
        return Objects.equals(code, zipCode.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "ZipCode{" +
                "code=" + code +
                '}';
    }
}


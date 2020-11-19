package com.gabrielhelman.challenge;

import java.util.Objects;

/**
 * Encapsulates a US-style zipcode.
 *
 *
 * Potential Extension points:
 *
 * Adding a ZIP+4 code requires adding a new property and adjusting other methods below.
 *
 */
public class ZipCode implements Comparable<ZipCode> {

    private Integer code;

    public ZipCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    private void setCode(Integer code) {
        this.code = code;
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


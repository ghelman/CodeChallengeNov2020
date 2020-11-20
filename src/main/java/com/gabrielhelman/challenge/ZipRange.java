package com.gabrielhelman.challenge;

import java.util.Objects;

/**
 * Represents a range of US-style {@code ZipCode}s, as a pair of low and high codes, inclusive.
 * Once created, {@code ZipRange}s should be treated as immutable.
 */
public class ZipRange implements Comparable<ZipRange> {

    /**
     * Low-end of the zip range.
     */
    private final ZipCode low;

    /**
     * High end of the zip range.
     */
    private final ZipCode high;

    /**
     * Construct a new zip range.
     *
     * @param low  low end of the zipcode range.
     * @param high high end of the zipcode range.
     */
    public ZipRange(ZipCode low, ZipCode high) {
        this.low = low;
        this.high = high;
    }

    /**
     * Gets the low end of the zipcode range.
     *
     * @return a {@link ZipCode} object representing the low end of the range.
     */
    public ZipCode getLow() {
        return low;
    }

    /**
     * Gets the high end of the zipcode range.
     *
     * @return a {@link ZipCode} object representing the high end of the range.
     */
    public ZipCode getHigh() {
        return high;
    }

    /**
     * Checks if a given {@link ZipCode} is within this range.
     *
     * @param value a ZipCode to check.
     * @return {code true} if this range includes the specified range.
     */
    public boolean contains(ZipCode value) {
        return low.getCode() <= value.getCode() && high.getCode() >= value.getCode();
    }

    /**
     * Checks if two {@code ZipRange} objects overlap.
     *
     * @param o The other range to check against this one.
     * @return {@code True} if any part of the two ranges overlap.
     */
    public boolean overlap(ZipRange o) {
        boolean result = false;
        if (this.contains(o.getLow())
                || this.contains(o.getHigh())
                || o.contains(this.getLow())
                || o.contains(this.getHigh())
        ) {
            result = true;
        }
        return result;
    }

    /**
     * Creates a new {@link ZipRange} representing the specified range combined with this one.  Neither that range or
     * this are mutated.
     *
     * @param o The other ZipRange to merge with this one.
     * @return a new ZipRange, representing the superset of the two ranges.
     */
    public ZipRange merge(ZipRange o) {
        ZipCode lowest;
        if (this.low.getCode() < o.low.getCode()) {
            lowest = this.low;
        } else {
            lowest = o.low;
        }

        ZipCode highest;
        if (this.high.getCode() > o.high.getCode()) {
            highest = this.high;
        } else {
            highest = o.high;
        }

        return new ZipRange(lowest, highest);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipRange zipRange = (ZipRange) o;
        return Objects.equals(low, zipRange.low) &&
                Objects.equals(high, zipRange.high);
    }

    @Override
    public int hashCode() {
        return Objects.hash(low, high);
    }

    @Override
    public int compareTo(ZipRange o) {
        return this.low.compareTo(o.low);
    }

    @Override
    public String toString() {
        return "ZipRange{" +
                "low=" + low +
                ", high=" + high +
                '}';
    }
}

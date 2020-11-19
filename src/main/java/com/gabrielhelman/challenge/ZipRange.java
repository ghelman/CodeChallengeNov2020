package com.gabrielhelman.challenge;

import java.util.Objects;

/**
 * Represents a range of US-style {@code ZipCode}s, as a pair of low and high codes, inclusive..
 */
public class ZipRange implements Comparable<ZipRange> {

    private final ZipCode low;
    private final ZipCode high;

    public ZipRange(ZipCode low, ZipCode high) {
        this.low = low;
        this.high = high;
    }

    public ZipCode getLow() {
        return low;
    }

    public ZipCode getHigh() {
        return high;
    }

    public boolean contains(ZipCode value){
        return low.getCode() <= value.getCode() && high.getCode() >= value.getCode();
    }

    public boolean overlap(ZipRange o){
        boolean result = false;
        if( this.contains(o.getLow())
                || this.contains(o.getHigh())
                || o.contains(this.getLow())
                || o.contains(this.getHigh())
        ){
            result = true;
        }
        return result;
    }




    public ZipRange merge(ZipRange o){
        ZipCode lowest;
        if (this.low.getCode() < o.low.getCode()){
            lowest = this.low;
        } else {
            lowest = o.low;
        }

        ZipCode highest;
        if (this.high.getCode() > o.high.getCode()){
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

package com.gabrielhelman.challenge;

import junit.framework.TestCase;

import java.util.ArrayList;

public class ZipRangeTest extends TestCase {

    /*

    If the input = [94133,94133] [94200,94299] [94226,94399]
    Then the output should be = [94133,94133] [94200,94399]

     */



    public void testContains() {

        ZipRange zr2 = new ZipRange(new ZipCode(94200), new ZipCode(94299));
        assertTrue(zr2.contains(94201));
        assertFalse(zr2.contains(42));

    }

    public void testOverlap() {

        ZipRange zr1 = new ZipRange(new ZipCode(94133), new ZipCode(94133));
        ZipRange zr2 = new ZipRange(new ZipCode(94200), new ZipCode(94299));
        ZipRange zr4 = new ZipRange(new ZipCode(94226), new ZipCode(94399));

        assertFalse(zr1.overlap(zr2));

        assertTrue( zr2.overlap(zr4) );

    }

    public void testMerge() {

        ZipRange zr2 = new ZipRange(new ZipCode(94200), new ZipCode(94299));
        ZipRange zr4 = new ZipRange(new ZipCode(94226), new ZipCode(94399));

        ZipRange merged = zr2.merge(zr4);

        ZipRange zr5 = new ZipRange(new ZipCode(94200), new ZipCode(94399));

        assertTrue(zr5.equals(merged));

    }
}
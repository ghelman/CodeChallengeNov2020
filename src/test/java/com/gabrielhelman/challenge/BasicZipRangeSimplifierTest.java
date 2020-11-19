package com.gabrielhelman.challenge;

import junit.framework.TestCase;

import java.util.ArrayList;

/*

If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399]
Then the output should be = [94133,94133] [94200,94399]

 */
public class BasicZipRangeSimplifierTest extends TestCase {

    public void testRangeExample1() {

        ZipRange zr1 = new ZipRange(new ZipCode(94133), new ZipCode(94133));
        ZipRange zr2 = new ZipRange(new ZipCode(94200), new ZipCode(94299));
        ZipRange zr3 = new ZipRange(new ZipCode(94600), new ZipCode(94699));
        ArrayList<ZipRange> inputList = new ArrayList<>();
        inputList.add(zr1);
        inputList.add(zr2);
        inputList.add(zr3);

        ZipRangeSimplifier zrs = new BasicZipRangeSimplifier();

        assertEquals(inputList, zrs.simplify(inputList) );

    }

    /*
    If the input = [94133,94133] [94200,94299] [94226,94399]
    Then the output should be = [94133,94133] [94200,94399]

     */
    public void testRangeExample2() {

        ZipRange zr1 = new ZipRange(new ZipCode(94133), new ZipCode(94133));
        ZipRange zr2 = new ZipRange(new ZipCode(94200), new ZipCode(94299));
        ZipRange zr4 = new ZipRange(new ZipCode(94226), new ZipCode(94399));
        ArrayList<ZipRange> inputList = new ArrayList<>();
        inputList.add(zr1);
        inputList.add(zr2);
        inputList.add(zr4);

        ArrayList<ZipRange> whatWeWant = new ArrayList<>();
        whatWeWant.add(zr1);
        ZipRange zr5 = new ZipRange(new ZipCode(94200), new ZipCode(94399));
        whatWeWant.add(zr5);

        ZipRangeSimplifier zrs = new BasicZipRangeSimplifier();

        assertEquals(whatWeWant, zrs.simplify(inputList) );




    }


}
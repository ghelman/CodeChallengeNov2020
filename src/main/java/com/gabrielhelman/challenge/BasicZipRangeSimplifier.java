package com.gabrielhelman.challenge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Like it says on the tin, what's simplest possible way to make this work:
 *
 * If the input = [94133,94133] [94200,94299] [94600,94699]
 * Then the output should be = [94133,94133] [94200,94299] [94600,94699]
 *
 * If the input = [94133,94133] [94200,94299] [94226,94399]
 * Then the output should be = [94133,94133] [94200,94399]
 *
 */
public class BasicZipRangeSimplifier implements ZipRangeSimplifier {


    @Override
    public Collection<ZipRange> simplify(Collection<ZipRange> sourceRanges) {
        List<ZipRange> result = new ArrayList<ZipRange>();

        //first, to make our lives easier, let's sort the incoming list
        List<ZipRange> sorted = sourceRanges.stream().sorted().collect(Collectors.toList());
        //something that looks like
            //examine each range
            //current result range - expand or create new?
            //there has to be a set theory way to do this



        ZipRange current = sorted.get(0);

        for (ZipRange z : sorted ) {
            if(current == null){
                current = z;
            } else {
                if( current.overlap(z) ){
                    current = current.merge(z);

                } else {
                    result.add(current);
                    current = z;
                }
            }
        }








        result.add(current);



        return result;
    }
}

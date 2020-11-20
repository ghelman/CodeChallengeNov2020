package com.gabrielhelman.challenge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds),
 * provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.
 * <p>
 * <p>
 * Like it says on the tin, what's simplest possible way to make this work:
 * <p>
 * If the input = [94133,94133] [94200,94299] [94600,94699]
 * Then the output should be = [94133,94133] [94200,94299] [94600,94699]
 * <p>
 * If the input = [94133,94133] [94200,94299] [94226,94399]
 * Then the output should be = [94133,94133] [94200,94399]
 */
public class BasicZipRangeSimplifier implements ZipRangeSimplifier {


    @Override
    public Collection<ZipRange> simplify(Collection<ZipRange> sourceRanges) {
        List<ZipRange> result = new ArrayList<>();

        //first, to make our lives easier, let's sort the incoming list
        List<ZipRange> sorted = sourceRanges.stream().sorted().collect(Collectors.toList());

        //single pass, checking for overlaps
        //we can pull the first element off the list and "prime the pump".
        ZipRange previous = sorted.get(0);

        //sublist doesn't make a copy, so using a sublist here shouldn't be a major performance hit while making it clear what's going on
        //we could do this as a java8+ stream function, but it would be less clear to read
        for (ZipRange current : sorted.subList(1, sorted.size())) {
            if (previous.overlap(current)) {
                previous = previous.merge(current);
            } else {
                result.add(previous);
                previous = current;
            }
        }
        //don't forget about the last one
        result.add(previous);
        return result;
    }
}

package com.gabrielhelman.challenge;

import java.util.Collection;

/**
 * Represents an object that can simplify a collection of {@link ZipRange}s.
 */
public interface ZipRangeSimplifier {

    /**
     * Given a {@code Collection} of {@link ZipRange} objects, return a collection holding the smallest number of  ZipRanges that cover the same ground.
     *
     * @param sourceRanges a Collection of ranges that specify the source constraints.
     * @return The smallest number of ZipRanges that can be used to represent the input; the concrete class of the returned {@code Collection} is left up to the implementation and should not be depended on.
     */
    Collection<ZipRange> simplify(Collection<ZipRange> sourceRanges);

}

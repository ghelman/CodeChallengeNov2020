package com.gabrielhelman.challenge;

import java.util.Collection;

public interface ZipRangeSimplifier {

    /**
     * Given a @code{Collection} of ZipRange objects, return a collection holding the smallest number of  ZipRanges that cover the same ground.
     *
     * @param sourceRanges
     * @return The smallest number of ZipRanges that can be used to represent the input; the concrete class of the returned collection is left up to the implementation.
     */
    Collection<ZipRange> simplify(Collection<ZipRange> sourceRanges);

}

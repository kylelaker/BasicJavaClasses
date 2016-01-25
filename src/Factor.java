/*
 * Copyright (c) 2016 Kyle Laker
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Provides the prime factorization of a given number.
 *
 * @author Kyle Laker
 * @version 20160124
 */
public class Factor {
    private static final Map<Long, Long> factors = new HashMap<>();

    /**
     * Provides the factors of a given number.
     * @param n The number to factorize
     */
    private static void factorize(long n) {
        long q = n, t = 2;
        while (t <= Math.sqrt(q))
            if (q % t == 0) {
                addKey(t);
                q /= t;
            } else t++;
        if (q != n) addKey(q);
    }

    /**
     * Adds a key to the factors map, if the key already exists, increment its
     * value by 1.
     * @param k The key to add to the map.
     */
    private static void addKey(long k) {
        factors.put(k, factors.containsKey(k) ? factors.get(k) + 1L : 1L);
    }

    public Map<Long, Long> getFactors() {
        return factors;
    }
}
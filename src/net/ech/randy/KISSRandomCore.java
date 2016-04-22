//
// KISSRandomCore.java
// 

package net.ech.randy;

import java.util.*;

/**
 * Class KISSRandomCore implements the KISS random number generator
 * developed by George Marsaglia at Florida State University through
 * research supported by NSF Grant DMS-9206972.
 */
public class KISSRandomCore implements IRandomCore
{
    private int seed_w, seed_x, seed_y, seed_z;

    /** 
     * Constructor.   Seed is initialized to a value based on the
     * current time. 
     */
    public KISSRandomCore()
    {
        setSeed(System.currentTimeMillis ());
    }

    /**
     * @inheritDoc
     */
    public void setSeed(long seed)
    {
        seed_w = 916191069;  // magic number
        seed_x = (int)(seed >>> 32);
        seed_y = (int)(seed | 1);      // ensure non-zero value
        seed_z = 521288629;  // another magic number
    }

    /**
     * @inheritDoc
     */
    public int nextBits(int bits)
    {
        // LC generator - not full period - loop defined by initial seed_w
        seed_w = 30903 * (seed_w & 0xFFFF) + (seed_w >>> 16);

        // LC generator - period = 2^32
        seed_x = 69069 * seed_x + 1327217885;

        //  LFSR generator - period = 2^32-1 (Zero not allowed)
        seed_y ^= (seed_y << 13);
        seed_y ^= (seed_y >>> 17);
        seed_y ^= (seed_y << 5);

        // LC generator - not full period - loop defined by initial seed_z
        seed_z = 18000 * (seed_z & 0xFFFF) + (seed_z >>> 16);
    
        int rnd = (seed_w << 16) + seed_x + seed_y + (seed_z & 0xFFFF);
        rnd >>>= (32 - bits);
        return rnd;
    }
}

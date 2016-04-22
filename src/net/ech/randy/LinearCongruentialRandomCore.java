//
// LinearCongruentialRandomCore.java
//

package net.ech.randy;

/**
 * Simple random number generator based on Donald Knuth's 
 * <i>The Art of Computer Programming, Volume 2</i>, Section 3.2.1. 
 * This implementation uses a 48-bit seed, which is modified using a
 * linear congruential formula.
 */
public class LinearCongruentialRandomCore
    implements IRandomCore
{
    private long seed;

    private final static long MULTIPLIER = 0x5DEECE66DL;
    private final static long ADDEND = 0xBL;
    private final static long MASK = (1L << 48) - 1;

    /** 
     * Constructor.   The sequence is seeded by a value based on the 
     * current time.
     */
    public LinearCongruentialRandomCore()
    {
        setSeed(System.currentTimeMillis ());
    }

    /**
     * @inheritDoc
     */
    public void setSeed(long seed)
    {
        this.seed = (seed ^ MULTIPLIER) & MASK;
    }

    /**
     * @inheritDoc
     */
    public int nextBits(int bits)
    {
        long nextseed = (seed * MULTIPLIER + ADDEND) & MASK;
        seed = nextseed;
        return (int)(nextseed >>> (48 - bits));
    }
}     

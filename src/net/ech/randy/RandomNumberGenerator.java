//
// RandomNumberGenerator.java
//

package net.ech.randy;

/**
 * A random number service, similar in spirit to <code>java.util.Random</code>.
 * <p>
 * A RandomNumberGenerator instance is composed of an IRandomCore instance,
 * to which the RandomNumberGenerator delegates responsibility for its
 * pseudo-random number sequence.  The core may be of any IRandomCore subtype
 * (Strategy pattern).  This class decorates the core RNG with a number of
 * useful service methods.
 *
 * @see java.util.Random
 */
public class RandomNumberGenerator
{
    private static final int BITS_PER_BYTE = 8;
    private static final int BYTES_PER_INT = 4;

    // Core RNG.
    private IRandomCore core;

    /**
     * Constructor.  Creates a default random number generator, seeded by
     * the current system time.
     */
    public RandomNumberGenerator ()
    {
        this(new DefaultRandomCore());
    }

    /**
     * Constructor.
     * @param core   The core pseudo-random sequence generator.
     */
    public RandomNumberGenerator(IRandomCore core)
    {
        this.core = core;
    }

    /**
     * Set the core of this random number generator.
     * @param core   an IRandomCore instance
     */
    public final void setCore(IRandomCore core)
    {
        this.core = core;
    }

    /**
     * Set the seed of this random number generator.  Note that if two
     * RandomNumberGenerator instances receive the same seed and have the
     * same type of core, they will generate identical sequences.
     * @param seed   the seed value
     */
    public final void setSeed(long seed)
    {
        core.setSeed(seed);
    }

    /**
     * Return the next pseudorandom, uniformly distributed <code>int</code>
     * value from this random number generator's sequence.
     *
     * @return  the next pseudorandom, uniformly distributed <code>int</code>
     *          value from this random number generator's sequence.
     */
    public final int nextInt()
    {
        return nextBits(32);
    }

    /**
     * Return the next pseudorandom, uniformly distributed <code>int</code>
     * value in the range (0 <= n < limit) from this random number
     * generator's sequence.
     *
     * @param limit  a non-negative <code>int</code> value
     * @return  the next pseudorandom, uniformly distributed <code>int</code>
     *          value from this random number generator's sequence.
     */
    public final int nextInt(int limit)
    {
        return (int)(nextDouble() * limit);
    }

    /**
     * Returns the next pseudorandom, uniformly distributed <code>long</code>
     * value from this random number generator's sequence.
     *
     * @return  the next pseudorandom, uniformly distributed <code>long</code>
     *          value from this random number generator's sequence.
     */
    public final long nextLong()
    {
        // It's OK that the bottom word remains signed.
        return ((long)(nextBits(32)) << 32) + nextBits(32);
    }

    /**
     * Returns the next pseudorandom, uniformly distributed 
     * <code>double</code> value between <code>0.0</code> and
     * <code>1.0</code> from this random number generator's sequence.
     *
     * @return  the next pseudorandom, uniformly distributed 
     *          <code>double</code> value between <code>0.0</code> and
     *          <code>1.0</code> from this random number generator's sequence.
     */
    public final double nextDouble()
    {
        long l = ((long)(nextBits(26)) << 27) + nextBits(27);
        return l / (double)(1L << 53);
    }

    /**
     * This template method is the core of the random number generator. 
     * Its function is to generate the next pseudo-random number of the
     * sequence and to return its low 'bits' bits, leaving all higher
     * bits zero.  'bits' must be in the range 1..32.
     *
     * @param   bits        the number of random bits, 1..32.
     * @return  the next pseudorandom value from this random number generator's sequence.
     */
    private int nextBits(int bits)
    {
        return core.nextBits(bits);
    }
}

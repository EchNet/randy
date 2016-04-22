//
// IRandomCore.java
//

package net.ech.randy;

/**
 * Generator of a pseudo-random sequence of integers, evenly distributed.  
 * This class is not intended for independent use, but rather to serve as
 * the core of a RandomNumberGenerator.
 *
 * @see net.ech.randy.RandomNumberGenerator
 */
public interface IRandomCore 
{
    /**
     * Set the seed of this random number generator, establishing a basis
     * for the sequence of values to be generated.  Note that if two
     * IRandomCore instance of the same type receive the same seed, they
     * will generate identical sequences.
     *
     * @param seed   the seed value
     */
    void setSeed(long seed);

    /**
     * Generate the next pseudo-random number of the sequence and to
     * return its low 'bits' bits, leaving all higher bits zero. 
     * 'bits' must be in the range 1..32.
     *
     * @param   bits        the number of random bits, 1..32.
     * @return  the next pseudorandom value from this random number generator's sequence.
     */
    int nextBits(int bits);
}

//
// DefaultRandomCore.java
//

package net.ech.randy;

/**
 * Implementation of IRandomCore based on the built-in java.util.Random
 * class.
 *
 * @see java.util.Random
 */
public class DefaultRandomCore
    extends java.util.Random
    implements IRandomCore
{
    /**
     * @inheritDoc
     */
    public int nextBits(int bits)
    {
        return next(bits);
    }
}     

//
// BrokenRandomCore.java
// 

package net.ech.xrandy;

import net.ech.randy.IRandomCore;

/**
 * A "broken" implementation of IRandomCore.  Returns a sequence of pure
 * zeros.  For testing.
 */
public class BrokenRandomCore implements IRandomCore
{
    /**
     * @inheritDoc
     */
    public void setSeed (long seed)
    {
    }

    /**
     * @inheritDoc
     */
    public int nextBits (int bits)
    {
        return 0;
    }
}

//
// SynchronizedRandomCore.java
//

package net.ech.randy;

/**
 * A proxy object that synchronizes access to an IRandomCore instance.
 * <p>
 * Implemented to demonstrate that I consider multi-threading issues.
 * Not actually used in the demo program!
 */
public class SynchronizedRandomCore 
    implements IRandomCore
{
    private IRandomCore core;

    /**
     * Constructor.  Create a synchronized (thread-safe) random number
     * generator backed by the specified random number generator.  To
     * guarantee serial access, it is critical that <strong>all</strong>
     * access to the backing RNG is accomplished through this RNG.
     *
     * @param core  the specified RNG
     */
    public SynchronizedRandomCore(IRandomCore core)
    {
        this.core = core;
    }

    /**
     * @inheritDoc
     */
    public synchronized void setSeed(long seed)
    {
        core.setSeed(seed);
    }

    /**
     * @inheritDoc
     */
    public synchronized int nextBits(int bits)
    {
        return core.nextBits(bits);
    }
}

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class Spite implements GefStrategie
{
    private boolean hasBetrayed;
    
    /**
     * @return the next decision this strategy makes
     */
    @Override
    public boolean getNextDecision()
    {
        return !this.hasBetrayed;
    }
    
    /**
     * @param decision last decision the opponent made
     */
    @Override
    public void setOpponentNextDecision(boolean decision)
    {
        if (!decision)
        {
            this.hasBetrayed = true;
        }
    }
}

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class TitForTat implements GefStrategie
{
    private boolean oponentDecision = true;
    
    /**
     * @return the next decision this strategy makes
     */
    @Override
    public boolean getNextDecision()
    {
        return this.oponentDecision;
    }
    
    /**
     * @param decision last decision the opponent made
     */
    @Override
    public void setOpponentNextDecision(boolean decision)
    {
        this.oponentDecision = decision;
    }
}

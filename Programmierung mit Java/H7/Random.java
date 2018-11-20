/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class Random implements GefStrategie
{
    /**
     * @return the next decision this strategy makes
     */
    @Override
    public boolean getNextDecision()
    {
        return Math.random() < 0.5;
    }
    
    /**
     * @param decision last decision the opponent made
     */
    @Override
    public void setOpponentNextDecision(boolean decision)
    {
    
    }
}

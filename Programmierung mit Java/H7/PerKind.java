/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class PerKind implements GefStrategie
{
    private int cooperate = 0;
    
    /**
     * @return the next decision this strategy makes
     */
    @Override
    public boolean getNextDecision()
    {
        cooperate++;
        return cooperate % 3 != 0;
    }
    
    /**
     * @param decision last decision the opponent made
     */
    @Override
    public void setOpponentNextDecision(boolean decision)
    {
    
    }
}

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public interface GefStrategie
{
    /**
     * @return the next decision this strategy makes
     */
    boolean getNextDecision();
    
    /**
     * @param decision last decision the opponent made
     */
    void setOpponentNextDecision(boolean decision);
}

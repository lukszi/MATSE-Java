/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public interface GefStrategie
{
    /**
    * implements a certain decision for the player
    * @param decision
    * set next decision
    */
    boolean getNextDecision();

    void setOpponentNextDecision(boolean decision);
}

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public interface GefStrategie
{
    /**
    * implements a certain decision for the player
    * @param boolean is used 
    * @return next decision of the player
    */
    boolean getNextDecision();

    void setOpponentNextDecision(boolean decision);
}

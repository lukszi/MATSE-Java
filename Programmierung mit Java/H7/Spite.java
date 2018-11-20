/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class Spite implements GefStrategie
{
    private boolean hasBetrayed;
    /**
    * @param decision from GefStrategie
    * @return boolean if player has betrayed
    */
    @Override
    public boolean getNextDecision()
    {
        return !this.hasBetrayed;
    }
    /**
    * @param decision of player
    */
    @Override
    public void setOpponentNextDecision(boolean decision)
    {
        if(!decision){
            this.hasBetrayed = true;
        }
    }
}

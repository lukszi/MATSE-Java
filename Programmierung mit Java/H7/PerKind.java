/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class PerKind implements GefStrategie
{
    private int cooperate = 0;
    /**
    * @param decision from GefStrategie
    * @return if there will be a cooperation of the player
    */
    @Override
    public boolean getNextDecision()
    {
        cooperate ++;
        return cooperate%3!=0;
    }
    /**
    *@param set next decision
    */
    @Override
    public void setOpponentNextDecision(boolean decision)
    {

    }
}

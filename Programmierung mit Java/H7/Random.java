/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class Random implements GefStrategie
{
    /**
    * @param decision from GefStrategie
    * @return random number of 0 or 1
    */
    @Override
    public boolean getNextDecision()
    {
        return Math.random()<0.5;
    }
    /**
    * @param decision
    * set next decision
    */
    @Override
    public void setOpponentNextDecision(boolean decision)
    {

    }
}

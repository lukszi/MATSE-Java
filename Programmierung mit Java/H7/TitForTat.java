/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class TitForTat implements GefStrategie
{
    private boolean oponentDecision = true;
    /**
    * @param decision from GefStragie
    * @return nexDecision
    */
    @Override
    public boolean getNextDecision()
    {
        return this.oponentDecision;
    }
    /**
    * @param decision
    */
    @Override
    public void setOpponentNextDecision(boolean decision)
    {
        this.oponentDecision = decision;
    }
}

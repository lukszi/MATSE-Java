/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class Pavlov implements GefStrategie
{
    private boolean opponenLastMove = true;
    private boolean lastMove = true;
    /** 
    * overrides interface GefStrategie
    * @return boolean of last move
    */
    @Override
    public boolean getNextDecision()
    {
        this.lastMove = this.lastMove == this.opponenLastMove;
        return this.lastMove;
    }
    /**
    * @param last decision
    * set next decision
    */
    @Override
    public void setOpponentNextDecision(boolean decision)
    {
        this.opponenLastMove = decision;
    }
}

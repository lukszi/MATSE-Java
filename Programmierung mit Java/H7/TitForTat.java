public class TitForTat implements GefStrategie
{
    private boolean oponentDecision = true;
    @Override
    public boolean getNextDecision()
    {
        return this.oponentDecision;
    }

    @Override
    public void setOpponentNextDecision(boolean decision)
    {
        this.oponentDecision = decision;
    }
}

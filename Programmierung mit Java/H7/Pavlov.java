public class Pavlov implements GefStrategie
{
    private boolean opponenLastMove = true;
    private boolean lastMove = true;

    @Override
    public boolean getNextDecision()
    {
        this.lastMove = this.lastMove == this.opponenLastMove;
        return this.lastMove;
    }

    @Override
    public void setOpponentNextDecision(boolean decision)
    {
        this.opponenLastMove = decision;
    }
}

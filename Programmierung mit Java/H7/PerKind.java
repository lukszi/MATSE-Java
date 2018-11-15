public class PerKind implements GefStrategie
{
    int cooperate = 0;

    @Override
    public boolean getNextDecision()
    {
        cooperate ++;
        return cooperate%3!=0;
    }

    @Override
    public void setOpponentNextDecision(boolean decision)
    {

    }
}

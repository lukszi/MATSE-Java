public class Random implements GefStrategie
{
    @Override
    public boolean getNextDecision()
    {
        return Math.random()<0.5;
    }

    @Override
    public void setOpponentNextDecision(boolean decision)
    {

    }
}

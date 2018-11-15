public class Spite implements GefStrategie
{
    private boolean hasBetrayed;

    @Override
    public boolean getNextDecision()
    {
        return !this.hasBetrayed;
    }

    @Override
    public void setOpponentNextDecision(boolean decision)
    {
        if(!decision){
            this.hasBetrayed = true;
        }
    }
}

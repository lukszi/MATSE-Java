import java.util.ArrayList;

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class Knight extends Chessman
{
    /**
     * Creates a new Knight at a given position
     * @param p position to put the chessman at
     */
    public Knight(Position p)
    {
        super(p);
    }

    @Override
    public ArrayList<Position> getMoveList()
    {
        ArrayList<Position> ret = new ArrayList<>();
        ArrayList<Position> deltas = new ArrayList<>();
        deltas.add(new Position(2,1));
        deltas.add(new Position(2,-1));
        deltas.add(new Position(-2,1));
        deltas.add(new Position(-2,-1));
        deltas.add(new Position(1,2));
        deltas.add(new Position(1,-2));
        deltas.add(new Position(-1,2));
        deltas.add(new Position(-1,-2));

        for(Position delta: deltas){
            Position currentPos = this.getPosition();
            Position pos = new Position(currentPos.getX()+delta.getX(), currentPos.getY()+delta.getY());
            if(pos.isValid())
                ret.add(pos);
        }

        return ret;
    }

    @Override
    public String toString()
    {
        return "Springer: " + getPosition().toString();
    }
}

import java.util.ArrayList;

public class Rook extends Chessman
{
    public Rook(Position p)
    {
        super(p);
    }

    @Override
    public ArrayList<Position> getMoveList()
    {
        ArrayList<Position> ret = new ArrayList<>();
        ArrayList<Position> moveDirections = new ArrayList<>();

        moveDirections.add(new Position(0,1));
        moveDirections.add(new Position(0,-1));
        moveDirections.add(new Position(1,0));
        moveDirections.add(new Position(-1,0));

        for(Position moveDirection : moveDirections){
            Position pos = this.getPosition();
            while(true){
                pos = new Position(pos.getX()+moveDirection.getX(), pos.getY()+moveDirection.getY());
                if(pos.isValid()) {
                    ret.add(pos);
                    continue;
                }
                break;
            }
        }
        return ret;
    }

    @Override
    public String toString()
    {
        return "Turm: " + getPosition().toString();
    }
}

import java.util.ArrayList;

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public abstract class Chessman
{
    private Position position;

    /**
     * Creates a new Chessman at a given position
     * @param p position of the new chessman
     */
    public Chessman(Position p){
        if(!p.isValid()){
            throw new RuntimeException("Feld existiert nicht");
        }
        this.position = p;
    }

    /**
     *
     * @return the position of the chessman
     */
    public Position getPosition(){
        return this.position;
    }

    /**
     * Move chessman to a given position
     * @param p position to move the chessman to
     */
    public void moveTo(Position p){
        if(!this.canMoveTo(p))
            throw new RuntimeException("Ungültiger Zug");
        this.position = p;
    }

    /**
     *
     * @return list of currently possible moves for this chessman
     */
    public abstract ArrayList<Position> getMoveList();

    /**
     * Checks if this chessman can move to a given position
     * @param pos position to be checked
     * @return true if chessman can be moved to pos, false if not
     */
    public boolean canMoveTo(Position pos){
            return this.getMoveList().contains(pos);
    }
}
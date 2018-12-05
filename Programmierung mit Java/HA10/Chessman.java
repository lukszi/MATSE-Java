import java.util.ArrayList;

public abstract class Chessman
{
    private Position position;


    public Chessman(Position p){
        if(!p.isValid()){
            throw new RuntimeException("Feld existiert nicht");
        }
        this.position = p;
    }

    public Position getPosition(){
        return this.position;
    }

    public void moveTo(Position p){
        if(!getMoveList().contains(p))
            throw new RuntimeException("Ungültiger Zug");
        this.position = p;
    }

    public abstract ArrayList<Position> getMoveList();

    public boolean canMoveTo(Position pos){
            return this.getMoveList().contains(pos);
    }
}
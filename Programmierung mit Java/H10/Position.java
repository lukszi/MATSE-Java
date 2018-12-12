/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class Position
{
    private int x;
    private int y;

    /**
     * Creates a new Position at given coordinates
     * @param x coordinate of the new position
     * @param y coordinate of the new position
     */
    public Position(int x, int y){
        this.y = y;
        this.x = x;
    }

    /**
     *
     * @return x coordinate of the position
     */
    public int getX(){
        return this.x;
    }

    /**
     *
     * @return y coordinate of the position
     */
    public int getY(){
        return this.y;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof  Position){
            return this.equals((Position)obj);
        }
        return super.equals(obj);
    }

    /**
     * Checks if another position is equal to this
     * @param p the position to be checked
     * @return true if both positions are equal, false otherwise
     */
    public boolean equals(Position p){
        return (this.y == p.y)&&(this.x == p.x);
    }

    /**
     *
     * @return true if the position is in a chessboard, false otherwise
     */
    public boolean isValid(){
        return (y>0&&x>0)&&(y<9&&x<9);
    }

    @Override
    public String toString(){
        return String.format("(%d,%d)",x,y);
    }
}

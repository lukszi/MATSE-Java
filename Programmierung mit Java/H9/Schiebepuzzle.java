/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class Schiebepuzzle
{
    enum direction
    {
        DOWN,
        UP,
        RIGHT,
        LEFT,
        NONE,
    }

    private int[][] plaettchen = new int[4][4];

    public Schiebepuzzle()
    {
        for (int i = 0; i < this.plaettchen.length; i++) {
            for (int j = 0; j < this.plaettchen[i].length; j++) {
                plaettchen[i][j] = i * this.plaettchen[i].length + j + 1;
            }
        }
        plaettchen[this.plaettchen.length-1][this.plaettchen.length-1] = -1;
    }

    @Override
    public String toString()
    {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < this.plaettchen.length; i++) {
            ret.append("|");

            for (int j = 0; j < this.plaettchen[i].length; j++) {
                if (this.plaettchen[i][j] == -1)
                    ret.append("  ");
                else
                    ret.append(String.format("%2d", this.plaettchen[i][j]));
                ret.append('|');
            }

            // Don't apply footer on the last line
            if (!(i == this.plaettchen.length - 1)) {
                ret.append("\n-------------\n");
            }
        }
        return ret.toString();
    }

    /**
     * Finds the empty spot
     *
     * @return an array of the indices of the empty spot
     */
    public int[] findEmptySpot()
    {
        return findTile(-1);
    }

    /**
     * Finds a tile
     * @param tileNumber number of the tile
     * @return position of the tile
     */
    public int[] findTile(int tileNumber)
    {
        for (int i = 0; i < this.plaettchen.length; i++) {
            for (int j = 0; j < this.plaettchen[i].length; j++) {
                if (plaettchen[i][j] == tileNumber) {
                    return new int[]{i, j};
                }
            }
        }
        throw new WrongNumberException();
    }

    /**
     * Checks if a tile can be moved into the empty tile
     * @param i tile number
     * @return true if tile can be moved into the empty tile
     */
    public boolean istVerschiebbar(int i){
        return this.canMoveToEmptySpot(this.findTile(i)) != direction.NONE;
    }

    /**
     * Checks if the tile at the passed spot can be moved into the empty spot
     * @param pos Array of two 0-based integers determining the position
     * @return the direction in which the tile has to be moved, or None if it can't be moved
     */
    public direction canMoveToEmptySpot(int[] pos)
    {
        int i = pos[0];
        int j = pos[1];

        if (!(i == 0)) {
            if (this.plaettchen[i - 1][j] == -1)
                return direction.LEFT;
        }
        if (!(i == 3)) {
            if (this.plaettchen[i + 1][j] == -1)
                return direction.RIGHT;
        }
        if (!(j == 0)) {
            if (this.plaettchen[i][j - 1] == -1)
                return direction.DOWN;
        }
        if (!(j == 3)) {
            if (this.plaettchen[i][j + 1] == -1)
                return direction.UP;
        }

        // Can't be moved
        return direction.NONE;
    }

    /**
     * Sets a value on a certain position
     * @param pos position where the value should be put
     * @param val value to be set
     */
    private void set(int[] pos, int val){
        this.plaettchen[pos[0]][pos[1]] = val;
    }

    /**
     * Moves a tile to the empty spot
     * @param i number of the tile
     */
    public void schiebe(int i){
        int[] tilePos = findTile(i);
        int[] emptyPos = findTile(-1);

        direction move = canMoveToEmptySpot(tilePos);
        if(move == direction.NONE)
            throw new WrongMoveException();

        set(emptyPos, i);
        set(tilePos, -1);
    }

    /**
     * Performs 100 random moves
     */
    public void mische(){
        for(int i = 0; i < 100; i++){
            int tile = getRandomMove();
            schiebe(tile);
        }
    }

    /**
     *
     * @return a random valid tile that can be moved
     */
    public int getRandomMove(){
        int[] emptySpot = findEmptySpot();
        while(true){
            int decision = (int)(Math.random()*4);
            switch (decision){
                case 0:
                    if(emptySpot[0]!=0)
                        return this.plaettchen[emptySpot[0]-1][emptySpot[1]];
                case 1:
                    if(emptySpot[0]!=3)
                        return this.plaettchen[emptySpot[0]+1][emptySpot[1]];
                case 2:
                    if(emptySpot[1]!=0)
                        return this.plaettchen[emptySpot[0]][emptySpot[1]-1];
                case 3:
                    if(emptySpot[1]!=3)
                        return this.plaettchen[emptySpot[0]][emptySpot[1]+1];
            }
        }
    }
}

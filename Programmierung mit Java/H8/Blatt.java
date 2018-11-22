import java.util.Arrays;

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class Blatt
{
    private int blatt[] = new int[3];

    /**
     * Creates a new Blatt object containing the values passed in blatt
     * @param blatt 3 card values from 2 to 14
     */
    public Blatt(int blatt[]){
        // Check the card values
        if(blatt.length !=3){
            throw new IllegalArgumentException("Blatt muss genau drei Werte haben");
        }
        Arrays.stream(blatt).forEach(karte -> {
            if(!(karte<=14&&karte>=2)){
                throw new IllegalArgumentException("Ungültiger Kartenwert");
            }
        });

        // Copy the card values
        System.arraycopy(blatt, 0, this.blatt, 0, 3);
    }

    /**
     *
     * @return Copy of the card array
     */
    public int[] getBlatt()
    {
        int[] bl = new int[3];
        System.arraycopy(blatt, 0, bl, 0, 3);
        return bl;
    }

    /**
     *
     * @return A comma separated list of card values
     */
    @Override
    public String toString()
    {
        // Not gonna write a for loop for 3 elements
        return blatt[0] + ", " + blatt[1] + ", " + blatt[2];
    }
}

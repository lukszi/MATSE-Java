import java.util.ArrayList;
import java.util.Arrays;

public class Blatt
{
    private int blatt[] = new int[3];
    public Blatt(int blatt[]){
        // Make sure values are correct
        if(blatt.length !=3){
            throw new IllegalArgumentException("Blatt muss genau drei Werte haben");
        }
        Arrays.stream(blatt).forEach(karte -> {
            if(!(karte<=14&&karte>=2)){
                throw new IllegalArgumentException("Ungültiger Kartenwert");
            }
        });
        // Copy values
        System.arraycopy(blatt, 0, this.blatt, 0, 3);
    }

    /**
     *
     * @return Kopie des Kartenfeldes
     */
    public int[] getBlatt()
    {
        int[] bl = new int[3];
        System.arraycopy(blatt, 0, bl, 0, 3);
        return bl;
    }

    /**
     *
     * @return Eine kommageteilte Liste der Kartenwerte
     */
    @Override
    public String toString()
    {
        return blatt[0] + ", " + blatt[1] + ", " + blatt[2];
        // Not gonna write a for loop for 3 elements
    }
}

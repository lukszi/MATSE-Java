import java.util.Comparator;

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class BlattVergleich_bak implements Comparator<Blatt>
{
    int b1Bigger = 1;
    int b2Bigger = -1;
    int equals = 0;
    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     */
    public int compare(Blatt o1, Blatt o2)
    {
        // Create array so I don't have to create the code for the metrics twice
        Blatt[] blaetter = new Blatt[2];
        blaetter[0] = o1;
        blaetter[1] = o2;

        // Metrics to judge the cards by
        int multi[] = new int[2];
        int sum[] = new int[2];

        for(int i = 0; i<blaetter.length; i++){
            Blatt blatt = blaetter[i];
            for(int kartenWertOutter : blatt.getBlatt()){
                // Create card sum
                sum[i] += kartenWertOutter;
                for(int kartenWertInner : blatt.getBlatt()){
                    if(kartenWertInner == kartenWertOutter)
                        // Count multiples
                        multi[i]++;
                }
            }
            // Got n too much multis because I compared each value against itself
            multi[i] -= blatt.getBlatt().length;
        }

        // does someone have triples or doubles?
        if((multi[0]>=2|| multi[1]>=2)){
            // Does one have a higher multiple card count than the other?
            if((multi[0] != multi[1])){
                return Integer.compare(multi[0], multi[1]);
            }
            else{
                // Sorry for this
                // If sums are equal compare the last cards
                return sum[0] == sum[1] ?
                        Integer.compare(blaetter[0].getBlatt()[2],blaetter[1].getBlatt()[2]) :
                        Integer.compare(sum[0], sum[1]);
            }
        }
        // No mults, return a comparison between the sums
        return Integer.compare(sum[0], sum[1]);
    }
}

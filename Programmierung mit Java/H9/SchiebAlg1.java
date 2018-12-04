import java.util.Arrays;

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class SchiebAlg1 implements Loesungsalgorithmus
{
    /**
     * Löst puzzle nur bis 1 oben links stehtn
     * @param puzzle puzzle das gelöst werden soll
     */
    @Override
    public void loese(Schiebepuzzle puzzle)
    {
        while (!Arrays.equals(puzzle.findTile(1), (new int[]{0, 0}))) {
            puzzle.schiebe(puzzle.getRandomMove());
        }
    }
}

import java.util.Arrays;

public class SchiebAlg1 implements Loesungsalgorithmus
{
    @Override
    public void loese(Schiebepuzzle puzzle)
    {
        while (!Arrays.equals(puzzle.findTile(1), (new int[]{0, 0}))) {
            puzzle.schiebe(puzzle.getRandomMove());
        }
    }
}

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class Quadrat implements Rechenoperation
{
    /**
     * @param x value to be squared
     * @return the square of x
     */
    @Override
    public double berechnung(double x)
    {
        return Math.pow(x,2);
    }
}

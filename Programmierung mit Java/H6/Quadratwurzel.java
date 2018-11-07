/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class Quadratwurzel implements Rechenoperation
{
    /**
     *
     * @param x value of which the root will be calculated
     * @return square root of x
     */
    @Override
    public double berechnung(double x)
    {
        if(x<0){
            throw new ArithmeticException();
        }
        return Math.sqrt(x);
    }
}

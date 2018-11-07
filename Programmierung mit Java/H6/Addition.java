/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class Addition implements Rechenoperation
{
    private double val;

    /**
     * @param val each calculation will be relative to this value
     */
    public Addition(double val){
        this.val = val;
    }

    /**
     * Adds x to the value of this object
     * @param x the second addend
     * @return x + the value of this object
     */
    @Override
    public double berechnung(double x)
    {
        return x + this.val;
    }
}

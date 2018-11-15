import java.util.function.Function;

public class Funktion
{
    private Function<Double, Double> func;

    public double getY(double x)
    {
        return func.apply(x);
    }

    public Funktion(Function<Double, Double> func)
    {
        this.func = func;
    }

    @Override
    public String toString()
    {
        return func.getClass().getDeclaredMethods()[0].toString();
        // return func.toString();
    }
}

import java.util.function.Function;

public class Funktion_Aufgabe7
{
    private Function<Double, Double> func;

    public double getY(double x)
    {
        return func.apply(x);
    }

    public Funktion_Aufgabe7(Function<Double, Double> func)
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

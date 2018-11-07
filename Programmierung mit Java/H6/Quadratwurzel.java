public class Quadratwurzel implements Rechenoperation
{
    @Override
    public double berechnung(double x)
    {
        if(x<0){
            throw new ArithmeticException();
        }
        return Math.sqrt(x);
    }
}

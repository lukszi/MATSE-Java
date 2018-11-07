public class Addition implements Rechenoperation
{
    private double val;
    public Addition(double val){
        this.val = val;
    }

    @Override
    public double berechnung(double x)
    {
        return x + this.val;
    }
}

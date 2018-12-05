public class AXhochN implements Funktion
{
    private double a;
    private double n;
    private AXhochN(double a, double n){
        this.a = a;
        this.n = n;
    }


    @Override
    public double getY(double d)
    {
        return this.a*Math.pow(d,this.n);
    }

    @Override
    public Funktion getAbleitung()
    {
        Funktion ret;
        double aMod = this.a*this.n;
        double nMod = this.n-1;
        return get(aMod, nMod);
    }

    public static Funktion get(double a, double n){
        Funktion ret;
        if(a == 0){
            ret = Null.get();
        }
        else
        {
            ret = new AXhochN(a, n);
        }
        return ret;
    }

    @Override
    public String toString(){
        if(this.n == 0)
        {
            return String.format("%.1f", this.a);
        }
        return String.format("%.1fx^%.1f", this.a, this.n);
    }
}

public class Null implements Funktion
{
    private static Null o;

    private Null(){}

    @Override
    public double getY(double d)
    {
        return 0;
    }

    @Override
    public Funktion getAbleitung()
    {
        return this;
    }

    @Override
    public String toString()
    {
        return "0";
    }

    public static Null get(){
        if(o==null)
            o = new Null();
        return o;
    }
}

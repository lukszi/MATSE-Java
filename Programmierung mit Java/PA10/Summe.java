public class Summe implements Funktion
{
    private Funktion a;
    private Funktion b;
    private Summe(Funktion a, Funktion b){
        this.a = a;
        this.b = b;
    }

    @Override
    public double getY(double d)
    {
        return a.getY(d) + b.getY(d);
    }

    @Override
    public Funktion getAbleitung()
    {
        return get(a.getAbleitung(), b.getAbleitung());
    }

    public Funktion get(Funktion a, Funktion b){
        if(a.getClass().equals(Null.class)){
            if(b.getClass().equals(Null.class))
                return new Null();
            return b;
        }
        else if(b.getClass().equals(Null.class)){
            if(a.getClass().equals(Null.class))
                return new Null();
            return a;
        }
        else{
            return new Summe(a ,b);
        }
    }

    @Override
    public String toString()
    {
        return this.a.toString() + "+" + this.b.toString();
    }
}

public class GoldTagesPreis
{
    public String datum;
    public double preis;

    public GoldTagesPreis(String datum, double preis)
    {
        this.datum = datum;
        this.preis = preis;
    }

    @Override
    public String toString()
    {
        return "GoldTagesPreis{" +
                "datum='" + datum + '\'' +
                ", preis=" + preis +
                '}';
    }
}

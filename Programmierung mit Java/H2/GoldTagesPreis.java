/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class GoldTagesPreis
{
    public String datum;
    public double preis;

    public GoldTagesPreis(String datum, double preis)
    {
        this.datum = datum;
        this.preis = preis;
    }

    public GoldTagesPreis(String datum, String preis){
        this.datum = datum;
        this.preis = parsePriceToDouble(preis);
    }

    /**
     * Formats a Double price in the file into price string as found in the input file
     * @param price price to be formatted into the file Output
     * @return a formatted String containing the price
     */
    public String parsePriceToString(double price)
    {
        if(price == -1)
            return "-1,0";
        String preis = String.valueOf(price);
        preis = preis.replace(".", ",");
        preis = preis.substring(0,2) + "." + preis.substring(2);
        return preis;
    }

    /**
     * Parses a price string as found in the file into a double
     * @param price the price string to be parsed
     * @return Double containing the price
     */
    public double parsePriceToDouble(String price)
    {
        price = price.replace(".","");
        price = price.replace(",",".");
        return Double.parseDouble(price);
    }

    @Override
    public String toString()
    {
        return this.datum + "\t" + parsePriceToString(this.preis);
    }
}

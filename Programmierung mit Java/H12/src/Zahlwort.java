import java.util.stream.Stream;

public class Zahlwort
{
    /**
     * Gibt das Wort für die Zehnerstellen zurück.
     *
     * @param x die umzuwandelnde Zahl
     * @return Text für die Zahl
     */
    public static String zahlWort10(int x)
    {
        int y = x / 10; /* nur Zehnerstelle */
        switch (y)
        {
            case 1:
                return "zehn";
            case 2:
                return "zwanzig";
            case 3:
                return "dreissig";
            case 4:
                return "vierzig";
            case 5:
                return "fuenfzig";
            case 6:
                return "sechzig";
            case 7:
                return "siebzig";
            case 8:
                return "achtzig";
            case 9:
                return "neunzig";
            default:
                return "FUBAR";
        }
    }

    /**
     * Gibt den Betrag in Worten für 1 bis 99 zurück.
     *
     * @param x      die umzuwandelnde Zahl
     * @param digits Anzahl der Stellen hinter der Zahl
     * @return Text für die Zahl
     */
    public static String zahlWort100(int x, int digits)
    {
        int y = x % 100; // Betrachte nur einer und zehnerstelle
        // 1 Sonderbehandeln
        if (y == 1)
        {
            switch (digits)
            {
                case 0:
                    return "eins";
                case 1:
                case 2:
                case 3:
                    return "ein";
                case 6:
                case 9:
                case 12:
                case 15:
                    // Numerus
                    if (x == 1)
                    {
                        return "eine";
                    } else
                    {
                        return "ein";
                    }
                default:
                    // Alles kapott
                    return "FUBAR";
            }
        }
        // 2 bis 19
        if ((y >= 2) && (y <= 19))
        {
            switch (y)
            {
                case 2:
                    return "zwei";
                case 3:
                    return "drei";
                case 4:
                    return "vier";
                case 5:
                    return "fuenf";
                case 6:
                    return "sechs";
                case 7:
                    return "sieben";
                case 8:
                    return "acht";
                case 9:
                    return "neun";
                case 10:
                    return "zehn";
                case 11:
                    return "elf";
                case 12:
                    return "zwoelf";
                case 13:
                    return "dreizehn";
                case 14:
                    return "vierzehn";
                case 15:
                    return "fuenfzehn";
                case 16:
                    return "sechzehn";
                case 17:
                    return "siebzehn";
                case 18:
                    return "achtzehn";
                case 19:
                    return "neunzehn";
                default:
                    return "FUBAR";
            }
        }
        // 20 bis 99
        if ((y >= 20) && (y <= 99))
        {
            if (y % 10 == 0)
            {
                return zahlWort10(y);
            } else
            {
                return zahlWort100(y % 10, 1) + "und" + zahlWort10(y);
            }
        }
        return "";
    }

    /**
     * Gibt den Betrag in Worten für 1 bis 999 zurück.
     *
     * @param x      die umzuwandelnde Zahl
     * @param digits Anzahl der Stellen hinter der Zahl
     * @return Text für die Zahl
     */
    public static String zahlWort1000(int x, int digits)
    {
        if (x / 100 == 0)
        {
            return zahlWort100(x, digits);
        } else
        {
            return zahlWort100(x / 100, 2) + "hundert" + zahlWort100(x, digits);
        }
    }

    /**
     * Bezeichnung der Werte über einer Miilion
     *
     * @param digits Anzahl der Stellen
     * @param istMehrzahl     der Numerus
     * @return Zahlen-Suffix
     */
    public static String zahlWortDigits(int digits, boolean istMehrzahl)
    {
        // Numerus prüfen
        if (istMehrzahl)
        {
            switch (digits)
            {
                case 0:
                    return "";
                case 3:
                    return "tausend";
                case 6:
                    return " Millionen ";
                case 9:
                    return " Milliarden ";
                case 12:
                    return " Billionen ";
                case 15:
                    return " Billiarden ";
                default:
                    return "";
            }
        } else
        {
            switch (digits)
            {
                case 0:
                    return "";
                case 3:
                    return "tausend";
                case 6:
                    return " Million ";
                case 9:
                    return " Milliarde ";
                case 12:
                    return " Billion ";
                case 15:
                    return " Billiarde ";
                default:
                    return "";
            }
        }
    }

    /**
     * Betrag in Worten einer ganzen, positiven Zahl
     *
     * @param x umzuwandelnde Zahl
     * @return Zahl in Worten
     */
    public static String getZahlwort(int x)
    {
        // Sonderfall 0
        if (x == 0)
        {
            return "null";
        }
        // Falsche Werte abfangen
        if(x>9999||x<0){
            throw new ArithmeticException();
        }
        int digits = 0;
        StringBuilder result = new StringBuilder();
        while (x > 0)
        {
            result.insert(0, (x % 1000 > 0 ? (zahlWort1000(x % 1000, digits) + zahlWortDigits(digits, x % 1000 > 1)) : ""));
            x /= 1000;
            digits += 3;
        }
        return result.toString();
    }

    /**
     *
     * @param start Starte den Stream von hier
     * @param stop Lasse Stream bis hier laufen
     * @return Stream der Zahlworte von start bis stop
     */
    public static Stream<String> getZahlStream(int start, int stop){
        Stream<Integer> st = Stream.iterate(start,t -> t+1).limit(stop-start+1);
        return st.map(Zahlwort::getZahlwort);
    }
}
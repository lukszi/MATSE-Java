public class Zahlwort
{
    public static String getZahlwort(int x)
    {
        StringBuilder sb = new StringBuilder();
        char[] zahl = String.valueOf(x).toCharArray();
        String[] zahlStrings = new String[zahl.length];
        for (int i = 0; i < zahl.length; ++i) {
            String zahlStringValue;
            // Zahl in String umwandeln
            switch (Character.getNumericValue(zahl[i])) {
                case 0:
                    zahlStringValue = "null";
                    break;
                case 1:
                    if(zahl.length == 1)
                        zahlStringValue = "eins";
                    else
                        zahlStringValue = "ein";
                    break;
                case 2:
                    zahlStringValue = "zwei";
                    break;
                case 3:
                    zahlStringValue = "drei";
                    break;
                case 4:
                    zahlStringValue = "vier";
                    break;
                case 5:
                    zahlStringValue = "fünf";
                    break;
                case 6:
                    zahlStringValue = "sechs";
                    break;
                case 7:
                    zahlStringValue = "sieben";
                    break;
                case 8:
                    zahlStringValue = "acht";
                    break;
                case 9:
                    zahlStringValue = "neun";
                    break;
                default:
                    throw new ArithmeticException(zahl[i] + " an Stelle " + i + " ist keine Zahl");
            }
            zahlStrings[i] = zahlStringValue;
        }
        return sb.toString();
    }
}

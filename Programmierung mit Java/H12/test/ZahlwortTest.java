import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lukas Szimtenings on 24.12.2018.
 */
public class ZahlwortTest
{
    
    @Test
    public void zahlStreamTest()
    {
        String[] arr = Zahlwort.getZahlStream(8,12).toArray(String[]::new);
        String[] actuals = {"acht", "neun", "zehn", "elf", "zwoelf"};
        assertArrayEquals(arr, actuals);
    }
    
    @Test
    public void zahlwortTest()
    {
        int[] testtabelle = { 1, 10, 11, 12, 16, 17, 20, 38, 69, 70, 131, 195, 2345 };
        String[] sTesttabelle = {"eins","zehn","elf","zwoelf","sechzehn","siebzehn","zwanzig", "achtunddreissig",
                "neunundsechzig", "siebzig", "einhunderteinunddreissig","einhundertfuenfundneunzig","zweitausenddreihundertfuenfundvierzig"};
        for(int i = 0; i < testtabelle.length; i++){
            assertEquals(Zahlwort.getZahlwort(testtabelle[i]),sTesttabelle[i]);
        }
    }
    
    @Test(expected = ArithmeticException.class)
    public void zahlWortArithmeticTest(){
        for(int i = 0; i<=10000; i++){
            Zahlwort.getZahlwort(i);
        }
    }
}
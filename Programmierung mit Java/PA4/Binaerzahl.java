public class Binaerzahl
{
    private static final int MAX_DIGITS = 32;
    private StringBuilder binaerZahl;

    public Binaerzahl(int zahl)
    {
        binaerZahl = decimalToBinary(Math.abs(zahl));
        if(zahl<0)
            zweierkomplement();
    }

    private void zweierkomplement()
    {
        char zahl[] = binaerZahl.toString().toCharArray();
        for (int i = 0; i < MAX_DIGITS; i++) {
            char x = zahl[i];
            if (x == '0')
                zahl[i] = '1';
            if (x == '1')
                zahl[i] = '0';
        }
        String sZahl = new String(zahl);
        this.binaerZahl = null;
        this.binaerZahl = new StringBuilder(sZahl);
        this.add(new Binaerzahl(1));
    }

    private StringBuilder decimalToBinary(int zahl)
    {
        StringBuilder sb = new StringBuilder();

        // Convert from decimal to binary
        while (zahl != 0) {
            sb.append(zahl % 2);
            zahl = zahl / 2;
        }
        // Reverse because the algorithm works the wrong way around
        sb.reverse();
        sb = addLeadingZeroes(sb);
        return sb;
    }

    private StringBuilder addLeadingZeroes(StringBuilder binaerZahl)
    {
        binaerZahl = new StringBuilder(binaerZahl);
        // reverse so we can just append
        binaerZahl.reverse();
        for (int i = binaerZahl.length(); i < 32; i++) {
            binaerZahl.append("0");
        }
        // reverse so the number makes sense again
        binaerZahl.reverse();
        return binaerZahl;
    }

    private StringBuilder removeLeadingZeroes(StringBuilder binaerZahl)
    {
        // make sure the number isn't 0
        if (!binaerZahl.toString().contains("1"))
            return new StringBuilder("0");
        return new StringBuilder(binaerZahl.substring(binaerZahl.indexOf("1")));
    }

    public void add(Binaerzahl zahl2)
    {
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        // loop over every bit
        for (int i = MAX_DIGITS - 1; i >= 0; i--) {
            // get numerical value
            int i1 = this.binaerZahl.charAt(i) - 48;
            int i2 = zahl2.binaerZahl.charAt(i) - 48;

            // perform addition
            int result = i1 + i2 + carry;
            carry = 0;
            if (result > 1) {
                carry = 1;
                result %= 2;
            }
            sum.append(result);
        }
        // reverse so HSB is at index 0
        sum.reverse();
        this.binaerZahl = sum;
    }

    @Override
    public String toString()
    {
        StringBuilder ret = new StringBuilder();
        // Check if number is negative
        if (this.binaerZahl.charAt(0) == '1') {
            ret.append('-');
            zweierkomplement();
            ret.append(removeLeadingZeroes(this.binaerZahl).toString());
            zweierkomplement();
        }
        else{
            ret.append(removeLeadingZeroes(this.binaerZahl).toString());
        }
        return ret.toString();
    }
}

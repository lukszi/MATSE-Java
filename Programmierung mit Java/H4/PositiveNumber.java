import java.util.HashMap;

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class PositiveNumber
{
    // Mapping from numbers in the decimal system to their corresponding character representation in the fitting system
    private BidirectionalMap<Integer, Character> decToNumMap;
    private final int MAX_BASE = 16;

    private int value = 0;

    /**
     * Creates a new positive number and initializes the DecimalToNumberMap
     */
    public PositiveNumber()
    {
        createDecToNumMap(this.MAX_BASE);
    }

    /**
     * Sets a decimal value
     * @param decimal Decimal number to be set
     */
    public void setDecimal(String decimal){
        this.value = Integer.valueOf(decimal);
    }

    /**
     * Sets a hexadecimal value
     * @param hexadecimal Hexadecimal number to be set
     */
    public void setHexadecimal(String hexadecimal){
        this.value = baseToDecimal(hexadecimal, 16);
    }

    /**
     * Sets a binary value
     * @param binary Binary number to be set
     */
    public void setBinary(String binary){
        this.value = baseToDecimal(binary, 2);
    }

    /**
     * Fetches the decimal value of this object
     * @return The decimal value of this object
     */
    public String getDecimal(){
        return String.valueOf(this.value);
    }

    /**
     * Fetches the hexadecimal value of this object
     * @return The hexadecimal value of this object
     */
    public String getHexadecimal(){
        return String.valueOf(decimalToBase(this.value, 16));
    }

    /**
     * Fetches the binary value of this object
     * @return The binary value of this object
     */
    public String getBinary(){
        return String.valueOf(decimalToBase(this.value, 2));
    }

    //################################
    // Utility conversion methods    #
    //################################

    // Number conversion helper methods

    /**
     * Converts a number with a given base to a decimal number
     * The function uses a basic implementation of the Horner scheme
     * @param number number to be converted
     * @param base base of the number being converted
     * @return the decimal equivalent to the given number
     */
    private int baseToDecimal(String number, int base){
        if(base>this.MAX_BASE ||base < 2){
            throw new IllegalArgumentException();
        }
        int decimal = 0;
        for(char cVal : number.toCharArray()){
            decimal = decimal*base + charToInt(cVal);
        }
        return decimal;
    }

    /**
     * Converts a decimal number to a number in any other given base
     * @param decimal decimal to be rebased
     * @param base base to rebase the decimal to
     * @return String containing the decimals equivalent in the given system
     */
    private String decimalToBase(int decimal, int base){
        if(base>this.MAX_BASE ||base < 2){
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();

        // Convert from decimal to binary
        while (decimal != 0) {
            sb.append(intToChar(decimal % base));
            decimal = decimal / base;
        }
        // Reverse because the algorithm works the wrong way around
        sb.reverse();
        return sb.toString();
    }

    // Character conversion methods

    /**
     * Initializes the Map that maps each number to a corresponding char in a given number system
     *
     * @param numberSystem number system for which to create a map
     */
    private void createDecToNumMap(int numberSystem)
    {
        decToNumMap = new BidirectionalMap<>();
        for (Integer i = 0; i < 10 || i < numberSystem; i++) {
            if (i < 10)
                decToNumMap.put(i, (char) (i + 48));
            else
                decToNumMap.put(i, (char) ('A' + i - 10));
        }
    }

    /**
     * Converts a decimal value to it's corresponding character representation in the currently used system
     *
     * @param value Decimal number
     * @return Character value of "value"
     */
    private char intToChar(int value)
    {
        return decToNumMap.get(value);
    }

    /**
     * Converts a character representation in the currently used system into it's corresponding decimal value
     *
     * @param value Decimal number
     * @return Character value of "value"
     */
    private int charToInt(char value)
    {
        return decToNumMap.getKey(Character.toUpperCase(value));
    }

    /**
     * This is a bidirectional map
     * It's a utility to achieve inverse map lookup without having to do an O(n) search
     *
     * @param <K> the type of keys maintained by this map
     * @param <V> the type of mapped values
     */
    private class BidirectionalMap<K, V>
    {

        HashMap<K, V> map = new HashMap<>();
        HashMap<V, K> inverseMap = new HashMap<>();

        /**
         * Associates the specified value with the specified key in this map.
         * If the map previously contained a mapping for the key, the old
         * value is replaced.
         *
         * @param key key with which the specified value is to be associated
         * @param value value to be associated with the specified key
         */
        void put(K key, V value)
        {
            map.put(key, value);
            inverseMap.put(value, key);
        }

        /**
         * Returns the value to which the specified key is mapped,
         * or {@code null} if this map contains no mapping for the key.
         * @param key key to fetch the value for
         */
        V get(K key)
        {
            return map.get(key);
        }

        /**
         * Returns the key to which the specified value is mapped,
         * or {@code null} if this map contains no mapping for the value.
         * @param value value to fetch the key for
         */
        K getKey(V value)
        {
            return inverseMap.get(value);
        }

        @Override
        public String toString()
        {
            return map.toString();
        }
    }
}

import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Lukas Szimtenings
 */
public class VectorRn
{
    private ArrayList<Double> vector;

    /**
     * Initializes a new Vector with the passed arguments
     *
     * @param vector the content this vector should be initialized with
     */
    public VectorRn(ArrayList<Double> vector){
        this.vector = vector;
    }

    /**
     * performs an addition with this and another vector
     *
     * @param v2 the vector that should be added to this
     * @return a Vector containing the result of the addition
     */
    public VectorRn add(VectorRn v2){
        checkSize(v2);

        ArrayList<Double> v3 = new ArrayList<>();

        Iterator<Double> v2It = v2.vector.iterator();
        Iterator<Double> v1It = this.vector.iterator();
        while (v1It.hasNext()&&v2It.hasNext()){
            v3.add(v1It.next()+v2It.next());
        }

        return new VectorRn(v3);
    }

    /**
     * checks if v2 is of the same dim as this
     * if that is not the case an Exception is thrown
     * @throws InvalidParameterException if v2 doesn't have the same length as this an Exception is thrown
     */
    private void checkSize(VectorRn v2)
    {
        if(v2.vector.size() != this.vector.size())
            throw new InvalidParameterException("Vector v2 doesn't have the same dimensions as this vector");
    }

    /**
     * Multiplies this with a given scalar
     *
     * @param d the scalar to multiply this vector with
     * @return the result of the multiplication
     */
    public VectorRn mult(double d){
        ArrayList<Double> newVector = new ArrayList<>();
        for(Double element : this.vector){
            newVector.add(element*d);
        }
        return new VectorRn(newVector);
    }

    //////////////
    //Blatt 4
    /////////////

    /**
     * calculates the angle between two vectors
     * @param v1 vector to calculate the angle between
     * @param v2 vector to calculate the angle between
     * @return the angle between vectors v1 and v2
     */
    public static double getWinkel(VectorRn v1, VectorRn v2){
        double ret;

        ret = v1.mult(v2);
        ret /= v1.stdNorm()*v2.stdNorm();
        ret = Math.acos(ret);
        
        return ret;
    }

    /**
     * Projects vector v1 onto vector v2
     * @param v1 vector to be projected onto v2
     * @param v2 vector to be projected on
     * @return the orthogonal projection of v1 onto v2
     */
    public static VectorRn projiziereV1AufV2(VectorRn v1, VectorRn v2){
        v1.checkSize(v2);
        VectorRn vRet;
        double coef = v1.mult(v2)/v2.mult(v2);
        vRet = new VectorRn(v2.vector);
        vRet.mult(coef);
        return vRet;
    }

    /**
     * calculates the standard euclidean norm
     * @return the standard euclidean norm of this vector
     */
    public double stdNorm(){
        double sum = 0;
        for(double e : this.vector){
            sum += Math.pow(e,2);
        }
        return Math.sqrt(sum);
    }

    /**
     * calculates the standard scalar product
     * @param v vector to build the scalar product with
     * @return the standard scalar product
     */
    public double mult(VectorRn v){
        checkSize(v);
        double ret = 0;
        for(int i = 0; i< this.vector.size();i++){
            ret += this.vector.get(i)*v.vector.get(i);
        }
        return ret;
    }

    public static void main(String[] args){
        Blatt3();
        Blatt4();
    }

    /**
     * Aufgabenblatt 3
     */
    public static void Blatt3(){
        Double[] doublesArray = new Double[]{2.5,2.6,4.8,5.};
        Double[] doublesArray2 = new Double[]{8.1,4.3,1.5,2.1};
        VectorRn v1 = new VectorRn(new ArrayList<>(Arrays.asList(doublesArray)));
        VectorRn v2 = new VectorRn(new ArrayList<>(Arrays.asList(doublesArray2)));
        VectorRn v3 = v2.add(v1);
        v3.mult(3);
    }

    /**
     * Aufgabenblatt 4
     */
    public static void Blatt4(){
        Double[] doublesArray = new Double[]{1.,2.,3.,4.};
        Double[] doublesArray2 = new Double[]{5.,6.,7.,8.};
        Double[] doublesArray3 = new Double[]{5.,2.};
        Double[] doublesArray4 = new Double[]{-2.,5.};
        VectorRn a = new VectorRn(new ArrayList<>(Arrays.asList(doublesArray)));
        VectorRn b = new VectorRn(new ArrayList<>(Arrays.asList(doublesArray2)));
        VectorRn c = new VectorRn(new ArrayList<>(Arrays.asList(doublesArray3)));
        VectorRn d = new VectorRn(new ArrayList<>(Arrays.asList(doublesArray4)));

        System.out.println(getWinkel(a,b));
        System.out.println(getWinkel(c,d));
        System.out.println(projiziereV1AufV2(c,d));
    }

    @Override
    public String toString()
    {
        return this.vector.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "(", ")"));
    }
}

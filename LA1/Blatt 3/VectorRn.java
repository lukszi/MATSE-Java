import java.security.InvalidParameterException;
import java.util.*;

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
        if(v2.vector.size() != this.vector.size())
            throw new InvalidParameterException("Vector v2 doesn't have the same dimensions as this vector");

        ArrayList<Double> v3 = new ArrayList<>();

        Iterator<Double> v2It = v2.vector.iterator();
        Iterator<Double> v1It = this.vector.iterator();
        while (v1It.hasNext()&&v2It.hasNext()){
            v3.add(v1It.next()+v2It.next());
        }

        return new VectorRn(v3);
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

    public static void main(String[] args){
        Double[] doublesArray = new Double[]{2.5,2.6,4.8,5.};
        Double[] doublesArray2 = new Double[]{8.1,4.3,1.5,2.1};
        VectorRn v1 = new VectorRn(new ArrayList<>(Arrays.asList(doublesArray)));
        VectorRn v2 = new VectorRn(new ArrayList<>(Arrays.asList(doublesArray2)));
        VectorRn v3 = v2.add(v1);
        v3.mult(3);
    }
}

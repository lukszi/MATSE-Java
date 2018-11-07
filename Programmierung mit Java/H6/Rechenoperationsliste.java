import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class Rechenoperationsliste
{
    private List<Rechenoperation> opList;

    public Rechenoperationsliste(){
        opList = new ArrayList<>();
    }

    /**
     * adds an operation to the operation list
     * @param operation operation to be added to the list
     */
    public void add(Rechenoperation operation){
        this.opList.add(operation);
    }

    /**
     * transforms all array elements with the operations in the list
     * @param feld array of elements to be transformed
     * @return array of transformed elements
     */
    public double[] transform(double[] feld){
        double[] ret = new double[feld.length];
        for(int i = 0; i<feld.length; i++){
            ret[i] = feld[i];
            for(Rechenoperation op : opList){
                ret[i] = op.berechnung(ret[i]);
            }
        }
        return ret;
    }
}

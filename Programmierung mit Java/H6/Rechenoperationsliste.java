import java.util.ArrayList;
import java.util.List;

public class Rechenoperationsliste
{
    private List<Rechenoperation> opList;

    public Rechenoperationsliste(){
        opList = new ArrayList<>();
    }

    public void add(Rechenoperation operation){
        this.opList.add(operation);
    }

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

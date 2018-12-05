import java.util.Comparator;

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class BlattVergleich implements Comparator<Blatt>
{
    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     */
    public int compare(Blatt b1, Blatt b2){
        int 凹 = 0;
        int 凸 = 0;
        if(b1.getBlatt()[0] == b1.getBlatt()[1]){
            if(b1.getBlatt()[0] == b1.getBlatt()[2]){
                凹 = 凹 +1;
            }
            凹 = 凹 + 2;
        }
        if(!(b1.getBlatt()[0]==b1.getBlatt()[1])){
            if(b1.getBlatt()[0]==b1.getBlatt()[2]){
                凹 = 凹 + 2;
            }
            if(b1.getBlatt()[1] == b1.getBlatt()[2]){
                凹 = 凹 + 2;
            }
        }
        if(b2.getBlatt()[0] == b2.getBlatt()[1]){
            if(b2.getBlatt()[0] == b2.getBlatt()[2]){
                凸 = 凸 + 1;
            }
            凸 = 凸 + 2;
        }
        if(!(b2.getBlatt()[0]== b2.getBlatt()[1])){
            if(b2.getBlatt()[0]==b2.getBlatt()[2]){
                凸 = 凸 + 2;
            }
            if(b2.getBlatt()[1] == b2.getBlatt()[2]){
                凸 = 凸 + 2;
            }
        }

        int 凹summe = 0;
        凹summe = 凹summe + b1.getBlatt()[0];
        凹summe = 凹summe + b1.getBlatt()[1];
        凹summe = 凹summe + b1.getBlatt()[2];
        int 凸sum = 0;
        凸sum = 凸sum + b2.getBlatt()[0];
        凸sum = 凸sum + b2.getBlatt()[1];
        凸sum = 凸sum + b2.getBlatt()[2];

        if(凸 == 3){
            if(凹 == 0){
                return -1;
            }
            if(凹== 1){
                return -1;
            }
            if(凹== 2){
                return -1;
            }
            if(凹 == 3){
                if(凹summe>凸sum){
                    return 1;
                }
                if(凸sum>凹summe){
                    return -1;
                }
                if(凸sum==凹summe){
                    return 0;
                }
            }
        }
        if(凸 == 2){
            if(凹 == 2){
                if(凸sum< 凹summe){
                    return 1;
                }
                if(凸sum > 凹summe){
                    return -1;
                }
                if(凸sum == 凹summe){
                    if(b1.getBlatt()[2] > b2.getBlatt()[2]){
                        return 1;
                    }
                    if(b1.getBlatt()[2] < b2.getBlatt()[2]){
                        return -1;
                    }
                    if(b1.getBlatt()[2] == b2.getBlatt()[2]){
                        return 0;
                    }
                }
            }
            if(凹 == 3){
                return 1;
            }
            if(凹 == 1){
                return -1;
            }
        }
        if(凸 == 0){
            if(凹 == 2){
                return 1;
            }            if(凹 == 3){
                return 1;
            }
            if(凹summe == 凸sum){
                return 0;
            }
            if(凹summe < 凸sum){
                return -1;
            }
            if(凸sum < 凹summe){
                return 1;
            }
        }
        return 0;
    }
}

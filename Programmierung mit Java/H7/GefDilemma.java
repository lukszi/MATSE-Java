/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class GefDilemma
{   
    private GefStrategie player1;
    private GefStrategie player2;

    private int points1 = 0;
    private int points2 = 0;

    public GefDilemma(GefStrategie player1, GefStrategie player2)
    {
        this.player1 = player1;
        this.player2 = player2;
    }
    /**
    * @param initializing the amount of games
    * @return to print output who´s won the most games
    */
    public void spiele(int n)
    {
        for (int i = 0; i < n; i++) {
            boolean dec1 = player1.getNextDecision();
            boolean dec2 = player2.getNextDecision();
            // set players decisions
            player1.setOpponentNextDecision(dec2);
            player2.setOpponentNextDecision(dec1);
            // adding winning points to each player
            if (dec1 == dec2) {
                if (dec1) {
                    points1 += 2;
                    points2 += 2;
                } else {
                    points1 += 4;
                    points2 += 4;
                }
            }
            else if(dec1)
            {
                points1 += 6;
                points2 += 1;
            }
            else
            {
                points1 += 1;
                points2 += 6;
            }
        }
        // print out winning player 
        if(points1 < points2){
            System.out.println("Es gewinnt: " + "player1" + " mit " + points1 + " Punkten");
        }
        else if(points2 < points1){
            System.out.println("Es gewinnt: " + "player2" + " mit " + points2 + " Punkten");
        }
        else{
            System.out.println("Gleichstand mit " + points1 + " Punkten");
        }

    }
}

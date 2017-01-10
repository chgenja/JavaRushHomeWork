package headfirst.SimpleDotCom;

/**
 * Created by Kira on 15.09.2015.
 */
public class SimpleDotCom
{
    int[] locationCells;
    int numOfHits;

    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";

        for (int cell: locationCells) {
            if (guess == cell) {
                result = "hit";
                numOfHits++;
                break;
            }
        }

        if (numOfHits == locationCells.length) {
            result = "kill";
        }
        System.out.println(result);
        return result;
    }

    void setLocationCells(int[] locs) {
        locationCells = locs;
    }
}

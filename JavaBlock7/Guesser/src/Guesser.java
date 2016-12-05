import java.util.ArrayList;

/**
 * Created by block7 on 10/4/16.
 */
public class Guesser {
    //private int[] keeper = {};
    ArrayList<Integer> keeper = new ArrayList<Integer>();

    public Guesser(){}

    public int guess(){
        int tempGuess = 0;
        tempGuess = (int) (Math.random() * 100) + 1;
        System.out.println(tempGuess);
        if (isValid(tempGuess)) return tempGuess;
        else return this.guess();
    }

    private boolean isValid(int guess) {
        for(int i: keeper){
            if(i == guess) return false;
        }
        keeper.add(guess);
        System.out.println(keeper);
        return true;
    }

}

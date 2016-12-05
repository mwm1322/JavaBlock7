/**
 * Created by block7 on 9/12/16.
 */
public class ComputerPlayer extends Player {
    int roundNum;

    public void setRoundNum(int newRoundNum) {
        roundNum = (newRoundNum % 3) + 1;
    }

    public String choose() {
        //int choice = (int) (Math.random() * 3)+1;
        //System.out.println(roundNum);
        if (roundNum == 1)
            return "rock";
        else if (roundNum == 2)
            return "paper";
        else if (roundNum == 3)
            return "scissors";
        else
            return "error";
    }
}
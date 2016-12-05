import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by block7 on 10/4/16.
 */public class GuesserMain {
    public static String readLine(String prompt) {
        String line = null;
        Console c = System.console();
        if (c != null) {
            line = c.readLine(prompt);
        } else {
            System.out.print(prompt);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                //Ignore
            }
        }
        return line;
    }

    public static void main(String[] args){
        String input = readLine("What is your secret number between 1 and 100?");
        Guesser guesser = new Guesser();
        boolean isGuessIncorrect = true;
        while (isGuessIncorrect) {
            int guess = guesser.guess();
            System.out.println("The guess is " + guess);
            String answer = readLine("Is this correct? Too low, too high? input -, +, or =");
            if (answer.equals("-")){
                System.out.println("Darn, I'll guess again");
            }
            else if (answer.equals("+")){
                System.out.println("Darn, I'll guess again");
            }
            else if (answer.equals("=")){
                System.out.println("Success!");
                isGuessIncorrect = false;
            }
            else {
                System.out.println("error");
            }
        }
    }

}


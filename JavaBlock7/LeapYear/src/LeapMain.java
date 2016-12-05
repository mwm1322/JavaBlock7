import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by block7 on 10/18/16.
 */
public class LeapMain {
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
        int input = Integer.valueOf(readLine("Enter your year"));
        System.out.println(isLeapYear(input));
    }

    static boolean isLeapYear(int year){
        if(year%4 != 0){
            return false;
        }
        else if (year%100 != 0){
            return true;
        }
        else if(year%400 != 0){
            return false;
        }
        else{
            return true;
        }
    }
}

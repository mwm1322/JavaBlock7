import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by block7 on 11/28/16.
 */
public class JPSD {
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
        System.out.println(fibonacci());
        strip();
    }

    public static int fibonacci(){
        String input = readLine("Which Fibonacci number do you want?");
        int n = Integer.parseInt(input);
        int fibPrev = 0;
        int fibNow = 1;
        int holder = 0;
        for(int i = 1; i < n; i++){
            holder = fibNow;
            fibNow = fibPrev + fibNow;
            fibPrev = holder;
        }
        return fibNow;
    }

    public static void strip(){
        String input = readLine("Give me a string to convert");
        String gangGang = "";
        int length = input.length();
        for(int i = 0; i < length; i++){
            char holder = input.charAt(i);
            gangGang = gangGang + convert(holder);
        }
    }

    public static String convert(char c){
        String confirmNum = "";
        for(int i = 0; i < 10; i++){
            if(c == i) {return confirmNum;}
        }
        return "c";
    }
}

package lsrhs.java;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverserMain {

	// our standard readLine method
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
	
	// simple main to get input and print its reverse
	public static void main(String[] args) {
		String s = readLine("Enter a string to reverse: ");
		ReversedString rs = new ReversedString(s);
		System.out.println(rs.revString);
	}
}

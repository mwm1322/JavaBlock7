package lsrhs.java;


// when you create a ReversedString it takes on the value of the input string reversed 
// (e.g., ReversedString("peanut") will have the value "tunaep")

public class ReversedString {

		String revString;
		
		public ReversedString(String input) {
			if (input != null) {
				String s = "";
				for (int i = input.length() -1; i >= 0; i--) {
					s = s + String.valueOf(input.charAt(i));
				}
				revString = s;
			}
		}
		
		public String toString() {
			return revString;
		}
	
}

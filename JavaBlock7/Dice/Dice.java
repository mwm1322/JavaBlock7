// Dice Class
// Represents a roll of 1 or more dice with a given number of sides.
// This is intended to support dice rolls as occur in board games or
// pen & paper roleplaying games.

// Rolling two standard 6-sided dice for (say) Monopoly would
// use nDice = 2, nSidesPerDie = 6 (or, 2d6).

// Rolling percentile dice (1-100) would use
// nDice = 1, nSidesPerDie = 100  (or, 1d100).

// Rolling two 20-sided dice would be nDice = 2,
// nSidesPerDie = 20 (or, 2d20).

// A utility and constructor to parse a string in the "2d6" style for use
// with this class is also provided.

public class Dice {

        // see above for purpose
		int nDice;
		int nSidesPerDie;

        // **************************************************
		// to create dice
		
		// default is one regular 6-sided die
		public Dice() {
			nDice = 1;
			nSidesPerDie = 6;
		}

		// constructor to specify dice numerically
		public Dice(int nD, int nSPD) {
			nDice = nD;
			nSidesPerDie = nSPD;
		}

		// used to specify the dice via a string
        // (see parseDiceString below)
		public Dice(String s) {		
			parseDiceString(s);
		}


        // ****************************************************
        // Utility methods

		// parse a string in the "2d6" style format to find number
        // of dice and sides per die; this method assumes the string
        // is valid and behavior when it is invalid is not guaranteed

		void parseDiceString(String s) {
			nDice = nSidesPerDie = -1;
			int dPos = s.indexOf("d");

			if (dPos > 0) {
				nDice = Integer.parseInt(s.substring(0,dPos));
				if (dPos < s.length()) {
					nSidesPerDie =
                        Integer.parseInt(s.substring(dPos + 1));
				}
			}

		}

		// return a string for these dice in the "2d6" format
		public String toString() {
			return String.valueOf(nDice) + "d" +
                   String.valueOf(nSidesPerDie);
		}


		// utility method to return a random integer in a given
        // range of values
		static int randomInRange(int min, int max) {
            return (int) (Math.random() * max + min);
		}


        // **************************************************
        // rollDice -- main method to be used by the outside the world.
        // Rolls the dice and returns result.

		public int rollDice() {
			
			int total = 0;
			for (int i = 1; i <= nDice; i++) {
				total = total + randomInRange(1, nSidesPerDie);
			}		
			return total;
			
		}

		// main--has some very simple test code
/*		public static void main(String[] args) {
			System.out.println(new Dice("2d6").rollDice());
			System.out.println(new Dice("1d100").rollDice());
			System.out.println(new Dice("5d10").rollDice());
		}*/
}

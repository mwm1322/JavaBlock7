/* class WumpusGame -- main game class; provides main loop and some utilities.  */

import java.io.*;
import java.util.ArrayList;

public class WumpusGame {
	private ArrayList<Player> players = new ArrayList<Player>();
	public WumpusMap gameMap = new WumpusMap();
	boolean isGameRunning = true;

	// special i/o method required because Eclipse does not provide a Console object
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

	void createMap() {
		gameMap.addElement(new TreasureElement());
		gameMap.addElement(new PitElement());
		gameMap.addElement(new BatsElement());
		gameMap.addElement(new WumpusElement());
	}

	int numOfPlayers(){
		String input = readLine("How many player? 1-4");
		return Integer.parseInt(input);
	}

	void addPlayers(){
		int numOfPlayers = numOfPlayers();
		for(int i = 0; i < numOfPlayers; i++){
			players.add(new Player(gameMap));
		}
	}

	void playRound(){
		for(int i = 0; i < players.size(); i++){
			if (isGameRunning) {
				if (players.get(i).gameActive) {
					System.out.println("It is player " + (i + 1) + "'s turn");
					System.out.println(players.get(i).gameActive);
					players.get(i).updatePlayerMap(gameMap);
					gameMap = players.get(i).play();
					isGameRunning = players.get(i).isWumpusAlive;
				} else {
					System.out.println("Player " + (i + 1) + " is ded");
				}
			}
		}
	}

	public void run() {
		this.createMap();
		this.addPlayers();
		//boolean isGameRunning = true;
		while (isGameRunning) {
			this.playRound();
			boolean activePlayers = false;
			for(int i = 0; i < players.size(); i++){
				if (players.get(i).gameActive) {
					activePlayers = true;
				}
			}
			if (!activePlayers){
				isGameRunning = false;
			}
		}
	}
}

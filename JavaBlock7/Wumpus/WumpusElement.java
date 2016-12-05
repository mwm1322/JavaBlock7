
public class WumpusElement extends RoomElement {

	public void handle(Player player) {
		System.out.println("You are eaten by the wumpus!");
		player.gameActive = false;
	}
	
	public void printSenses() {
		System.out.println("You smell a wumpus.");
	}
}

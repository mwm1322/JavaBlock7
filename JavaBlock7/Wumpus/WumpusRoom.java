/* WumpusRoom -- This class represents a single room on the map; a room corresponds to one vertex of a dodecahedron.
 * The class helps in navigating the map and handling encounters when the player moves. 
 */
public class WumpusRoom {

		private int myIndex;		//  the rooms are numbered 1-20; the index refers to that number
		private int[] neighbors;	// index values for neighboring rooms in order: N, E, S, W
		private WumpusMap map;
		private RoomElement myElement;
		
		WumpusRoom(WumpusMap map, int ndx, int n, int e, int s, int w) {
			this.map = map;
			myIndex = ndx;
			neighbors = new int[WumpusMap.N_DIRECTIONS + 1];
			neighbors[WumpusMap.NORTH] = n;
			neighbors[WumpusMap.EAST] = e;
			neighbors[WumpusMap.SOUTH] = s;
			neighbors[WumpusMap.WEST] = w; 
		}
		
		int getIndex() {
			return myIndex;
		}
		
		RoomElement getElement() {
			return myElement;
		}
		
		void setElement(RoomElement elem) {
			myElement = elem;
		}
		
		WumpusRoom roomInDirection(int dir) {
			return map.getRoom(neighbors[dir]);
		}
		
		void printInfo() {
			System.out.print("You are in room " + String.valueOf(myIndex) +". Exits:");
			for (int i = 1; i <= WumpusMap.N_DIRECTIONS; i++) {
				WumpusRoom room = roomInDirection(i);
				if (room != null) {
					System.out.print(" " + WumpusMap.directionName(i));
				}
			}
			System.out.println();
			for (int i = 1; i <= WumpusMap.N_DIRECTIONS; i++) {
				WumpusRoom room = roomInDirection(i);
				if (room != null && room.myElement != null) {
					room.myElement.printSenses();					
				}
			}
			System.out.println();
		}
		
		void handleElement(Player player) {
			if (myElement != null) {
				myElement.handle(player);
			}
		}
}

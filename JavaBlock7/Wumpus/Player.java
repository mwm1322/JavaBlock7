//import static java.lang.Character.UnicodeBlock.map;

/**
 * Created by block7 on 11/3/16.
 */
public class Player {
    public WumpusMap playerMap;
    public boolean gameActive;
    public int currentRoomIndex;
    public boolean isWumpusAlive;

    public Player(WumpusMap map){
        this.gameActive = true;
        this.isWumpusAlive = true;
        this.playerMap = map;
        this.currentRoomIndex = map.randomEmptyRoom();
    }


    int treasure = 0;

    public WumpusRoom currentRoom() {return playerMap.getRoom(currentRoomIndex);}

    public void addTreasure() { treasure++; }

    public int getTreasure(){
        return treasure;
    }

    public void updatePlayerMap(WumpusMap map){
        playerMap = map;
    }

    public WumpusMap play(){
        //do  {
            playerMap.getRoom(currentRoomIndex).printInfo();
            String userInput = WumpusGame.readLine("> ");
            int direction = 0;
            if (userInput.startsWith("shoot")) {
                shootArrow(userInput);
            } else if ((direction = WumpusMap.directionNumber(userInput)) != 0) {
                WumpusRoom nowRoom = playerMap.getRoom(currentRoomIndex);
                WumpusRoom targetRoom = nowRoom.roomInDirection(direction);
                if (targetRoom != null) {
                    currentRoomIndex = targetRoom.getIndex();
                    targetRoom.handleElement(this);
                } else {
                    System.out.println("You can't move in that direction.");
                }
            } else if (userInput.equals("bye")) {
                gameActive = false;
            } else {
                System.out.println("Command not understood.");
            }
            return playerMap;
        //} while (gameActive);
        //System.out.println("GAME OVER");
    }

    private void shootArrow(String input) {
        String direction = input.substring(6);  // direction should be input after "shoot " part
        int dirNum = WumpusMap.directionNumber(direction);
        if (dirNum == 0) {
            System.out.println("Huh?");   // bad shoot direction
        } else {
            WumpusRoom room = this.currentRoom();
            WumpusRoom targetRoom = room.roomInDirection(dirNum);
            if (targetRoom != null) {
                if (targetRoom.getElement() != null && (targetRoom.getElement() instanceof WumpusElement)) {
                    System.out.println("You shoot the wumpus.  Victory!!");
                    gameActive = false;
                    isWumpusAlive = false;
                } else {
                    System.out.println("You missed and scared the wumpus.");
                    playerMap.moveWumpus();
                }
            } else {
                System.out.println("Can't fire that way.");
            }
        }
    }
}

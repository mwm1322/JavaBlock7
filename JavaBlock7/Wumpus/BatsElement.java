/**
 * Created by block7 on 11/2/16.
 */
public class BatsElement extends RoomElement {
    public void printSenses(){
        System.out.println("You hear fluttering");
    }

    public void handle(Player player){
        int newRoom = player.playerMap.randomEmptyRoom();
        player.currentRoomIndex = newRoom;
        System.out.println("Bats whisk you away!");
    }
}

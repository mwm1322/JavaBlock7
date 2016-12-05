/**
 * Created by block7 on 11/2/16.
 */
public class PitElement extends RoomElement {
    public void printSenses(){
        System.out.println("You feel a draft");
    }

    public void handle(Player player){
        player.gameActive = false;
        System.out.println("You fell down a pit!");
    }
}

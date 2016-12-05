/**
 * Created by block7 on 11/3/16.
 */
public class TreasureElement extends RoomElement {
    public void printSenses(){
        System.out.println("You see a yellow shine.");
    }

    public void handle(Player player){
        player.addTreasure();
        System.out.println("You discovered gold! Now you have " + player.getTreasure());
    }
}

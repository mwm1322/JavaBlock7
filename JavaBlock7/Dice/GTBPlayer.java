/**
 * Created by block7 on 10/21/16.
 */
public class GTBPlayer {
    public GTBPlayer(){}
    public void rollForOneRound(){

        int r1 =0;
        int a = new Dice("1d6").rollDice();
        int b = new Dice("1d6").rollDice();
        int c = new Dice("1d6").rollDice();
        if (a>b && a>c){
            r1 = a;
        }
        else if (b>a && b>c){

            r1 = b;
        }
        else if (a>b && a>c){
            r1 = c;
        }
        else if (a==b && a>c){
            r1 = a;
        }
        else if (b==c && b>a){
            r1 = b;
        }
        else {
            r1 = c;
        }

        int r2 =0;
        int d = new Dice("1d6").rollDice();
        int e = new Dice("1d6").rollDice();
        if (d>e){
            r2 = d;
        }
        else{
            r2 = e;
        }

        int r3 = new Dice("1d6").rollDice();



        System.out.println("The three numbers are "+r1+r2+r3);


    }
}

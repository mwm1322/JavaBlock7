/**
 * Created by block7 on 10/26/16.
 */
public class ArrayMain {
    public static void main(String[] args){
        LSArray a = new LSArray(10);
        System.out.println(a);
        a.randomize(9);
        a.printArray();
        //a.swap(3,4);
        //a.printArray();
        //a.selectionSort();
        a.copy();
        a.printArray();
    }
}

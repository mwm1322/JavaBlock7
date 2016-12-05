/**
 * Created by block7 on 10/26/16.
 */
public class LSArray {
    int[] myArray;
    int[] urArray;

    LSArray(int size){
        myArray = new int[size];
        System.out.println(myArray.length);
        urArray = new int[size];
        System.out.println(urArray.length);

    }

    void randomize(int maxInt){
        for (int i = 0; i<myArray.length; i++){
            myArray[i] =  (int) (Math.random() *maxInt + 1);
            urArray[i] =  (int) (Math.random() *maxInt + 1);

        }
    }

    void printArray(){
        System.out.println("");
        //for (int i: myArray){
        for (int i = 0; i<myArray.length; i++){
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
        for (int i = 0; i<urArray.length; i++){
            System.out.print(urArray[i] + " ");
        }
        System.out.print("\nboom");
    }

    void swap(int f, int s){
        int keeper = myArray[f];
        myArray[f] = myArray[s];
        myArray[s] = keeper;
    }

    void selectionSort(){
        for (int i = 0; i < myArray.length; i++){
            int valueAti = myArray[i];
            int positionOfLowest = i;
            for (int j = i + 1; j < myArray.length; j++){
                if(myArray[positionOfLowest] > myArray[j]){
                    positionOfLowest = j;
                }
            }
            swap(i,positionOfLowest);
        }
    }

    void copy(){
        for (int i = 0; i < myArray.length; i++){
            urArray[i] = myArray[i];
        }
    }
}

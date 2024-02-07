
import java.util.Arrays;

public class MultiDimensionalArray {
    public static void main(String[] args) {

        int[][] arr = new int[2][2]; //row is print that is first value

        arr[0][0] = 100;
        arr[0][1] = 200;
        arr[1][0] = 300;
        arr[1][1] = 400;

        int ar[][] = {{100,200},{300,400}}; // storing data in single line

        System.out.println(arr.length);
        System.out.println(arr[1][0]);

        // using for loop

        for (int i=0;i< arr.length;i++){
            for(int j=0;j< arr.length;j++){
                System.out.println(arr[i][j]);
            }
        }

        // using for each loop

        for (int [] a : arr){
            for (int b :a){
                System.out.println(b);
            }
        }

        // using toString method

        for (int [] a : arr){
            System.out.println(Arrays.toString(a));
        }
    }
}

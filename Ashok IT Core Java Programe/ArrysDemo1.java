import java.util.Arrays;

// find min and max element from the array using arrays predefined method

public class ArrysDemo1 {
    public static void main(String[] args) {

        int[] arr ={15,8,9,2,11,4};

        /*System.out.print("Arrays before sorting ::");
        for(int i=0;i< arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

            Arrays.sort(arr);
            System.out.print("Arrays after sorting ::");
            for(int i = 0; i< arr.length; i++) {
                System.out.print(arr[i] + " ");
            }*/

        Arrays.sort(arr);
        System.out.println(arr[0]);
        System.out.println(arr[arr.length-1]);
    }
}

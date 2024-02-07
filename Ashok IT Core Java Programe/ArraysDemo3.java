// Reverse the given array

public class ArraysDemo3 {
    public static void main(String[] args) {

        int[] arr = {15,8,4,2,11,7};

       /* for(int i= arr.length-1;i>=0;i--){
            System.out.print(arr[i]+" ");
        }*/

        int[] temp = new int[arr.length];
        int cnt = 0;

        for(int i= arr.length-1;i>=0;i--){
            temp[cnt] = arr[i];
            cnt++;
        }
        for(int n : temp) {
            System.out.print(n + " ");
        }
    }
}

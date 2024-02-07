import java.util.Arrays;

public class ReverseArrays1 {
    public static void main(String[] args) {

        int[] arr = {189,156,119,194,138,190,128,167,145,176};

        System.out.println(Arrays.toString(arr));
        int temp=0;

        for(int i=0;i< arr.length/2;i++){
            temp =arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}

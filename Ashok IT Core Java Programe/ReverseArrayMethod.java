import java.util.Arrays;

public class ReverseArrayMethod {

    int[] reverseArray(int[] arr) {
        int[] reversedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArray[i] = arr[arr.length - 1 - i];
        }
        return reversedArray;
    }

    public static void main(String[] args) {
        ReverseArrayMethod a = new ReverseArrayMethod();
        int[] arr = {2, 6, 4, 3, 8};
        int[] reversedArr = a.reverseArray(arr);
        System.out.println(Arrays.toString(reversedArr));
    }
}

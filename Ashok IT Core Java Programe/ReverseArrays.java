import java.util.Arrays;

public class ReverseArrays {
    public static void main(String[] args) {
        int[] arr = {189, 156, 119, 194, 138, 190, 128, 167, 145, 176};

        System.out.println(Arrays.toString(arr));

        int[] a = new int[arr.length];
        int count = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            a[count] = arr[i];
            count++;
        }

        System.out.println(Arrays.toString(a));
    }
}

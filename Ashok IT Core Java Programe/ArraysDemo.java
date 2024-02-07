import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraysDemo {
    public static void main(String[] args) {

        int[] arr = {111,122,113,174,115};
        System.out.println(arr.length);

        Arrays.sort(arr);

        System.out.println(arr[0]);
        System.out.println(arr[arr.length-1]);
    }
}

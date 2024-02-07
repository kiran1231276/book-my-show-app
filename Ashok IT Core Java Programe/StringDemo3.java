import java.util.Arrays;

public class StringDemo3 {
    public static void main(String[] args) {

        String str ="How are you today?";

        String arr[] = str.split(" ");

        System.out.println(Arrays.toString(arr));
    }
}

import java.util.Arrays;

public class Method2 {
    public static void main(String[] args) {

        Method2 m = new Method2();
        int[] arr = {7,5,8,3,9,2,4};

        m.print(arr);

    }

    void print(int[] arr){
        String str = Arrays.toString(arr);
        System.out.println(str);
    }
}
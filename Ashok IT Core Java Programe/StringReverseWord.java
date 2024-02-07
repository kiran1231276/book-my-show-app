import java.util.Arrays;

public class StringReverseWord {
    public static void main(String[] args) {

        // 1 st Approach

        String str = "Hello My Friend";

        String [] arr = str.split("\\s ");

        for(int i=0;i<arr.length;i++){
            String x = arr[i];
            StringBuffer sb = new StringBuffer(x);
            sb.reverse();
            System.out.print(sb+" ");
        }

        System.out.println("----------------------------------------");
        // 2 nd Approach

        String str2 = "What is your name";
        String [] a = str2.split(" ");

        for(String word : a){
            for(int i=word.length()-1;i>=0;i--){
                System.out.print(word.charAt(i));
            }
            System.out.print(" ");
        }
    }
}

import java.util.Arrays;

public class AnagramString {
    public static void main(String[] args) {

        String s= "bomb";
        String str = "mobb";

        char[] a = s.toCharArray();
        Arrays.sort(a);

        char[] b= str.toCharArray();
        Arrays.sort(b);

        if(Arrays.equals(a, b)){
            System.out.println("it is Anagram");
        }
        else{
            System.out.println("it is Not Anagram");
        }
    }
}

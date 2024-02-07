import java.util.Arrays;

public class StringAnagrams {
    public static void main(String[] args) {

        // 1 st Approach

        String str1 = "peacock";
        String str2 = "kcocaep";

        StringBuffer sb1 = new StringBuffer(str1);
        StringBuffer sb2 = sb1.reverse(); // peek
        String s1 = sb2.toString();

        StringBuffer ssb1 = new StringBuffer(str2);
        StringBuffer  ssb2 = ssb1.reverse(); // keep
        String s2 = ssb2.toString();

        if(str1.equals(s2) && str2.equals(s1)){
            System.out.println("It is Anagrams");
        }
        else {
            System.out.println("Not Anagrams");
        }

        // 2 nd Approach

        String st1 = "race";
        String st2 = "ecar";

        if(st1.length() != st2.length()){
            System.out.println("It is Not Anagrams");
        }

        char [] chars1 = st1.toCharArray();
        char [] chars2 = st2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        st1 = new String(chars1);
        st2 = new String(chars2);

        if(st1.equals(st2)){
            System.out.println("It is Anagrams");
        }
        else {
            System.out.println("Not Anagrams");
        }

    }
}

// Write a java programe to reverse a string

public class StringReverse {
    public static void main(String[] args) {

        // 1 st approach

        String str = "java";
        StringBuffer sb = new StringBuffer(str);

        sb.reverse();
        System.out.println(sb);

        // 2 nd approach

        String str1 = "kiran";
        String rev = "";
        for(int i=str1.length()-1;i>=0;i--){
            rev = rev + str1.charAt(i);
        }
        System.out.println(rev);
    }
}

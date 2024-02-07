public class StringPalindrome {
    public static void main(String[] args) {

        // 1 st Approch

        String str ="liril";
        StringBuffer sb = new StringBuffer(str);

        StringBuffer sb1 = sb.reverse();
        String str1 = sb1.toString();

        if(str.equals(str1)){
            System.out.println("it is palindrome");
        }
        else{
            System.out.println("Not palindrome");
        }

        // 2 nd Approch

        String s = "madam";
        String rev = "";

        for(int i=s.length()-1;i>=0;i--){
            rev = rev + s.charAt(i);
        }

        if (s.equals(rev)) {
            System.out.println("it is Palindrome");
        }
        else{
            System.out.println("Not Palindrome");
        }
    }
}

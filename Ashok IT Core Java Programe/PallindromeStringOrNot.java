public class PallindromeStringOrNot {
    public static void main(String[] args) {

        String s = "MADAM";
        StringBuilder str = new StringBuilder();

        for(int i=s.length()-1;i>=0;i--){
            str.append(s.charAt(i));
        }
        System.out.println(str);

        if(str.toString().equals(s)){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }
    }
}

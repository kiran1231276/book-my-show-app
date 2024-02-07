public class LengthStringMethod {

    int findLength(String str){
        return str.length();

    }
    public static void main(String[] args) {

        String s = "kiranvighne";
        LengthStringMethod l = new LengthStringMethod();
        int i = l.findLength(s);
        System.out.println(i);
    }
}

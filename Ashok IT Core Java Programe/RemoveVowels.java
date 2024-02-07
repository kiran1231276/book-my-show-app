public class RemoveVowels {
    public static void main(String[] args) {

        String s = "Hello,my name is kiran";
        String a = s.replaceAll("[aeiouAEIOU]","");
        System.out.println(a);
    }
}

public class PostIncrement {
    public static void main(String[] args) {

        int a = 12;
        int b = ++a + a++ +a++ + ++a;

        System.out.println(b);
    }
}

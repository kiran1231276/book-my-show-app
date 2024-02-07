public class PostPreDecrement {
    public static void main(String[] args) {

        int a = 13;
        int b = a-- + --a + a--;

        System.out.println(b);
    }
}

public class StaticVariable1 {

    int a = 10;
    static int b  = 20;

    public static void main(String[] args) {

        StaticVariable1 s = new StaticVariable1();
        System.out.println(s.a);
        System.out.println(s.b);

        s.a = 1000;
        s.b = 2000;
        System.out.println(s.a);
        System.out.println(s.b);

        StaticVariable1 s1 = new StaticVariable1();
        System.out.println(s.a);
        System.out.println(s.b);
    }
}

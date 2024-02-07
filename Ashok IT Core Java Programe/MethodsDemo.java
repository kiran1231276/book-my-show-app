public class MethodsDemo {

    void hello() {
        System.out.println("good Morning...");
    }

    static void greet() {
        System.out.println("hello,how r u");
    }

    public static void main(String[] args) {

        MethodsDemo m1 = new MethodsDemo();
        m1.hello();

        greet();
        m1.greet();
        MethodsDemo.greet();
    }
}

public class Method {
    public static void main(String[] args) {

        System.out.println("Main method....");

        Method x = new Method();
        x.m1();

        Method.m2();
    }

    void m1(){
        System.out.println("Instance method.....!");
    }

    static void m2(){
        System.out.println("Static method.....!");
    }
}

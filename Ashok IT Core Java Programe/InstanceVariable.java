public class InstanceVariable {
    int a ;

    public static void main(String[] args) {

        InstanceVariable v = new InstanceVariable(); // Object level variable can't access without crate object
        System.out.println(v.a);
    }
}

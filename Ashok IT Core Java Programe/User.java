public class User {
    public static void main(String[] args) {

        User u1 = new User();
        System.out.println(u1.hashCode()); // every object have unique hashcode

        User u2 = new User();
        System.out.println(u2.hashCode());

        User u3 = new User();
        System.out.println(u3.hashCode());
    }
}

public class StudentVariable {

    String name;
    String email;
    long phno;
    static String institute;

    public static void main(String[] args) {

        StudentVariable.institute = "ashokit";

        StudentVariable s1 = new StudentVariable();
        s1.name = "Ankit";

        StudentVariable s2 = new StudentVariable();
        s2.name = "Goutham";
    }
}
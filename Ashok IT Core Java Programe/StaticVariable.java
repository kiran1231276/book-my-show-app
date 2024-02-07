public class StaticVariable {

    String name;
    String email;
    String phnoNo;
    static String institute;

    public static void main(String[] args) {

        StaticVariable student1 = new StaticVariable();
        student1.name = "Kiran";
        student1.email ="Kiran@gmail.com";
        student1.phnoNo = "8987654567";
        StaticVariable.institute = "Vnmkv"; // we can access static variable with class name
    }
}

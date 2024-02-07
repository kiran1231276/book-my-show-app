import java.util.Locale;

public class NameUppercaseMethod {

    String nameUppercase(String s){
        return s.toUpperCase();
    }
    public static void main(String[] args) {

        NameUppercaseMethod n = new NameUppercaseMethod();
        String s = "kiran vighne";
        String s1 = n.nameUppercase(s);
        System.out.println(s1);
    }
}

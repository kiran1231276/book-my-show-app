import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Role of Software Engineer is: ");
        int exp = sc.nextInt();

        if (exp > 0 && exp <= 2) {
            System.out.println("Associate Engineer");
        } else if (exp >= 2 && exp <= 5) {
            System.out.println("Software Engineer");
        } else if (exp >= 5 && exp <= 7) {
            System.out.println("Senior Software Engineer");
        } else if (exp >= 7 && exp <= 10) {
            System.out.println("Manager");
        } else {
            System.out.println("Role Not Found");
        }
    }
}

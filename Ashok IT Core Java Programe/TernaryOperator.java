import java.util.Scanner;

public class TernaryOperator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        int num1 = sc.nextInt();

        System.out.println("Enter the second number: ");
        int num2 = sc.nextInt();

        int greatestNumber = (num1 > num2) ? num1 : num2;

        System.out.println("The greatest number between " + num1 + " and " + num2 + " is: " + greatestNumber);
    }
}

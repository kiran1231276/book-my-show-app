import java.util.Scanner;

public class GreaterNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 1st number :");
        int num1 = sc.nextInt();
        System.out.println("Enter The 2nd number :");
        int num2 = sc.nextInt();

        if(num1 > num2){
            System.out.println("Greater Number is :"+num1);
        }
        else {
            System.out.println("Greater number is :"+num2);
        }
    }
}

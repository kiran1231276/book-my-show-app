import java.util.Scanner;

public class GreaterNumber1 {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the 1st number :");
        int num1 = sc.nextInt();

        System.out.println("Enter the 2nd Number :");
        int num2 = sc.nextInt();

        System.out.println("Enter the 3rd Number :");
        int num3 = sc.nextInt();

        if(num1>num2 && num1>num3){
            System.out.println("Greatest number is :"+num1);
        }
        else if (num2>num1 && num2>num3) {
            System.out.println("Greatest Number is :"+num2);
        }
        else{
            System.out.println("Greatest number is :"+num3);
        }
    }
}

 /* 2. Write a java program to check if given number is prime number or not (take number from user).........*/

 import java.util.Scanner;

 public class PrimeNumber {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

         System.out.println("Please enter a number to check it is prime or not :");
         int num = sc.nextInt();

         int count = 0;

         for (int i = 1; i <= num; i++) {
             if (num % i == 0) {
                 count++;
             }
         }

         if (count == 2) {
             System.out.println(num + " is a prime number");
         } else {
             System.out.println(num + " is not a prime number");
         }
     }
 }
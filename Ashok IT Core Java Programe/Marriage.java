// write a programe to read person age and salary and print his eligibility for marriage
// condition : if person age <30 and salary > 1 lac then eligible for marriage

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Marriage {
    public static void main(String[] args) throws Exception{

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.println("Enter your age :");
        String str1 = br.readLine();
        int age = Integer.parseInt(str1);

        System.out.println("Enter your salary :");
        String str2 = br.readLine();
        double salary = Double.parseDouble(str2);

        if(age<30 && salary>100000){
            System.out.println("You are eligible for marriage");
        } else{
            System.out.println("Not eligible for marriage");
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LeapYearOrNot {
    public static void main(String[] args) throws Exception {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Enter the Number :");
        String str = br.readLine();
        int num = Integer.parseInt(str);

        if ((num % 4 == 0 && num % 100 != 0) || (num % 400 == 0)) {
            System.out.println("Leap Year");
        } else {
            System.out.println("Not Leaf Year");
        }
    }
}

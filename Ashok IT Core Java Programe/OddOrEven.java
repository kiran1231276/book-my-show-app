import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OddOrEven {
    public static void main(String[] args) throws Exception{

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Enter the Number : ");
        String str = br.readLine();
        int num = Integer.parseInt(str);

        if(num % 2 == 0){
            System.out.println("Number is Even");
        }
        else{
            System.out.println("Number is Odd");
        }
    }
}

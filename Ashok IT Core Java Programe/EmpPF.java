import java.io.BufferedReader;
import java.io.InputStreamReader;

// calculate pf of employee from its basic salary
public class EmpPF {
    public static void main(String[] args) throws Exception{

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.println("Enter the basic salary :");
        String str = br.readLine();
        double basicSalary = Double.parseDouble(str);

        double pf = basicSalary * 12/100;
        System.out.println(pf);
    }
}

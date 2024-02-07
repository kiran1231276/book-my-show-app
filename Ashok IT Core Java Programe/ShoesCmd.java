import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShoesCmd {
    public static void main(String[] args) throws Exception{

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Enter the Shoes Name :");
        String brand = br.readLine();

        switch (brand){

            case "Nike" :
                System.out.println("Just do it");
                    break;

            case "Adidas" :
                System.out.println("Impossible is nothing");
                    break;

            case "Reebok" :
                System.out.println("I am what i am");
                break;

            default :
                System.out.println("Brand is not found");
        }
    }
}

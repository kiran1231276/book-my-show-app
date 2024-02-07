import java.util.Arrays;

public class Method1 {
    public static void main(String[] args) {

        Method1 m1 = new Method1();

        int[] ar = {2,5,6,7};
        m1.print(ar);

        m1.fullName("Kiran","Vighne");

    }

    void fullName(String fName,String lname){
        String name = fName +" "+ lname;
        System.out.println(name);
    }
    void print(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}

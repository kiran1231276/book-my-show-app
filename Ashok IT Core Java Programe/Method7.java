public class Method7 {
    public static void main(String[] args) {

        Method7 m = new Method7();
        Customer c = new Customer();
        c.cId = 101;
        c.cName = "Kiran";
        c.gender = "Male";

        c.customerData(c);
    }
}

class Customer{
    int cId;
    String cName;
    String gender;

    void customerData(Customer c){
        System.out.println(c.cId+" "+c.cName+" "+c.gender);
    }
}
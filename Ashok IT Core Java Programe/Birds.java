public class Birds {
    int id;
    String name;
    void birdsData(Birds b1,Birds b2){
        System.out.println(b1.id+" "+b1.name);
        System.out.println(b2.id+" "+b2.name);
    }

    public static void main(String[] args) {

        Birds b = new Birds();

        Birds b1 = new Birds();
        b1.id = 101;
        b1.name = "Crow";

        Birds b2 = new Birds();
        b2.id = 102;
        b2.name = "Peacock";

        b.birdsData(b1,b2);
       // b1.birdsData(b1,b2);// same
       // b2.birdsData(b1,b2);// same
    }
}

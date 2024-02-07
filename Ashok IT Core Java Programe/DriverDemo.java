class Doctor1{
    int age;
    String name;
}
public class DriverDemo {
    void printData(Doctor1 d){
        System.out.println(d.age+" "+d.name);
    }

    public static void main(String[] args) {
        DriverDemo s = new DriverDemo();
        Doctor1 d = new Doctor1();
        d.age=28;
        d.name="kiran";
        s.printData(d);
    }
}

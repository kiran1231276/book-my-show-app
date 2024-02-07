public class Method14 {
    public static void main(String[] args) {

        Method14 m = new Method14();
        Employee1 e1 = m.getEmployeeData();
        System.out.println(e1.id+" "+e1.name+" "+e1.salary);
    }
    Employee1 getEmployeeData(){
        Employee1 e = new Employee1();
        e.id = 101;
        e.name = "Trupti";
        e.salary = 450000.0;

        return e;
    }
}
class Employee1{
    int id;
    String name;
    double salary;
}
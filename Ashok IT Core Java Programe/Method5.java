public class Method5 {
    public static void main(String[] args) {

        Employee emp = new Employee();
        emp.id = 101;
        emp.salary = 25000.0;

        emp.EmployeeData(emp);

    }
}

class Employee{
    int id;
    double salary;

    void EmployeeData(Employee emp){
        System.out.println(emp.id+" "+emp.salary);
    }
}

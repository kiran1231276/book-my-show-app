// Write a method which will give person object with data
public class Method10 {
    public static void main(String[] args) {

        Method10 m = new Method10();
        Person s = m.getPerson();
        System.out.println(s.id+" "+s.name+" "+s.age);
    }
    Person getPerson(){
        Person p= new Person();
        p.id = 101;
        p.name = "Kiran";
        p.age = 25;

        return p;
    }
}
class Person{
   int id;
   String name;
   int age;
}
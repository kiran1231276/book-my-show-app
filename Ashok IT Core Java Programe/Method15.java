// raju (101,raju,54)
// rani(1o2,rani,34)
// write a java method which will take id as input.based on id return person data

public class Method15 {
    public static void main(String[] args) {

        Method15 m = new Method15();
        Person1 p1 = m.m1(103);
        System.out.println(p1.id+" "+ p1.name+" "+p1.age);
    }
    Person1 m1(int id){
        Person1 p = new Person1();
        if(id == 101){
            p.id = 101;
            p.name = "raju";
            p.age = 54;
        } else if (id == 102) {
            p.id = 102;
            p.name = "rani";
            p.age = 34;
        }
        else {
            System.out.println("id is not found");
        }
        return p;
    }
}
class Person1{
    int id;
    String name;
    int age;
}

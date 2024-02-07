public class Method12 {
    public static void main(String[] args) {

        Method12 m = new Method12();
        Animal a1 = m.getAnimalData();
        System.out.println(a1.name+" "+a1.age+" "+a1.gender);
    }
    Animal getAnimalData(){
        Animal a = new Animal();
        a.name = "cat";
        a.age = 2;
        a.gender = "Female";

        return a;
    }
}
class Animal{
    String name;
    int age;
    String gender;
}
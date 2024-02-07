public class Method13 {
    public static void main(String[] args) {

        Method13 m = new Method13();
        Teacher t = m.getTeacherData();
        System.out.println(t.id+" "+t.name+" "+t.age);
    }
    Teacher getTeacherData(){
        Teacher t = new Teacher();
        t.id = 101;
        t.name = "Ram";
        t.age = 39;

        return t;
    }
}
class Teacher{
    int id;
    String name;
    int age;
}
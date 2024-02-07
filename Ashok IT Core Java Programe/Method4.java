// Write a java method to print data available in the Student object


public class Method4 {
    public static void main(String[] args) {

        Student1 student = new Student1();

        student.id = 101;
        student.name = "Kiran";
        student.gender = 'm';

        student.printStudentData(student);
    }

}

class Student1{
    int id;
    String name;
    char gender;

    void printStudentData(Student1 student){
        System.out.println(student.id+" "+student.name+" "+student.gender);
    }
}
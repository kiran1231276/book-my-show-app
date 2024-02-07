// write a method to return university data based on university id
public class University {
    int id;
    String name;
    public static void main(String[] args) {
        University u = new University();
        University u1 = u. getUniversityData(102);
        System.out.println(u1.id+" "+ u1.name);
    }
    University getUniversityData(int id){
        University u = new University();
        if(id == 101) {
            u.id = 101;
            u.name = "Oxford";
        }
        else if (id == 102){
            u.id = 102;
            u.name = "Stanford";
        }
        return u;
    }
}

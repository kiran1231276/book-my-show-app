public class Method11 {
    public static void main(String[] args) {

        Method11 m = new Method11();
        College c1 = m.getCollegeData();
        System.out.println(c1.id+" "+c1.name);

    }
    College getCollegeData(){
        College c = new College();
        c.id = 101;
        c.name = "VNMKV";

        return c;
    }
}
class College{
    int id;
    String name;
}
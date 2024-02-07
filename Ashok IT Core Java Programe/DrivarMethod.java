
class Driver1 {

    College1 m1() {

        College1 c = new College1();
        c.id = 101;
        c.name = "HITM";

        return c;
    }

    public static void main(String[] args) {
        Driver1 d = new Driver1();
        College1 c = d.m1();
        System.out.println(c.id + "--" + c.name);
    }

}

class College1 {
    int id;
    String name;
}


class Player{
    int id;
    String name;
    int age;
}
public class Method9 {
    public static void main(String[] args) {

        Method9 m = new Method9();
        Player p = new Player();
        p.id = 101;
        p.name = "Yogesh";
        p.age = 25;

        m.playerData(p);

    }
    void playerData(Player p){
        System.out.println(p.id+" "+p.name+" "+p.age);
    }
}

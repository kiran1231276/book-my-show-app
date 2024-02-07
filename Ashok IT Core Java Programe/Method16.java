// write a java method which will return player data based on playernumber
// 7 -dhoni
// 18 -kohli
//45- rohit
//
public class Method16 {
    public static void main(String[] args) {

        Method16 m = new Method16();
        Players p1 = m.getPlayersData(18);
        System.out.println(p1.number+" "+p1.name+" "+ p1.age);
    }
    Players getPlayersData(int number){
        Players p = new Players();
        if(number == 7){
            p.number = 7;
            p.name = "Dhoni";
            p.age = 45;
        }
        else if (number == 18) {
            p.number = 18;
            p.name = "Kohli";
            p.age = 36;
        }
        else if (number == 45) {
            p.number = 45;
            p.name = "Rohit";
            p.age = 37;
        }
        else {
            System.out.println("player is not found with given number");
        }

        return p;
    }
}
class Players{
    int number;
    String name;
    int age;
}
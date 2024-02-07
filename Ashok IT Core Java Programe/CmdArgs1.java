// sum of two numbers using cmd Args
public class CmdArgs1 {
    public static void main(String[] args) {

        System.out.println("Total cmd args :"+ args.length);
        String s1 = args[0];
        String s2 = args[1];

        System.out.println(Integer.parseInt(s1)+Integer.parseInt(s2));

    }
}

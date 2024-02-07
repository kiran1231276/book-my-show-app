public class String5 {
    public static void main(String[] args) {

        String s1 = "hello";
        String s2 = "llohe";


        s2 = s2.substring(3) + s2.substring(0, 3);
        System.out.println(s2);

        if(s1.equals(s2)){
            System.out.println("String is matched");
        }
        else{
            System.out.println("not matched");
        }
    }
}

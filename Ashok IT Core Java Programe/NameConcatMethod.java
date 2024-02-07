public class NameConcatMethod {

    String concatName(String s1,String s2){
        return s1+" "+s2;
    }
    public static void main(String[] args) {

        NameConcatMethod m = new NameConcatMethod();
        String s1 = "Kiran";
        String s2 = "Vighne";

        String s3= m.concatName(s1,s2);
        System.out.println(s3);
    }
}

public class StringDemo2 {
    public static void main(String[] args) {

        String str1 = new String("Trupti");
        String str2 = new String("Trupti");

        if(str1 == str2){
            System.out.println("Both are same");
        }
        else{
            System.out.println("Both are not same");
        }

        System.out.println(str1.equals(str2));
        System.out.println(str1.length());
    }
}

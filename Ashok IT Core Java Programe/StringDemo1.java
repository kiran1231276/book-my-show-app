public class StringDemo1 {
    public static void main(String[] args) {

        String str1 = "Kiran";
        String str2 = "Kiran"; // if in small letter then it is not same

        if(str2 == str1){
            System.out.println("Both are same");
        }
        else{
            System.out.println("Both are not save");
        }

        System.out.println(str1.equals(str2));
    }

}

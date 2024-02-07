public class StringAllProgramme {
    public static void main(String[] args) {

        /*String s1 = "brgqraoput";
        char ch1 = 'a';

        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == ch1) {
                    count++;
                }
        }
        System.out.println("Occurance of: " + ch1 + " is: " + count);*/

        // System.out.println("======================================");

        /*String s2 = "truptilaxmansoge";

        for (int i = 0; i < s2.length(); i++) {
            int count = 0;
            for (int j = 0; j < s2.length(); j++) {
                if (s2.charAt(i) == s2.charAt(j)) {
                    count++;
                }
            }
            System.out.println("Occurance of: "+s2.charAt(i)+" is: "+count);

            // System.out.println("======================================");
        }*/

        String s1 = "java";
        String s2 = "";

        for(int i=s1.length()-1;i>=0;i--){
            s2 = s2+s1.charAt(i);
        }
        System.out.println(s2);
    }
}



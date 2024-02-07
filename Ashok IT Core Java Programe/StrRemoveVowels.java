public class StrRemoveVowels {
    public static void main(String[] args) {

        // 1 st Approach

        String str = "Hello,I Love my india";

        str = str.replaceAll("[aeiouAEIOU]", "");
        System.out.println(str);

        // 2 nd Approach

        String str1 = "How,are you today?";
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str1.length(); i++) {

            char currentChar = str1.charAt(i);

            if (currentChar != 'a' && currentChar != 'e' && currentChar != 'i' && currentChar != 'o' && currentChar != 'u' && currentChar != 'A' && currentChar != 'E' && currentChar != 'I' && currentChar != 'O' && currentChar != 'U') {
                sb.append(currentChar);
            }
        }

        String str2 = sb.toString();
        System.out.println("String without vowels: " + str2);
    }
}



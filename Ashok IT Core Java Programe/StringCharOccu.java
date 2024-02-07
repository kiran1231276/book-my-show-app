// Write a java programme to count the total number of occurrence in a given character in a string
public class StringCharOccu {
    public static void main(String[] args) {

        // 1 st approach

        String str = "java";
        char ch = 'a';
        int count = 0;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ch){
                count++;
            }
        }

        System.out.println("Occurrence of '" + ch + "' in the string '" + str + "': " + count);

        // 2 nd Approach
/*
        String str1 = "javabykiranvighnev";
        char cha = 'v';
        int c = 0;

        char[] arr1 = str1.toCharArray();

        for(int i=0;i< arr1.length;i++){
            if(arr1[i] == cha){
                c++;
            }
        }

        System.out.println("Occurrence of '" + cha + "' in the string '" + str1 + "': " + c);*/

        String str1 = "javaisahardlanguage";
        char cha ='a';
        int c = 0;

        char[] chars = str1.toCharArray();

        for(int i=0;i<chars.length;i++){
            if(chars[i] == cha){
                c++;
            }
        }

        System.out.println("Occurance of"+cha+"in the string"+str1+":"+c);
    }
}

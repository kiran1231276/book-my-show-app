public class CharINString {
    public static void main(String[] args) {

        String s = "java";
        char c ='a';
        char[] ch = s.toCharArray();

        System.out.println(ch);
        int count=0;
        for(int i=0;i< ch.length;i++){
            if(c==ch[i]){
                count++;
            }

        }
        System.out.println("Occurance of "+c+" in String is "+count);
    }
}

public class StringNoOfWords {
    public static void main(String[] args) {

        // 1 st Approach

        String str = "I love java programming";

        String [] arr = str.split(" ");

        System.out.println(arr.length);

        // 2 nd Approach

        String str1 = "My name is a kiran";

        String arr1[] = str1.split(" ");
        int count = 0;

        for (int i=0;i< arr1.length;i++){
            if(!arr1[i].equals(" ")){
                count++;
            }
        }

        System.out.println(count);
    }
}

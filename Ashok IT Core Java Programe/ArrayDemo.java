public class ArrayDemo {
    public static void main(String[] args) {

        int[] arr = new int[5];

        // int[] arr = {101,102,103,104,105};

        arr[0] = 101;
        arr[1] = 102;
        arr[2] = 103;
        arr[3] = 104;
        arr[4] = 105;

        System.out.println(arr.length);

        System.out.println(arr[3]);
        System.out.println(arr[4]);

        for(int i=0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

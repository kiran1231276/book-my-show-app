public class MaxMethod {

    int mxElement(int[] arr) {

        int max = arr[0]; // Initialize max with the first element of the array
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        MaxMethod m1 = new MaxMethod();
        int[] arr = {2, 5, 6, 4, 3};
        int m = m1.mxElement(arr);

        System.out.println(m);
    }
}

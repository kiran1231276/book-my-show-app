public class MinAndMax {
    public static void main(String[] args) {

        int[] arr = {189,156,119,194,138,190,128,167,145,176};

        int min=arr[0];
        int max=arr[0];

        for(int i=0;i< arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            } else if (arr[i]<min) {
                min=arr[i];
            }
        }
        System.out.println(min);
        System.out.println(max);
    }
}

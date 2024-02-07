// find the sum of two number is 9

public class ArrayDemo4 {
    public static void main(String[] args) {

        int arr[] = {4,3,8,5,7,1,9,3,7,2,6};

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j] == 9){
                    System.out.println(arr[i]+","+arr[j]);
                }
            }
        }
    }
}

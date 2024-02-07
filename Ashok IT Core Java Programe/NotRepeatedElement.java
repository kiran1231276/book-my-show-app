public class NotRepeatedElement {
    public static void main(String[] args) {

        int[] arr = {2,3,7,9,4,8,4,2,5,6,7};

        for(int i=0;i< arr.length;i++){

            int count=0;
            for(int j=0 ;j< arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count==1){
                System.out.print(arr[i]);

            }
        }
    }
}

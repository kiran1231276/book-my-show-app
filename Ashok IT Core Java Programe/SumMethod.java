public class SumMethod {

    int add(int a,int b){
        return a+b;
    }
    public static void main(String[] args) {

        int a= 9;
        int b= 10;
        SumMethod s = new SumMethod();
        int i = s.add(a,b);
        System.out.println(i);
    }
}

public class SwapNumber1 {
    public static void main(String[] args) {

        int num1 = 29;
        int num2 = 12;

        System.out.println("Before swapping: num1 = " + num1 + ", num2 = " + num2);

        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;

        System.out.println("After swapping: num1 = " + num1 + ", num2 = " + num2);

    }
}

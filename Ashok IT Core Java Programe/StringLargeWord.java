public class StringLargeWord {
    public static void main(String[] args) {
        String s = "my name is kiran";
        String[] arr = s.split("\\s+");

        String max = arr[0]; // Initialize max with the first word

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() > max.length()) {
                max = arr[i]; // Update max if a longer word is found
            }
        }

        System.out.println("Longest word: " + max);
    }
}

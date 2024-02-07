package in.ashokit;

import java.util.Random;

public class BookStore {
	public static void main(String[] args) {

		BookStore b = new BookStore();
		int c = b.sum(10, 20);
		System.out.println(c);
		
		BookStore.generateRandomPwd();

	}

	private static String generateRandomPwd() {
		Random random = new Random();

		String text = "QWERTYUIOPLKJHGFDSAZXCVBNM1234567890";

		StringBuilder sb = new StringBuilder();

		int pwdLength = 6;

		for (int i = 1; i <= pwdLength; i++) {
			int index = random.nextInt(text.length());
			sb.append(text.charAt(index));
		}

		System.out.println("Random Text :: " + sb.toString());

		return sb.toString();
	}

	public int sum(int a, int b) {
		int sum = a + b;
		return sum;
	}
}

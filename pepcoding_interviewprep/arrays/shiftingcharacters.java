package arrays;

import java.util.Scanner;

public class shiftingcharacters {
	public static String shiftingLetters(String s, int[] shifts) {
		// write your code here.
		for (int i = shifts.length - 2; i >= 0; i--) {
			shifts[i] += shifts[i + 1];
			shifts[i] = shifts[i] % 26;
		}
		char[] c = new char[shifts.length];
		for (int i = shifts.length - 1; i >= 0; i--) {
			int a = (s.charAt(i) - 'a');
			int b = (a + shifts[i]);
			b = b % 26;
			char d = (char) (b + (int) 'a');
			c[i] = d;
		}
		String r = new String(c);
		return r;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();

		int N = sc.nextInt();

		int[] shifts = new int[N];

		for (int i = 0; i < N; i++) {
			shifts[i] = sc.nextInt();
		}

		System.out.println(shiftingLetters(S, shifts));
	}

}

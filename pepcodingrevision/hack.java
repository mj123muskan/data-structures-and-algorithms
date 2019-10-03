
import java.util.Scanner;

public class hack {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		for (int i = 0; i < n; ++i) {

			Scanner scn1 = new Scanner(System.in);

			String pattern = scn1.next();

			String spell = scn1.next();

			issubstring(spell, pattern);

		}
	}

	public static void issubstring(String spell, String pattern) {
		int f = 0;
		for (int i = 0; i < spell.length(); i++) {

			for (int j = i ; j < spell.length() + 1; ++j) {

				if (spell.substring(i, j) == pattern) {

					System.out.println("YES");
					f = 1;
					break;

				}

			}

		}
		if (f == 0)
			System.out.println("NO");
	}
}

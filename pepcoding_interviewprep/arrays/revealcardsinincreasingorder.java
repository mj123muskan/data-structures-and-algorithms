package arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class revealcardsinincreasingorder {

	public static int[] deckRevealedIncreasing(int[] deck) {
		int[] res = new int[deck.length];
		// write code here
		LinkedList<Integer> q = new LinkedList<>();
		for (int i = 0; i < deck.length; i++) {
			q.addLast(i);
		}
		Arrays.sort(deck);
		for (int i = 0; i < deck.length; i++) {
			int y = q.removeFirst();
			res[y] = deck[i];
			if (q.size() == 0) {
				break;
			}
			int x = q.removeFirst();
			q.addLast(x);
		}
		return res;
	}
	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int[] ans = deckRevealedIncreasing(arr);
		for (int val : ans) {
			System.out.print(val + " ");
		}
	}

}

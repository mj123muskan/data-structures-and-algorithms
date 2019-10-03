package linkedlist;

import java.util.*;
import java.util.Scanner;

public class nextwarmerday {

	public static int[] findWarmerTemp(int ht[]) {
		// Write your code here only
		Stack<Integer> s = new Stack<>();
		int[] ser = new int[ht.length];

		ser[ht.length - 1] = 0;

		s.push(ht.length - 1);
		for (int i = ht.length - 2; i >= 0; i--) {
			while (s.size() > 0 && ht[s.peek()] <= ht[i]) {
				s.pop();
			}
			if (s.size() == 0) {
				ser[i] = 0;
			} else {
				ser[i] = s.peek() - i;

			}
			s.push(i);
		}
		return ser;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp[] = new int[n];
		for (int i = 0; i < n; i++)
			temp[i] = sc.nextInt();
		int res[] = findWarmerTemp(temp);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}

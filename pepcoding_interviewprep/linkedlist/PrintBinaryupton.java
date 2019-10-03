package linkedlist;

import java.util.*;
import java.util.Scanner;

public class PrintBinaryupton {

	public static void getBinary(int n) {
		// write your code here
		LinkedList<pair> q = new LinkedList<>();
		pair p = new pair(1, "1");
		q.add(p);

		while (q.size() != 0) {
			pair r = q.removeFirst();

			if (r.num > n) {
				continue;
			}
			System.out.print(r.s + " ");
			pair l = new pair(2 * r.num, r.s + '0');
			pair ri = new pair(2 * r.num + 1, r.s + '1');
			q.addLast(l);
			q.addLast(ri);

		}

	}

	public static class pair {
		int num;
		String s;

		public pair(int n, String ss) {
			num = n;
			s = ss;
		}

	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		getBinary(n);

	}
}

package linkedlist;

import java.util.*;
import java.util.Scanner;

public class maxrectangleareainhistogram {
	public static int maxRectArea(int[] ht) {
		// write your code here
		Stack<Integer> s = new Stack<>();
		int[] ser = new int[ht.length];
		int[] sel = new int[ht.length];
		ser[ht.length - 1] = ht.length;
		sel[0] = -1;
		s.push(ht.length - 1);
		for (int i = ht.length - 2; i >= 0; i--) {
			while (s.size() > 0 && ht[s.peek()] >= ht[i]) {
				s.pop();
			}
			if (s.size() == 0) {
				ser[i] = ht.length;
			} else {
				ser[i] = s.peek();

			}
			s.push(i);
		}
		s = new Stack<>();
		s.push(0);
		for (int i = 1; i < ht.length; i++) {
			while (s.size() > 0 && ht[s.peek()] >= ht[i]) {
				s.pop();
			}
			if (s.size() == 0) {
				sel[i] = -1;
			} else {
				sel[i] = s.peek();

			}
			s.push(i);
		}
		display(ser);
		display(sel);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < ht.length; i++) {
			int area = (ser[i] - sel[i] - 1) * ht[i];
			if (area > max) {
				max = area;
			}
		}
		return max;

	}

	public static void display(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int h = scn.nextInt();
		int height[] = new int[h];
		for (int i = 0; i < h; i++) {
			height[i] = scn.nextInt();
		}
		System.out.println(maxRectArea(height));
	}
}

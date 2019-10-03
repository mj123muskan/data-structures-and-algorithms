package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ssolutionn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n=scn.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(11);
		list.add(2);
		System.out.println(splitthearray(list));

	}

	public static int gcd(int x, int y) {
		if (y == 0) {
			return x;
		}
		return gcd(y, x % y);
	}

	public static int splitthearray(List<Integer> a) {
		return minpart(a, 0, a.size() - 1);
	}

	private static int minpart(List<Integer> a, int i, int j) {
		if (i == j) {
			return 1;
		}
		if (i != j) {
			return gcd(a.get(i), a.get(j));
		}

		int gmin = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int min = minpart(a, i, k) + 1 + minpart(a, k + 1, j);
			if (min < gmin) {
				gmin = min;
			}
		}
		return gmin;
	}

}

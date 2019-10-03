package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		// int n = scn.nextInt();
		// int[] a = new int[n];
		// for (int i = 0; i < n; i++) {
		// a[i] = scn.nextInt();
		//
		// }
		// int k=scn.nextInt();
		// Equilibrium_point(a, n);
		// Max_sum_increasing_subsequence(a,n);
		// Zigzag_array(a,n);
		// int d=scn.nextInt();
		// findpair(a,n,d);
		// sort01(a, n);
		// sort012(a,n);
		// RearrangePositiveNegative(a,n);
		// partitioninksubsets(a,n,k,0,new ArrayList<>());
		// String s=scn.next();
		// System.out.println(mpc(s,0,s.length()-1));
		// mpctabulated(s);
		// kadane(a);
		// ArrayList<Node> c = constructbst(1, 3);
		// System.out.println(c.size());
		int[] arr = { 2, 3, 10, 6, 4, 8, 1 };
		StockBuySell1time(arr);

	}

	public static void StockBuySell1time(int[] arr) {
		int minsofar = arr[0];
		int maxdiff = 0;
		for (int i = 1; i < arr.length; i++) {
			int diff = arr[i] - minsofar;
			if (diff > maxdiff) {
				maxdiff = diff;
			}
			if (arr[i] < minsofar) {
				minsofar = arr[i];
			}
		}
		System.out.println(maxdiff);

	}

	private static ArrayList<Node> constructbst(int start, int end) {
		ArrayList<Node> n = new ArrayList<>();
		if (start > end) {
			ArrayList<Node> nn = new ArrayList<>();
			nn.add(null);
			return nn;
		}

		for (int i = start; i <= end; i++) {
			ArrayList<Node> leftl = constructbst(start, i - 1);
			ArrayList<Node> rightl = constructbst(i + 1, end);

			for (int j = 0; j < leftl.size(); j++) {
				for (int k = 0; k < rightl.size(); k++) {
					Node left = leftl.get(j);
					Node right = rightl.get(k);
					Node node = new Node(i, left, right);
					n.add(node);
				}
			}
		}
		return n;
	}

	private static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			left = left;
			right = right;
		}
	}

	private static void kadane(int[] a) {
		// TODO Auto-generated method stub

		int csum = a[0];
		int osum = a[0];
		for (int i = 1; i < a.length; i++) {
			if (csum < 0) {
				csum = a[i];
			} else {
				csum += a[i];
			}

			if (csum > osum) {
				osum = csum;
			}
		}
		System.out.println(osum);

	}

	private static void mpctabulated(String s) {
		boolean[][] palindrome = new boolean[s.length()][s.length()];
		int[][] mpc = new int[s.length()][s.length()];
		char[] c = s.toCharArray();
		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0, j = i + gap; j < s.length(); i++, j++) {
				if (gap == 0) {
					palindrome[i][j] = true;
				} else if (gap == 1) {
					if (c[i] == c[j]) {
						palindrome[i][j] = true;
					}
				} else {
					if (c[i] == c[j] && palindrome[i + 1][j - 1] == true) {
						palindrome[i][j] = true;
					}

				}
			}
		}

		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0, j = i + gap; j < s.length(); i++, j++) {
				if (gap == 0) {
					mpc[i][j] = 0;
				} else if (gap == 1) {
					mpc[i][j] = palindrome[i][j] == true ? 0 : 1;
				} else if (palindrome[i][j] == false) {
					int min = Integer.MAX_VALUE;
					for (int cp = i; cp < j; cp++) {
						int fp = mpc[i][cp];
						int sp = mpc[cp + 1][j];
						int mycost = sp + fp + 1;
						if (mycost < min) {
							min = mycost;
						}
					}
					mpc[i][j] = min;

				}
			}
		}
		System.out.println(mpc[0][s.length() - 1]);

	}

	private static int mpc(String s, int si, int ei) {
		if (ispalindrome(s, si, ei)) {
			return 0;
		}
		// TODO Auto-generated method stub
		int mincost = Integer.MAX_VALUE;
		for (int i = si; i < ei; i++) {
			int c1 = mpc(s, si, i);
			int c2 = mpc(s, i + 1, ei);
			int mycost = c1 + c2 + 1;
			if (mycost < mincost) {
				mincost = mycost;
			}
		}
		return mincost;
	}

	private static boolean ispalindrome(String s, int si, int ei) {
		int left = si;
		int right = ei;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	private static void partitioninksubsets(int[] a, int n, int k, int vidx, ArrayList<Integer> psf) {
		if (k == 1) {
			for (int i = vidx; i < n; i++) {
				psf.add(a[i]);
			}
			System.out.println(psf);
			return;
		}

		// TODO Auto-generated method stub
		for (int i = vidx; i < n - 1; i++) {

			for (int j = vidx; j <= i; j++) {
				psf.add(a[j]);
			}
			psf.add(-1);
			partitioninksubsets(a, n, k - 1, vidx + i + 1, psf);

			for (int j = vidx; j <= i; j++) {
				psf.remove(psf.size() - 1);
			}

		}
	}

	private static void RearrangePositiveNegative(int[] a, int n) {
		// TODO Auto-generated method stub
		int j = -1;

		for (int i = 0; i < n; i++) {
			if (a[i] >= 0) {
				j++;
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		for (int k = 0; k < n; k++) {

			System.out.print(a[k] + " ");
		}
		System.out.println();
		int neg = j + 1;
		for (int i = 0; i <= j; i++) {
			if (i % 2 != 0 && neg < n && a[neg] < 0) {
				int t = a[i];
				a[i] = a[neg];
				a[neg] = t;
				neg++;

			}
			for (int k = 0; k < n; k++) {

				System.out.print(a[k] + " ");
			}
			System.out.println();
		}
		for (int k = 0; k < n; k++) {

			System.out.print(a[k] + " ");
		}
	}

	private static void sort012(int[] a, int n) {
		// TODO Auto-generated method stub
		int lo = 0;
		int hi = n - 1;
		int i = 0;
		while (i <= hi) {
			if (a[i] == 0) {
				int t = a[i];
				a[i] = a[lo];
				a[lo] = t;
				i++;
				lo++;
			} else if (a[i] == 1) {
				i++;
			} else if (a[i] == 2) {
				int t = a[i];
				a[i] = a[hi];
				a[hi] = t;
				hi--;
			}
		}

		for (int k = 0; k < n; k++) {

			System.out.print(a[k] + " ");
		}

	}

	private static void sort01(int[] a, int n) {
		// TODO Auto-generated method stub
		int lo = 0;
		int hi = n - 1;

		while (lo < hi) {

			if (a[lo] == 1) {
				int t = a[hi];
				a[hi] = a[lo];
				a[lo] = t;
				hi--;
			} else {
				lo++;
			}

		}

		for (int k = 0; k < n; k++) {

			System.out.print(a[k] + " ");
		}

	}

	private static void findpair(int[] a, int n, int d) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(a[i]);
		}
		for (int k : set) {
			if (set.contains(k + d)) {
				System.out.println(k + " " + (k + d));
			}
		}
	}

	private static void Zigzag_array(int[] a, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n - 1; i++) {
			if (i % 2 == 0) {
				if (a[i] > a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}

			if (i % 2 != 0) {
				if (a[i] < a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}

		}

		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");

		}
	}

	private static void Max_sum_increasing_subsequence(int[] a, int n) {
		// TODO Auto-generated method stub

		int[] strg = new int[n];
		strg[0] = a[0];
		int max = a[0];
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (a[j] < a[i] && strg[j] > strg[i]) {
					strg[i] = strg[j];
				}
			}
			strg[i] += a[i];
			if (strg[i] > max) {
				max = strg[i];
			}
		}
		System.out.println(max);

	}

	private static void Equilibrium_point(int[] a, int n) {
		// TODO Auto-generated method stub

		int rightsum = 0;
		for (int i = 0; i < n; i++) {
			rightsum += a[i];

		}

		int f = 0;
		int leftsum = 0;
		for (int i = 0; i < n; i++) {
			rightsum -= a[i];
			if (leftsum == rightsum) {
				f = 1;
				System.out.println(i);
				break;
			}
			leftsum += a[i];

		}

		if (f == 0) {
			System.out.println("-1");
		}

	}

}

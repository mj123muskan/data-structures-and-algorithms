package mar19;

import java.util.Scanner;

public class dp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
		// LIStabulated(arr);
		// LISmemoised(arr);
		// int[] a = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
		// int[] strg = new int[a.length];
		// System.out.println(rodcuttingmemoised(a, 8, strg));
		// rodcuttingtabulated(a);
		// Scanner scn=new Scanner(System.in);
		// int n=scn.nextInt();
		// int []arr=new int[n];
		// for(int i=0;i<n;i++)
		// {
		// arr[i]=scn.nextInt();
		// }
		// LIStabulated(arr);
		System.out.println(binomialcoeff(4, 0, new int[5][1]));
	}

	public static void LIStabulated(int[] arr) {
		int[] lis = new int[arr.length];
		// String[] plis = new String[arr.length];

		int omax = 0;
		// String max = "";

		lis[0] = 1;
		// plis[0] = arr[0] + "";
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j <= i - 1; j++) {
				if (arr[j] < arr[i]) {
					if (lis[j] > lis[i]) {
						lis[i] = lis[j];
						// plis[i] = plis[j];
					}
				}
			}
			lis[i] += 1;
			// plis[i] = plis[i] + " " + arr[i];
			if (lis[i] > omax) {
				omax = lis[i];
				// max = plis[i];
			}
		}

		System.out.println(omax);
		// System.out.println(max);
	}

	public static void LISmemoised(int[] arr) {
		int omax = 0;
		int[] qb = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int lisendingati = LISENDINGATPOINT(arr, qb, i);

			if (lisendingati > omax) {
				omax = lisendingati;
			}
		}
		System.out.println(omax);
	}

	private static int LISENDINGATPOINT(int[] arr, int[] qb, int point) {
		if (point == 0) {
			return 1;
		}
		if (qb[point] != 0) {
			return qb[point];
		}
		int lisendingatpoint = 0;
		for (int j = 0; j < point; j++) {
			if (arr[j] < arr[point]) {
				int lisendingatj = LISENDINGATPOINT(arr, qb, j);
				if (lisendingatj > lisendingatpoint) {
					lisendingatpoint = lisendingatj;
				}

			}
		}
		qb[point] = lisendingatpoint + 1;
		return lisendingatpoint + 1;
	}

	public static void rodcuttingtabulated(int[] arr) {
		int[] strg = new int[arr.length];
		String[] path = new String[arr.length];

		strg[0] = 0;
		strg[1] = arr[1];

		path[0] = "";
		path[1] = "1";

		for (int i = 2; i < arr.length; i++) {
			strg[i] = arr[i];
			path[i] = arr[i] + "";

			int left = 1;
			int right = i - 1;

			while (left <= right) {
				if (strg[left] + strg[right] > strg[i]) {
					strg[i] = strg[left] + strg[right];
					path[i] = path[left] + path[right];
				}

				left++;
				right--;
			}
		}

		System.out.println(strg[arr.length - 1]);
		System.out.println(path[arr.length - 1]);

	}

	public static int rodcuttingmemoised(int[] arr, int rl, int[] strg) {
		if (rl == 0) {
			return 0;
		}
		if (strg[rl] != 0) {
			return strg[rl];
		}
		int msp = arr[rl];
		int left = 1;
		int right = rl - 1;
		while (left <= right) {
			int lmsp = rodcuttingmemoised(arr, left, strg);
			int rmsp = rodcuttingmemoised(arr, right, strg);

			int tmsp = lmsp + rmsp;
			if (tmsp > msp) {
				msp = tmsp;
			}

			left++;
			right--;
		}
		strg[rl] = msp;
		return msp;
	}

	public static int binomialcoeff(int n, int k, int[][] strg) {//memoised
		if (k == 0 || k == n) {
			return 1;
		}
		if (strg[n][k] != 0) {
			return strg[n][k];
		}
		strg[n][k] = binomialcoeff(n - 1, k - 1, strg) + binomialcoeff(n - 1, k, strg);
		return binomialcoeff(n - 1, k - 1, strg) + binomialcoeff(n - 1, k, strg);
	}

}

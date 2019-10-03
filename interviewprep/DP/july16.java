package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class july16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		// int n = scn.nextInt();
		// int[] arr = new int[n];
		// // int [] fre=new int [arr.length];
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = scn.nextInt();
		// // fre[i]=scn.nextInt();
		// }
		// int x = scn.nextInt();
		// int y = scn.nextInt();
		// int k = scn.nextInt();
		// minjumpsiterative(arr);
		// npersonsingleorpair(arr.length);
		// MaxSumBitonicSS(arr, arr.length);
		// OptimalBinarySearch(arr,fre);
		// int n = scn.nextInt();
		// int m=scn.nextInt();
		// NumericKeypad(n);
		// NoConsecutive1s(n);
		// TilingProblem(n,m);
		// System.out.println(PaintersPartition(arr, k, 0, new int[arr.length +
		// 1][k + 1]));
		// LinearEquation(arr,n,k);
		// String s = scn.next();
		// String p=scn.next();
		// WildcardMatching(s,p);
		// ProbabilityOfKnights(n, x, y, k);
		// FindWater(x,y,k);
		// char[] s = scn.next().toCharArray();
		// char[] p = scn.next().toCharArray();
		// char[] d = scn.next().toCharArray();
		// BooleanParenthisation(s, p);
		// RemoveMins(arr, n);
		// LCSofTriplet(s, p, d);
		// FriendsPairing(n);
		// PartitionIntoSubsets(n, k);
		// lis(arr);

		// minjumpsmethod2(arr);
		// System.out.println(FriendsPairing(4));
		// ugly(n);
		// String[] a = new String[n];
		// for (int i = 0; i < n; i++) {
		// a[i] = scn.next();
		// }
		//
		// GroupWordsofSameSetTogether(a, n);
		// GenerateAllBinaryStrings(s, 0);
		// SmallestWindow(s);
		System.out.println(isinterleaving("XYf", "WZ", "WZXY"));
	}

	private static boolean isinterleaving(String a, String b, String c) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = 0;
		int k = 0;
		while (k < c.length()) {
			
			if ((i < a.length()) && (c.charAt(k) == a.charAt(i))) {
				i++;
			} else
			if ((j < b.length()) && (c.charAt(k) == b.charAt(j))) {
				j++;
			}else
			{
				return false;
			}
			k++;
		}
		if (i == a.length() && j == b.length()) {
			return true;
		}else
		{
		return false;
		}
	}

	private static void SmallestWindow(String s) {
		// TODO Auto-generated method stub

		HashMap<Character, Integer> M = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			M.put(s.charAt(i), 1);
		}
		System.out.println(M.size());

	}

	private static void GenerateAllBinaryStrings(String s, int i) {
		// TODO Auto-generated method stub
		if (i == s.length()) {
			System.out.println(s);
			return;
		}

		if (s.charAt(i) != '?') {
			GenerateAllBinaryStrings(s, i + 1);
		} else {
			String k = s.substring(0, i);
			String h = s.substring(i + 1, s.length());
			String f = k + "0" + h;
			String t = k + "1" + h;
			GenerateAllBinaryStrings(f, i + 1);
			GenerateAllBinaryStrings(t, i + 1);
		}

	}

	private static void GroupWordsofSameSetTogether(String[] a, int n) {
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String key = getkey(a[i]);
			if (map.containsKey(key)) {
				ArrayList<Integer> g = map.get(key);
				g.add(i);
				map.put(key, g);
			} else {
				ArrayList<Integer> g = new ArrayList<>();
				g.add(i);
				map.put(key, g);
			}
		}

		ArrayList<String> keys = new ArrayList<>(map.keySet());
		for (String k : keys) {
			ArrayList<Integer> L = map.get(k);
			for (Integer J : L) {
				System.out.print(a[J] + " ");
			}
			System.out.println();

		}

	}

	private static String getkey(String s) {
		int[] a = new int[26];
		String k = "";
		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				k += (i + "a");
			}
		}
		return k;
	}

	private static void ugly(int n) {
		// TODO Auto-generated method stub
		int[] a = new int[n];
		a[0] = 1;
		int i2 = 0, i3 = 0, i5 = 0;
		int nm2 = 0;
		int nm3 = 0;
		int nm5 = 0;
		int next = 0;
		nm2 = a[i2] * 2;
		nm3 = a[i3] * 3;
		nm5 = a[i5] * 5;

		for (int i = 1; i < n; i++) {
			next = Math.min(nm2, Math.min(nm3, nm5));
			a[i] = next;
			if (next == nm2) {
				i2 = i2 + 1;
				nm2 = a[i2] * 2;

			} else if (next == nm3) {
				i3 = i3 + 1;
				nm3 = a[i3] * 3;

			} else if (next == nm5) {
				i5 = i5 + 1;
				nm5 = a[i5] * 5;

			}
		}

		System.out.println(next);

	}

	// private static void minjumpsmethod2(int[] arr) {
	// // TODO Auto-generated method stub
	//
	// int []strg=new int[arr.length];
	// strg[0]=0;
	// for(int i=1;i<arr.length;i++)
	// {
	// strg[i]=Integer.MAX_VALUE;
	// for(int j=0;j<i;j++)
	// {
	// if(i==j+arr[j] && )
	// }
	// }
	// }

	private static void PartitionIntoSubsets(int n, int k) {
		// TODO Auto-generated method stub
		int[][] a = new int[n + 1][k + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i && j <= k; j++) {
				if (i == j || j == 1) {
					a[i][j] = 1;
				} else {
					a[i][j] = a[i - 1][j - 1] + j * a[i - 1][j];
				}
			}
		}

		System.out.println(a[n][k]);

	}

	// private static void FriendsPairing(int n) {//iterative
	// int[] strg = new int[n + 1];
	//
	// strg[1] = 1;
	// strg[2] = 2;
	// for (int i = 3; i <= n; i++) {
	// strg[i] = strg[i - 1] + (i - 1) * strg[i - 2];
	// }
	//
	// System.out.println(strg[n]);
	//
	// }
	private static int FriendsPairing(int n) // recurive
	{
		if (n <= 2) {
			return n;
		}

		int x = FriendsPairing(n - 1) + (n - 1) * FriendsPairing(n - 2);
		return x;
	}

	private static void LCSofTriplet(char[] s, char[] p, char[] d) {
		int[][][] a = new int[s.length + 1][p.length + 1][d.length + 1];
		for (int i = s.length - 1; i >= 0; i--) {
			for (int j = p.length - 1; j >= 0; j--) {
				for (int k = d.length - 1; k >= 0; k--) {
					if (s[i] == p[j] && s[i] == d[k]) {
						a[i][j][k] = a[i + 1][j + 1][k + 1] + 1;
					} else {
						a[i][j][k] = Math.max(a[i][j][k + 1], Math.max(a[i + 1][j][k], a[i][j + 1][k]));
					}
				}
			}
		}
		System.out.println(a[0][0][0]);
	}

	private static void RemoveMins(int[] a, int n) {
		int len = 0;
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int j = i; j < n; j++) {
				min = Math.min(min, a[j]);
				max = Math.max(max, a[j]);
				if (2 * min <= max) {
					break;
				}

				len = Math.max(len, j - i + 1);
			}
		}

		System.out.println(n - len);

	}

	private static void BooleanParenthisation(char[] s, char[] p) {
		// TODO Auto-generated method stub
		int[][] t = new int[s.length][s.length];
		int[][] f = new int[s.length][s.length];
		for (int i = 0, j = 0; j < s.length; j++, i++) {
			if (s[i] == 'T') {
				t[i][j] = 1;
				f[i][j] = 0;
			} else {
				t[i][j] = 0;
				f[i][j] = 1;
			}

		}

		for (int gap = 1; gap < s.length; gap++) {
			for (int i = 0, j = i + gap; j < s.length; i++, j++) {
				for (int k = i; k < j; k++) {
					int leftrue = t[i][k];
					int righttrue = t[k + 1][j];
					int leftfalse = f[i][k];
					int rightfalse = f[k + 1][j];

					int total = leftrue * righttrue + leftrue * rightfalse + leftfalse * righttrue
							+ leftfalse * rightfalse;
					if (p[k] == '|') {
						t[i][j] += total - (leftfalse * rightfalse);
						f[i][j] += (leftfalse * rightfalse);
					} else if (p[k] == '&') {
						t[i][j] += (righttrue * leftrue);
						f[i][j] += total - (righttrue * leftrue);
					} else if (p[k] == '^') {
						t[i][j] += leftrue * rightfalse + righttrue * leftfalse;
						f[i][j] += leftrue * righttrue + leftfalse * rightfalse;

					}
				}

			}
		}
		System.out.println(t[0][s.length - 1]);
	}

	public static void lis(int[] arr) {
		int[] box = new int[arr.length];
		box[0] = 1;
		int omax = 0, idx = -1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					box[i] = Math.max(box[i], box[j]);
				}
			}
			box[i] += 1;
			if (box[i] > omax) {
				omax = box[i];
				idx = i;
			}
		}
		System.out.println(omax);
		System.out.println(idx);
		// findpath(arr, idx, box, " " + arr[idx], box[idx]);
		findpath(arr, idx, box, "");
	}

	// private static void findpath(int[] arr, int idx, int[] box, String s, int
	// num) {
	// if (num == 1) {
	// System.out.println(s);
	// return;
	// }
	// for (int i = 0; i < idx; i++) {
	// if (box[i] == num - 1 && arr[i] < arr[idx]) {
	// findpath(arr, i, box, s += arr[i]+" ", num - 1);
	// }
	// }
	// }
	//
	public static class pair {
		int num = 0;
		int index = -1;
		String psf = "";
	}

	private static void findpath(int[] arr, int idx, int[] box, String s) {
		LinkedList<pair> stack = new LinkedList<>();
		HashSet<Integer> processed = new HashSet<>();
		display(arr);
		display(box);
		ArrayList<String> results = new ArrayList<>();
		// for (int i = idx; i >= 1; i--) {
		pair mypair = new pair();
		mypair.index = idx;
		mypair.num = box[idx];
		mypair.psf = arr[idx] + " ";
		stack.addFirst(mypair);
		while (stack.size() != 0) {
			pair rp = stack.removeFirst();

			if (rp.num == 1) {
				System.out.println(rp.psf);
				continue;
			}

			// s += arr[rp.index] + " ";

			ArrayList<Integer> less = new ArrayList<>();

			for (int j = 0; j < rp.index; j++) {
				if (arr[j] < arr[rp.index] && box[j] == rp.num - 1) {
					less.add(j);
				}
			}

			for (int l : less) {
				pair nbrpair = new pair();
				nbrpair.num = rp.num - 1;
				nbrpair.index = l;
				nbrpair.psf = rp.psf + " " + arr[nbrpair.index];
				stack.addFirst(nbrpair);
			}
		}

	}

	private static void FindWater(int n, int row, int col) {
		double[][] dp = new double[row + 1][row + 1];
		dp[1][1] = n;

		for (int r = 1; r <= row; r++) {
			for (int c = 1; c <= r; c++) {
				if (r < row && dp[r][c] > 1) {
					double spare = dp[r][c] - 1;
					dp[r][c] = 1;
					dp[r + 1][c] += spare / 2;
					dp[r + 1][c + 1] += spare / 2;
				}
			}
		}

		if (dp[row][col] > 1) {
			System.out.println("1");
		} else {
			System.out.println(dp[row][col]);
		}
	}

	private static void ProbabilityOfKnights(int n, int x, int y, int z) {
		// TODO Auto-generated method stub
		double[][][] strg = new double[n + 1][n + 1][z + 1];
		int[] xdir = { 2, 2, 1, 1, -1, -1, -2, -2 };
		int[] ydir = { 1, -1, 2, -2, 2, -2, 1, -1 };

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				strg[i][j][0] = 1;
			}
		}
		for (int i = 1; i <= z; i++) {

			for (int k = 0; k <= n; k++) {
				for (int j = 0; j <= n; j++) {
					for (int dir = 0; dir < xdir.length; dir++) {
						int newx = k + xdir[dir];
						int newy = j + ydir[dir];
						if (newx >= 0 && newx <= n && newy >= 0 && newy <= n) {
							strg[k][j][i] += strg[newx][newy][i - 1] / 8.0;
						}
					}
				}
			}

		}

		System.out.println(strg[x][y][z]);
	}

	private static void WildcardMatching(String s, String p) {
		// TODO Auto-generated method stub

	}

	private static void LinearEquation(int[] a, int n, int k) {
		// TODO Auto-generated method stub

		int[] strg = new int[k + 1];
		strg[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = a[i]; j < strg.length; j++) {
				if (strg[j - a[i]] != 0) {
					strg[j] += strg[j - a[i]];
				}
			}
		}
		System.out.println(strg[k]);

	}

	private static int PaintersPartition(int[] arr, int k, int vidx, int[][] qb) {
		if (k == 1) {

		}

		int min = Integer.MAX_VALUE;
		for (int i = vidx; i < arr.length - 1; i++) {
			int x = PaintersPartition(arr, k - 1, vidx + i, qb);
			int y = Math.max(x, prefixsum(arr, i));
			if (y < min) {
				min = y;
			}
		}
		qb[vidx][k] = min;
		return min;
	}

	public static int prefixsum(int[] a, int idx) {
		int[] strg = new int[a.length];
		strg[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			strg[i] += strg[i - 1];
		}
		return strg[idx];
	}

	private static void TilingProblem(int n, int m) {
		// TODO Auto-generated method stub
		int[] strg = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			if (i > m) {
				strg[i] = strg[i - 1];
				strg[i] += strg[i - m];
			} else if (i == m) {
				strg[i] = 2;
			} else {
				strg[i] = 1;
			}
		}
		System.out.println(strg[n]);

	}

	private static void NoConsecutive1s(int n) {
		// TODO Auto-generated method stub
		int[][] strg = new int[2][n + 1];
		for (int i = 0; i < 2; i++) {
			strg[i][0] = 0;
			strg[i][1] = 1;
		}

		for (int i = 2; i <= n; i++) {
			strg[1][i] = strg[0][i - 1];
			strg[0][i] = strg[0][i - 1] + strg[1][i - 1];
		}
		int sum = strg[0][n] + strg[1][n];
		System.out.println(sum);

	}

	private static void NumericKeypad(int n) {
		int[][] strg = new int[10][n + 1];

		for (int i = 0; i <= 9; i++) {
			strg[i][0] = 0;
			strg[i][1] = 1;
		}

		int[][] moves = { { 0, 1, 3 }, { 0, 1, 2, 4 }, { 1, 2, 5 }, { 0, 3, 4, 6 }, { 1, 3, 4, 5, 7 }, { 2, 4, 5, 8 },
				{ 3, 6, 7 }, { 4, 6, 7, 8, 9 }, { 5, 7, 8 }, { 9, 7 } };

		for (int j = 2; j <= n; j++) {
			for (int i = 0; i <= 9; i++) {
				int[] b = moves[i];
				for (int k = 0; k < b.length; k++) {
					strg[i][j] += strg[b[k]][j - 1];
				}
			}
		}
		int sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum += strg[i][n];
		}
		System.out.println(sum);

	}

	private static void OptimalBinarySearch(int[] arr, int[] fre) {
		int[][] a = new int[arr.length + 1][arr.length + 1];

		int[] freqsum = new int[arr.length];
		freqsum[0] = fre[0];
		for (int i = 1; i < arr.length; i++) {
			freqsum[i] = freqsum[i - 1] + fre[i];
		}

		for (int gap = 0; gap < arr.length; gap++) {
			for (int i = 0, j = i + gap; j < arr.length; j++, i++) {
				int min = Integer.MAX_VALUE;
				for (int r = i; r <= j; r++) {
					int leftcost = 0, rightcost = 0;
					if (r > i) {
						leftcost = a[i][r - 1];
					} else {
						leftcost = 0;
					}

					if (r < j) {
						rightcost = a[r + 1][j];
					} else {
						rightcost = 0;
					}
					if (leftcost + rightcost < min) {
						min = leftcost + rightcost;
					}
				}
				a[i][j] = min + (freqsum[j] - (i > 0 ? freqsum[i - 1] : 0));
			}
		}
		System.out.println(a[0][arr.length - 1]);

	}

	private static void MaxSumBitonicSS(int[] a, int n) {
		int[] inc = new int[n];
		int[] dec = new int[n];
		int[] bit = new int[n];

		inc[0] = a[0];
		dec[dec.length - 1] = a[n - 1];

		for (int i = 1; i < inc.length; i++) {
			int max = Integer.MIN_VALUE;
			int maxinc = 0;
			for (int j = 0; j < i; j++) {
				if (inc[j] > max && a[j] < a[i]) {
					max = inc[j];
					maxinc = inc[j];
				}

			}
			if (max == Integer.MIN_VALUE) {
				inc[i] = a[i];
			} else {
				inc[i] = maxinc + a[i];
			}
		}

		for (int i = dec.length - 2; i >= 0; i--) {
			int max = Integer.MIN_VALUE;
			int maxdec = 0;
			for (int j = i + 1; j < n; j++) {
				if (dec[j] > max && a[j] < a[i]) {
					max = dec[j];
					maxdec = dec[j];
				}

			}
			if (max == Integer.MIN_VALUE) {
				dec[i] = a[i];
			} else {
				dec[i] = maxdec + a[i];
			}
		}

		for (int i = 0; i < n; i++) {
			bit[i] = inc[i] + dec[i] - a[i];
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (bit[i] > max) {
				max = bit[i];
			}
		}
		System.out.println(max);
	}

	private static void npersonsingleorpair(int n) {
		// TODO Auto-generated method stub
		int[] strg = new int[n + 1];
		strg[0] = 0;
		strg[1] = 1;
		strg[2] = 2;
		for (int i = 3; i <= n; i++) {
			strg[i] = strg[i - 1] + (i - 1) * strg[i - 2];
		}

		System.out.println(strg[n]);
	}

	private static void nintoksets(int n, int k) {
		// TODO Auto-generated method stub
		// int[] strg = new int[n + 1];
		// strg[0] = 0;
		// strg[1] = 1;
		// strg[2] = 2;
		// for (int i = 3; i <= n; i++) {
		// strg[i] = strg[i - 1] + (i - 1) * strg[i - 2];
		// }
		//
		// System.out.println(strg[n]);
	}

	private static void minjumpsiterative(int[] a) {// one test case
		int[] strg = new int[a.length];
		strg[a.length - 1] = 0;
		if (a[a.length - 2] == 1) {
			strg[a.length - 2] = 1;
		} else {
			strg[a.length - 2] = 0;
		}
		for (int i = a.length - 3; i >= 0; i--) {
			if (a[i] == 0) {
				strg[i] = Integer.MAX_VALUE;
			} else if (a[i] > a.length - 1 - i) {
				strg[i] = 1;
			} else {
				int min = Integer.MAX_VALUE;
				for (int j = i + 1; j <= a[i]; j++) {
					if (strg[j] < min && strg[j] > 0) {
						min = strg[j];
					}
				}
				if (min == Integer.MAX_VALUE) {
					strg[i] = min;
				} else {
					strg[i] = min + 1;
				}
			}
		}
		System.out.println(strg[0]);
	}

	public static void display(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void display(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}

package pepcoding_interviewprep;

import java.util.Scanner;

public class day1_test {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		// int m = scn.nextInt();
		// int[][] a = new int[n][m];
		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < m; j++) {
		// a[i][j] = scn.nextInt();
		// }
		// }
		// exitpoint(a, n, m, 0, 0, false, true, false, false);
		// String s = scn.next();
		// keypad(s, "");
		// System.out.println(count);
		lexi(n);
		// nQueen(new boolean[n][n], 0, "");
		// lexicographic(n, "1");
		// maze(a, 0, 0, n - 1, m - 1, new boolean[n][m]);
		// System.out.println(count);
	}

	public static void lexi(int n) {
		for (int i = 1; i <=9; i++) {
			lexicographic(n, i + "");
		}

	}

	private static void lexicographic(int n, String k) {
		if (Integer.parseInt(k) >= n) {
			return;
		}
		System.out.println(k);
		for (int i = 0; i <= 9; i++) {

			// System.out.println(k + i);
			lexicographic(n, k + i);

		}
		// lexicographic(n, (Integer.parseInt(k) + 1) + "");

	}

	private static void maze(int[][] a, int sr, int sc, int dr, int dc, boolean[][] visited) {
		if (issafe(a, sr, sc, visited) == false) {
			return;
		}
		if (sr == dr && sc == dc) {
			count++;
			return;
		}
		visited[sr][sc] = true;
		maze(a, sr - 1, sc, dr, dc, visited);
		maze(a, sr, sc + 1, dr, dc, visited);
		maze(a, sr + 1, sc, dr, dc, visited);
		maze(a, sr, sc - 1, dr, dc, visited);
		visited[sr][sc] = false;

	}

	private static boolean issafe(int[][] a, int sr, int sc, boolean[][] visited) {
		// TODO Auto-generated method stub
		if (sr >= a.length) {
			return false;
		} else if (sc >= a.length) {
			return false;
		} else if (sr < 0) {
			return false;
		} else if (sc < 0) {
			return false;
		} else if (visited[sr][sc] == true) {
			return false;
		} else if (a[sr][sc] == 0) {
			return false;
		}
		return true;
	}

	public static int count = 0;
	public static String[] a = { ".", "abc", "def", "gh", "jkl", "mno", "pqrs", "tuv", "wx", "yz" };

	private static void keypad(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			count++;
			return;
		}
		char c = ques.charAt(0);
		String roq = ques.substring(1);
		String pat = a[c - '0'];
		for (int i = 0; i < pat.length(); i++) {
			keypad(roq, ans + pat.charAt(i));
		}

	}

	private static void exitpoint(int[][] a, int n, int m, int sr, int sc, boolean left, boolean right, boolean down,
			boolean up) {
		if (sr < 0 || sr >= n || sc < 0 || sc >= m) {
			if (left) {
				System.out.println(sr + ", " + 0);
			} else if (right) {
				System.out.println(sr + ", " + (sc - 1));

			} else if (down) {
				System.out.println((sr - 1) + ", " + sc);
			} else if (up) {
				System.out.println(0 + ", " + sc);
			}
			return;
		}
		// int row = 0;
		// int col = 0;
		if (right) {
			// row = sr;
			// col = sc + 1;
			// if (row < 0 || col < 0 || row >= n || col >= m) {
			// System.out.println(sr + ", " + sc);
			// // System.out.println(psf);
			// return;
			// }
			if (a[sr][sc] == 0) {
				exitpoint(a, n, m, sr, sc + 1, false, true, false, false);
			} else {
				exitpoint(a, n, m, sr + 1, sc, false, false, true, false);
			}
		} else if (down) {

			if (a[sr][sc] == 0) {
				exitpoint(a, n, m, sr + 1, sc, false, false, true, false);
			} else {
				exitpoint(a, n, m, sr, sc - 1, true, false, false, false);
			}
		} else if (left) {

			if (a[sr][sc] == 0) {
				exitpoint(a, n, m, sr, sc - 1, true, false, false, false);
			} else {
				exitpoint(a, n, m, sr - 1, sc, false, false, false, true);
			}
		} else if (up) {

			if (a[sr][sc] == 0) {
				exitpoint(a, n, m, sr - 1, sc, false, false, false, true);
			} else {
				exitpoint(a, n, m, sr, sc + 1, false, true, false, false);
			}
		}

	}

	public static void nQueen(boolean[][] arr, int row, String ans) {
		if (row == arr.length) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (canplacesafely(arr, row, i, arr.length)) {
				arr[row][i] = true;
				nQueen(arr, row + 1, ans + "[" + row + "-" + i + "]");
				arr[row][i] = false;
			}
		}

	}

	public static int[][] dirs = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { -1, 0 },
			{ 1, -1 } };

	private static boolean canplacesafely(boolean[][] arr, int row, int col, int n) {
		// TODO Auto-generated method stub
		int r = row;
		int c = col;
		for (int i = 0; i < dirs.length; i++) {
			row = r;
			col = c;
			while (row < n && col < n && row >= 0 && col >= 0) {
				int newrow = row + dirs[i][0];
				int newcol = col + dirs[i][1];
				if (newrow < n && newcol < n && newrow >= 0 && newcol >= 0) {
					if (arr[newrow][newcol] == true)
						return false;

					row = newrow;
					col = newcol;

				} else {
					break;
				}
			}
		}

		return true;
	}
}

package dp;

import java.util.Scanner;

public class dp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		// int n = scn.nextInt();
		// int[] a = new int[n];
		// for (int i = 0; i < n; i++) {
		// a[i] = scn.nextInt();
		// }

		// System.out.println(minjumps(a,n));
		// int[] dp = new int[a.length];
		// System.out.println(minjumpsmem(a, dp, 0));
		// display(dp);
		// printminjumps(a, dp, 0, "");
		// System.out.println(countstairs(4));
		// System.out.println(countstairsmem(4, new int[5]));
		int[][] cost = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		// int[][] dp = new int[cost.length][cost[0].length];
		// int[][] a = { { 2, 3, 0, 4 }, { 0, 6, 5, 2 }, { 8, 0, 3, 7 }, { 2, 0,
		// 4, 2 } };
		// int[][] b = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		// System.out.println(mincostpath(cost, dp));
		// printmincostpath(cost, dp, 0, 0, "");
		int[][] mine = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2 } };
		int[][] gdp = new int[mine.length][mine[0].length];
		int x = goldmine(mine, gdp);
		System.out.println(x);
		printgoldmine(mine, gdp, x);

	}

	private static void printgoldmine(int[][] mine, int[][] dp, int max) {
System.out.println(max);
		for (int i = 0; i < mine.length; i++) {
			if (dp[i][0] == max) {
				
				printgoldminehelper(mine, dp, i, 0, "");
			}
		}
	}

	private static void printgoldminehelper(int[][] mine, int[][] dp, int i, int j, String psf) {
		if (j == dp[0].length - 1) {
			System.out.println(psf + " ");
			return;
		}

		if (i == 0) {
			if (dp[i][j + 1] < dp[i + 1][j + 1]) {
				printgoldminehelper(mine, dp, i + 1, j + 1, psf + "dd ");
			} else {
				printgoldminehelper(mine, dp, i, j + 1, psf + "s ");
			}
		} else if (i == mine.length - 1) {
			if (dp[i][j + 1] < dp[i - 1][j + 1]) {
				printgoldminehelper(mine, dp, i - 1, j + 1, psf + "ud ");
			} else {
				printgoldminehelper(mine, dp, i, j + 1, psf + "s ");
			}
		} else {
			if (dp[i][j + 1] > dp[i - 1][j + 1] && dp[i][j + 1] > dp[i + 1][j + 1]) {
				printgoldminehelper(mine, dp, i, j + 1, psf + "s ");
			} else if (dp[i + 1][j + 1] > dp[i - 1][j + 1] && dp[i][j + 1] < dp[i + 1][j + 1]) {
				printgoldminehelper(mine, dp, i + 1, j + 1, psf + "dd ");
			} else {
				printgoldminehelper(mine, dp, i - 1, j + 1, psf + "ud ");
			}

		}

	}

	public static int mincostpath(int[][] maze, int[][] dp) {

		int n = maze.length;
		int m = maze[0].length;
		dp[n - 1][m - 1] = maze[n - 1][m - 1];
		for (int i = m - 2; i >= 0; i--) {
			dp[n - 1][i] = dp[n - 1][i + 1] + maze[n - 1][i];
		}
		for (int i = n - 2; i >= 0; i--) {
			dp[i][m - 1] = dp[i + 1][m - 1] + maze[i][m - 1];
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				if (i != m - 1 && j != n - 1) {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + maze[i][j];
				}
			}
		}
		display(dp);
		return dp[0][0];

	}

	public static void printmincostpath(int[][] maze, int[][] dp, int i, int j, String psf) {
		if (i == maze.length - 1 && j == maze[0].length - 1) {
			System.out.println(psf + " ");
			return;
		}
		if (((i + 1) >= dp.length) && ((j + 1) < dp[0].length)) {
			printmincostpath(maze, dp, i, j + 1, psf + "h ");
		} else if (((i + 1) < dp.length) && ((j + 1) >= dp[0].length)) {
			printmincostpath(maze, dp, i + 1, j, psf + "v ");
		} else if ((i + 1) < dp.length && (j + 1) < dp[0].length && dp[i + 1][j] < dp[i][j + 1]) {
			printmincostpath(maze, dp, i + 1, j, psf + "v ");
		} else {
			printmincostpath(maze, dp, i, j + 1, psf + "h ");
		}
	}

	public static int goldmine(int[][] mine, int[][] dp) {
		for (int i = mine[0].length - 1; i >= 0; i--) {
			for (int j = mine.length - 1; j >= 0; j--) {
				if (i == mine[0].length - 1) {
					dp[j][i] = mine[j][i];
				} else if (j == 0) {
					dp[j][i] = Math.max(dp[j][i + 1], dp[j + 1][i + 1]) + mine[j][i];
				} else if (j == mine.length - 1) {
					dp[j][i] = Math.max(dp[j][i + 1], dp[j - 1][i + 1]) + mine[j][i];
				} else {
					dp[j][i] = Math.max(dp[j][i + 1], Math.max(dp[j + 1][i + 1], dp[j - 1][i + 1])) + mine[j][i];
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < mine.length; i++) {
			if (dp[i][0] > max) {
				max = dp[i][0];
			}
		}
		display(dp);
		return max;
	}

	private static void display(int[][] dp) {
		// TODO Auto-generated method stub
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void printminjumps(int[] a, int[] dp, int i, String psf) {
		if (i == a.length - 1) {
			System.out.println(psf + " ");
			return;
		}

		psf += i;
		int k = a[i];
		while ((i + k) >= a.length && k > 0) {
			k--;
		}

		for (int j = i + k; j > i; j--) {
			if (dp[j] == dp[i] - 1 || j == a.length - 1) {
				printminjumps(a, dp, j, psf);
			}
		}

	}

	public static int countstairs(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static int countstairsmem(int n, int[] dp) {

		if (n < 0) {
			return 0;
		}
		if (n == 0 || n == 1) {
			return 1;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		int x = countstairsmem(n - 1, dp) + countstairsmem(n - 2, dp);
		dp[n] = x;
		return x;
	}

	public static int minjumps(int[] a, int n) {
		int[] dp = new int[n];
		dp[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			int k = a[i];
			if (k == 0) {
				dp[i] = n;
			} else {
				while ((i + k) >= n && k > 0) {
					k--;
				}
				int min = i + k;
				for (int j = i + k; j > i; j--) {
					if (dp[j] < dp[min]) {
						min = j;
					}
				}
				dp[i] = 1 + dp[min];
			}
		}
		// display(dp);
		return dp[0];
	}

	public static int minjumpsmem(int[] a, int[] dp, int i) {
		if (i == a.length - 1) {
			return 0;
		}
		if (dp[i] != 0) {
			return dp[i];
		}
		if (a[i] == 0) {
			return a.length;
		} else {
			int k = a[i];
			while ((i + k) >= a.length && k > 0) {
				k--;
			}

			int min = Integer.MAX_VALUE;
			for (int j = i + k; j > i; j--) {
				int x = minjumpsmem(a, dp, j);
				if (x < min) {
					min = x;
				}
			}

			dp[i] = min + 1;
			return dp[i];

		}
	}

	private static void display(int[] dp) {
		// TODO Auto-generated method stub
		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();

	}

}

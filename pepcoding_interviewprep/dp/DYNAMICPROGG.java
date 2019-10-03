package dp;

public class DYNAMICPROGG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 3, 1, 5, 6 };
		System.out.println(targetsum(a, 10));
		int[] wt = { 2,5,1,3,4 };
		int[] val = { 15,14,10,45,30};
		System.out.println(knapsack(wt, val, 7));
	}

	private static int knapsack(int[] wt, int[] val, int t) {
		int[][] b = new int[wt.length + 1][t + 1];

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				 if (i == 0 || j == 0) {
					b[i][j] = 0;
				} else {
					int x = wt[i - 1];
					int p = val[i - 1];
					if (x <= j) {
						b[i][j] = (b[i - 1][j - x] + p) >= (b[i - 1][j]) ? (b[i - 1][j - x] + p) : (b[i - 1][j]);
					} else {
						b[i][j] = b[i - 1][j];
					}
				}
			}
		}
		display(b);
		printknapsack(b, wt, val, wt.length, t, "");
		return b[wt.length][t];
	}

	private static void printknapsack(int[][] b, int[] wt, int[] val, int i, int j, String psf) {
		if (i == 0 && j == 0) {
			System.out.println(psf + " ");
			return;
		}
		int x = wt[i - 1];
		int p = val[i - 1];
		if (x <= j) {
			if ((b[i - 1][j - x] + p) == (b[i - 1][j])) {

				printknapsack(b, wt, val, i - 1, j - x, psf + x + " ");
				printknapsack(b, wt, val, i - 1, j, psf);
			} else if ((b[i - 1][j - x] + p) > (b[i - 1][j])) {
				printknapsack(b, wt, val, i - 1, j - x, psf + x + " ");
			} else if ((b[i - 1][j - x] + p) < (b[i - 1][j])) {
				printknapsack(b, wt, val, i - 1, j, psf + " ");
			}
		} else {
			printknapsack(b, wt, val, i - 1, j, psf + " ");
		}

	}

	private static void display(int[][] a) {
		// TODO Auto-generated method stub
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

	private static boolean targetsum(int[] a, int t) {
		// TODO Auto-generated method stub
		boolean[][] b = new boolean[a.length + 1][t + 1];

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if (j == 0) {
					b[i][j] = true;
				} else if (i == 0 && j != 0) {
					b[i][j] = false;
				} else {
					int x = a[i - 1];

					if (x <= j) {
						b[i][j] = b[i - 1][j - x] || b[i - 1][j];
					} else {
						b[i][j] = b[i - 1][j];
					}
				}
			}
		}
		display(b);
		printtargetsum(b, a, a.length, t, "");
		return b[a.length][t];
	}

	public static void printtargetsum(boolean[][] b, int[] a, int i, int j, String psf) {
		if (i == 0 && j == 0) {
			System.out.println(psf + " ");
			return;
		}
		int x = a[i - 1];
		if (x <= j) {
			if (b[i - 1][j - x] == true && b[i - 1][j] == true) {

				printtargetsum(b, a, i - 1, j - x, psf + x + " ");
				printtargetsum(b, a, i - 1, j, psf + " ");
			} else if (b[i - 1][j - x] == true) {
				printtargetsum(b, a, i - 1, j - x, psf + x + " ");
			} else if (b[i - 1][j] == true) {
				printtargetsum(b, a, i - 1, j, psf + " ");
			}
		} else {
			if (b[i - 1][j] == true) {
				printtargetsum(b, a, i - 1, j, psf + " ");
			}
		}
	}

	public static void display(boolean[][] a) {
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}

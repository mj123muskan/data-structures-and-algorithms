package aug19;

import java.util.Arrays;

public class FloydWarshall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = new int[4][4];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = Integer.MAX_VALUE;
			}

		}
		a[0][1] = 2;
		a[0][2] = 8;
		a[0][3] = 10;
		a[1][2] = 3;
		a[1][3] = 7;
		a[2][3] = 1;
		floydwarshall(a);
	}

	private static void floydwarshall(int[][] a) {
		// TODO Auto-generated method stub

		for (int i = 0; i < a.length; i++) {
			for (int s = 0; s < a.length; s++) {
				for (int d = 0; d < a.length; d++) {
					if (i != s && i != d && a[s][i] != Integer.MAX_VALUE && a[i][d] != Integer.MAX_VALUE && s != d) {
						if ((a[s][i] + a[i][d]) < a[s][d]) {
							a[s][d] = (a[s][i] + a[i][d]);
						}
					}
				}
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}

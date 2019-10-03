package mar19;

import java.util.ArrayList;

public class lec6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// permutations(new boolean[4], 2, 0, "");
		// combinations(new boolean[4], 2, 0, "", -1);
		// int[][] a = { { 1, 1, 0, 0 }, { 1, 1, 0, 0 }, { 0, 1, 0, 0 }, { 0, 1,
		// 1, 1 } };
		// System.out.println(countmaze(a, 0, 0, 2, 2, new int[3][3]));
		// boolean[][] chess = new boolean[4][4];
		// nqueens(chess, 0, "", -1);

		int[] a = { 10, 20, 30 };
		printtargetsubsets(a, 0, 30, "", 0);
	}

	public static void permutations(boolean[] boxes, int tq, int qsf, String asf) {
		if (qsf == tq) {
			System.out.println(asf);
			return;
		}
		for (int b = 0; b < boxes.length; b++) {
			if (boxes[b] == false) {
				boxes[b] = true;
				permutations(boxes, tq, qsf + 1, asf + "q" + " " + (qsf + 1) + "b" + " " + b + "  ");
				boxes[b] = false;
			}
		}
	}

	public static void combinations(boolean[] boxes, int tq, int qsf, String asf, int lqpb) {
		if (qsf == tq) {
			System.out.println(asf);
			return;
		}
		for (int b = lqpb + 1; b < boxes.length; b++) {
			if (boxes[b] == false) {
				boxes[b] = true;
				combinations(boxes, tq, qsf + 1, asf + "q" + " " + (qsf + 1) + "b" + " " + b + "  ", b);
				boxes[b] = false;
			}
		}
	}

	public static int countmaze(int[][] a, int sr, int sc, int dr, int dc, int[][] q) {
		if (sr == dr && sc == dc) {
			return 1;
		}

		if (sr > dr || sc > dc) {
			return 0;
		}
		if (q[sr][sc] != 0) {
			return q[sr][sc];
		}

		if (a[sr][sc] == 0) {
			return 0;
		}
		int count = 0;

		int h = countmaze(a, sr, sc + 1, dr, dc, q);
		int v = countmaze(a, sr + 1, sc, dr, dc, q);

		count = h + v;
		q[sr][sc] = count;
		return count;
	}

	static int counter = 0;

	public static void nqueens(boolean[][] chess, int qsf, String asf, int lpbq) {
		if (qsf == chess.length) {
			counter++;
			if (ischesssafe(chess) == true) {
				System.out.println(counter + " " + asf);
			}
			return;
		}
		for (int i = lpbq + 1; i < chess.length * chess.length; i++) {
			int row = i / chess.length;
			int col = i % chess.length;
			if (chess[row][col] == false) {
				chess[row][col] = true;

				nqueens(chess, (qsf + 1), asf + "q" + (qsf + 1) + "b" + i + " ", i);
				chess[row][col] = false;
			}
		}
	}

	private static boolean ischesssafe(boolean[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[0].length; j++) {
				if (chess[i][j] == true) {
					if (isqueensafe(chess, i, j) == false) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean isqueensafe(boolean[][] chess, int row, int col) {
		int[][] dir = { { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 } };
		for (int i = 0; i < dir.length; i++) {
			for (int j = 1; true; j++) {
				int eqcol = col + j * dir[i][1];
				int eqrow = row + j * dir[i][0];
				if (eqcol < 0 || eqrow < 0 || eqcol >= chess.length || eqrow >= chess.length) {
					break;
				}
				if (chess[eqrow][eqcol] == true) {
					return false;
				}
			}
		}
		return true;
	}

	public static void printtargetsubsets(int[] a, int vidx, int tar, String set, int sum) {
		if (vidx == a.length) {
			if (sum == tar) {
				System.out.println(set);
			}
			return;
		}
		printtargetsubsets(a, vidx + 1, tar, set + "  " + a[vidx], sum + a[vidx]);
		printtargetsubsets(a, vidx + 1, tar, set, sum);
	}

//	public static void knapsack(int []w,int []v,int vidx,int tar,String set,int sum,int max)
//	{ 
//		if(sum+v[vidx]>max)
//		{
//			max=set+"  "+w[vidx];
//		}
//		knapsack(w, v, vidx+1, tar, set+"  "+w[vidx], sum+v[vidx], max);
//	}
}

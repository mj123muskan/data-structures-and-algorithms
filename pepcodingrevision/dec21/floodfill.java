package dec21;

import java.util.Scanner;

public class floodfill {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();

		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = scn.nextInt();
			}
		}

		boolean[][] visited = new boolean[n][m];
		System.out.println(microandmaze(0, 0, visited, a, n, m));

	}

	public static boolean microandmaze(int cr, int cc, boolean[][] visited, int[][] a, int n, int m) {

		if (cr >= n || cc >= m || cr < 0 || cc < 0) {
			return false;
		}

		if (a[cr][cc] == 0) {
			return false;
		}

		if (cr == n && cc == m) {
			return true;
		}
		if (visited[cr][cc] == true) {
			return false;
		}
		visited[cr][cc] = true;

		boolean top = microandmaze(cr - 1, cc, visited, a, n, m);
		if(top==true)
		{
			return true;
		}
		boolean right = microandmaze(cr, cc + 1, visited, a, n, m);
		if(right==true)
		{
			return true;
		}
		boolean down = microandmaze(cr + 1, cc, visited, a, n, m);
		if(down==true)
		{
			return true;
		}
		boolean left = microandmaze(cr, cc - 1, visited, a, n, m);
		if(left==true)
		{
			return true;
		}

		
		return false;

	}

}

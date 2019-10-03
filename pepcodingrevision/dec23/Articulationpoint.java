package dec23;

import java.util.Scanner;

public class Articulationpoint {
	// 6 7 5 0 0 1 1 2 1 3 2 3 2 4 3 4

	static boolean[][] graph;
	static articulationpoint[] result;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();

		graph = new boolean[n][n];
		result = new articulationpoint[n];

		for (int i = 0; i < m; i++) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			graph[x][y] = true;
			graph[y][x] = true;
		}
		for (int i = 0; i < n; i++) {
			result[i] = new articulationpoint();
			result[i].vert = i;
			result[i].disc = 0;
			result[i].low = 0;
			result[i].processed = false;
			result[i].isAP = false;
		}

		for (int i = n - 1; i >= 0; i--) {
			if (result[i].processed == true) {
				continue;
			}
			dft(0, i);
		}
		for (int i = 0; i < n; i++) {
			System.out.println(result[i].vert + "=>" + result[i].isAP);
		}
	}

	private static void dft(int time, int vertex) {
		result[vertex].processed = true;
		result[vertex].disc = time;
		result[vertex].low = time;
		int rootchildcount = 0;
		for (int i = 0; i < result.length; i++) {

			if (graph[i][vertex]) {

				if (result[i].processed == false) // unprocessed
				{
					rootchildcount++;
					result[i].parent = vertex;
					dft(time + 1, i);
					result[vertex].low = Math.min(result[i].low, result[vertex].low);
					if (result[vertex].parent != -1) {
						if (result[i].low >= result[vertex].disc) {
							result[vertex].isAP = true;
						}
					} else {
						if (rootchildcount > 1) {
							result[vertex].isAP = true;
						}
					}
				} else if (result[i].vert != result[vertex].parent) {// prcessed
																		// but
																		// not
																		// parent
					result[vertex].low = Math.min(result[vertex].low, result[i].disc);

				}
				// parent
			}
		}

	}

	private static class articulationpoint {
		int vert;
		int low;
		int disc;
		boolean isAP;
		int parent = -1;
		boolean processed;

	}

}

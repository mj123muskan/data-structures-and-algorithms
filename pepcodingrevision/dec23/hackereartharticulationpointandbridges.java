package dec23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class hackereartharticulationpointandbridges {
	static boolean[][] graph;
	static articulationpoint[] result;
	static bridgepair[] bridge;
	static int countap;
	static ArrayList<bp> br;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int countap = 0;
		br = new ArrayList<>();
		graph = new boolean[n][n];
		result = new articulationpoint[n];
		bridge = new bridgepair[n];
		countap = 0;
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
		for (int i = 0; i < n; i++) {
			bridge[i] = new bridgepair();
			bridge[i].vert = i;
			bridge[i].disc = 0;
			bridge[i].low = 0;
			bridge[i].processed = false;
			bridge[i].isAP = false;
		}

//		for (int i = 0; i < n; i++) {
//			if (result[i].processed == true) {
//				continue;
//			}
//			dft(0, i);
//		}
//
//		System.out.println(countap);
//		for (int i = 0; i < n; i++) {
//
//			if (result[i].isAP) {
//				System.out.print(result[i].vert + " ");
//			}
//			System.out.println();
//		}
		for (int i = n-1; i >=0; i--) {
			if (bridge[i].processed == true) {
				continue;
			}
			dftbridge(0, i);
		}

		Collections.sort(br);
		System.out.println(br.size());
		for (int i = 0; i < br.size(); i++) {

			System.out.print(br.get(i).u + " " + br.get(i).v);
			System.out.println();
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
							countap++;
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
			}
			// parent
		}
	}

	private static void dftbridge(int time, int vertex) {
		bridge[vertex].processed = true;
		bridge[vertex].disc = time;
		bridge[vertex].low = time;
		int rootchildcount = 0;
		for (int i = 0; i < bridge.length; i++) {

			if (graph[i][vertex]) {

				if (bridge[i].processed == false) // unprocessed
				{
					rootchildcount++;
					bridge[i].parent = vertex;
					dftbridge(time + 1, i);

					bridge[vertex].low = Math.min(bridge[i].low, bridge[vertex].low);
					if (bridge[vertex].parent != -1) {
						if (bridge[i].low > bridge[vertex].disc) {

							bp b = new bp();
							if (i < vertex) {
								b.u = i;
								b.v = vertex;

							} else {
								b.u = vertex;
								b.v = i;
							}
							br.add(b);

						}
					} else {
						if (rootchildcount > 1) {
							bridge[vertex].isAP = true;
						}
					}
				} else if (bridge[i].vert != bridge[vertex].parent) {// prcessed
																		// but
																		// not
																		// parent
					bridge[vertex].low = Math.min(bridge[vertex].low, bridge[i].disc);

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

	private static class bridgepair {
		int vert;
		int low;
		int disc;
		boolean isAP;
		int parent = -1;
		boolean processed;

	}

	private static class bp implements Comparable<bp> {
		int u;
		int v;

		@Override
		public int compareTo(bp o) {
			return this.u * 10 - this.v + o.u * 10 - o.v;

		}

	}

}

package dec22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class toposort {

	static boolean[][] graph;

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();

		graph = new boolean[n + 1][n + 1];
		boolean[] processed = new boolean[n + 1];

		for (int i = 1; i <= m; i++) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			graph[a][b] = true;
		}

		LinkedList<Integer> resultstack = new LinkedList<>();
		for (int i = n; i >= 1; i--) {

			if (processed[i]) {
				continue;
			}

			topologicalsort(i, n, processed, resultstack);
		}

		while (!resultstack.isEmpty()) {
			System.out.println(resultstack.removeFirst());
		}
	}

	private static void topologicalsort(int vname, int n, boolean[] processed, LinkedList<Integer> stack) {
		if (processed[vname]) {
			return;
		}
		processed[vname] = true;

		for (int i = n; i >= 1; i--) {

			if (graph[vname][i]) {

				topologicalsort(i, n, processed, stack);
			}

		}

		stack.addFirst(vname);

	}

}

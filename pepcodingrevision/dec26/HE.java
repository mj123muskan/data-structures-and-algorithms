package dec26;//DEC25

import java.util.Scanner;

public class HE {
	static char[][] graph;
	static boolean[][] processed;
	static boolean[][] quadDone;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int n = Integer.parseInt(scn.next());
		int m = Integer.parseInt(scn.next());

		graph = new char[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				graph[i][j] = scn.next().charAt(0);
			}
		}

		processed = new boolean[n + 1][m + 1];
		quadDone = new boolean[n + 1][m + 1];
		

		int count = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (graph[i][j] == 'a') {
					processed = new boolean[n + 1][m + 1];
					boolean didigetaquad = isQuad(i, j);
					if (didigetaquad) {
						count++;
					}
				}
			}
		}
		
		System.out.println(count);

	}
	
	public static boolean isQuad(int cr, int cc) {
		if (processed[cr][cc] == true) {
			return false;
		}
		processed[cr][cc] = true;
		quadDone[cr][cc] = true;

		if (graph[cr][cc] == 'd') {
			return true;
		}

		if (isAnEdge(cr, cc, cr + 1, cc)) {
			if(isQuad(cr + 1, cc)){
				return true;
			}
		}

		if (isAnEdge(cr, cc, cr, cc + 1)) {
			if(isQuad(cr, cc + 1)){
				return true;
			}
		}

		if (isAnEdge(cr, cc, cr - 1, cc)) {
			if(isQuad(cr - 1, cc)){
				return true;
			}
		}

		if (isAnEdge(cr, cc, cr, cc - 1)) {
			if(isQuad(cr, cc - 1)){
				return true;
			}
		}
		
		quadDone[cr][cc] = false;
		return false;
	}

	public static boolean isAnEdge(int cr, int cc, int nbrr, int nbrc) {
		if (nbrr < 1 || nbrr >= graph.length || nbrc < 1 || nbrc >= graph[0].length) {
			return false;
		}
		else if(quadDone[nbrr][nbrc]){
			return false;
		}
		else if (graph[cr][cc] + 1 != graph[nbrr][nbrc]) {
			return false;
		} else {
			return true;
		}
	}

}

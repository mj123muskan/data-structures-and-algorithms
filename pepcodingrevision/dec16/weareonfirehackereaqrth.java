package dec16;

import java.util.HashMap;
import java.util.Scanner;

public class weareonfirehackereaqrth {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int q = scn.nextInt();
		int[][] j = new int[n + 1][m + 1];
		HashMap<Integer, HashMap<Integer, Integer>> h = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			for (int k = 1; k <= m; k++) {
				j[i][k] = scn.nextInt();
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int k = 1; k <= m; k++) {
				if(j[i][k] ==1)
				{
					h.put(key, value)
				}
			}
		}
		
		
		
		

	}
	private static class pair
	{
		int c1;
		int c2;
	}

}

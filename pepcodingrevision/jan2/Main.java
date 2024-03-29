package jan2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		for (int i = 0; i < t; i++) {
			int n = scn.nextInt();
			int[] l = new int[n];
			int[] r = new int[n];
			for (int k = 0; k < n; k++) {
				l[i] = scn.nextInt();
			}
			for (int p = 0; p < n; p++) {
				r[i] = scn.nextInt();
			}
			find(l, r, n);
			
		}

	}

	private static void find(int[] l, int[] r, int n) {

		int max = Integer.MIN_VALUE;
		int maxri = Integer.MIN_VALUE;
		int maxidx = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			int j = l[i] * r[i];
			if (j > max) {
				max = j;
				maxri = r[i];
				maxidx = i;
			} else if (j == max) {
				if (r[i] > maxri) {
					max = j;
					maxri = r[i];
					maxidx = i;

				} else if (r[i] == maxri) {
					if (i < maxidx) {
						max = j;
						maxri = r[i];
						maxidx = i;
					}
				}
			}
		}
		System.out.println(maxidx+1);

	}

}

package mar19;

import java.util.Scanner;

public class greedy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int c = scn.nextInt();
		int[] weight = new int[n];
		for (int i = 0; i < n; i++) {
			weight[i] = scn.nextInt();
		}
		int[] bins = new int[n];

		// for (int j = 0; j < n; j++) {// firstfit bin packing
		// for (int k = 0; k < n; k++) {
		// if (bins[k] + weight[j] <= c) {
		// bins[k] += weight[j];
		// System.out.println("weight " + j + " i.e " + weight[j] + " in bin " +
		// k);
		// break;
		// }
		// }
		// }

		for (int j = 0; j < n; j++) {// bestfit bin packing wrong

			int min = Integer.MAX_VALUE;
			for (int k = 0; k < n; k++) {
				if (bins[k] + weight[j] <= c && (c - bins[k]) < min) {
					min = k;
				}
			}
			System.out.println("min is" + min);
			bins[min] += weight[j];
			System.out.println("weight " + j + " i.e " + weight[j] + " in bin " + min);

		}

		for (int l = 0; l < bins.length; l++) {
			System.out.println(bins[l] + "  ");
		}

	}
	// 7
	// 10
	// 2
	// 5
	// 4
	// 7
	// 1
	// 3
	// 8

	// weight 0 i.e 2 in bin 0
	// weight 1 i.e 5 in bin 0
	// weight 2 i.e 4 in bin 1
	// weight 3 i.e 7 in bin 2
	// weight 4 i.e 1 in bin 0
	// weight 5 i.e 3 in bin 1
	// weight 6 i.e 8 in bin 3

	// weight 0 i.e 2 in bin 0
	// weight 1 i.e 5 in bin 0
	// weight 2 i.e 4 in bin 1
	// weight 3 i.e 7 in bin 2
	// weight 4 i.e 1 in bin 0
	// weight 5 i.e 3 in bin 1
	// weight 6 i.e 8 in bin 3

}

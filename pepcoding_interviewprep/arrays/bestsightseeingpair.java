package arrays;

import java.util.Scanner;

public class bestsightseeingpair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(maxScoreSightseeingPair(arr));

	}

	public static int maxScoreSightseeingPair(int[] a) {
		int i = 0;
		int j = 1;
		int max = Integer.MIN_VALUE;
		while (j < a.length) {
			int score = a[j] + a[i] + i - j;
			if (score > max) {
				max = score;
			}
			if ((a[i] + (i - j)) > a[j]) {
				j++;
			} else {
				i = j;
				j = j + 1;
			}
		}
		return max;

	}

}

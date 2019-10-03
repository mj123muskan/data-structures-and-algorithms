package arrays;

import java.util.Scanner;

public class productexceptself {
	public static int[] productExceptSelf(int[] nums) {
		// Write your code here.
		int[] res = new int[nums.length];
		int[] lp = new int[nums.length];
		int[] rp = new int[nums.length];
		rp[nums.length - 1] = 1;
		lp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			lp[i] = lp[i - 1] * nums[i - 1];
		}

		for (int i = nums.length - 2; i >= 0; i--) {
			rp[i] = rp[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < nums.length; i++) {
			res[i] = rp[i] * lp[i];
		}
		return res;
	}

	// Don't make changes here.
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int Input[] = new int[n];
		for (int i = 0; i < n; i++) {
			Input[i] = scn.nextInt();
		}
		int ans[] = productExceptSelf(Input);
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}

}
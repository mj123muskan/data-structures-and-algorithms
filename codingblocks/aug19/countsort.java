package aug19;

import java.util.Collections;
import java.util.PriorityQueue;

public class countsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 9, 9, 8, 1, 7, 7, 3, 2, 6, 6, 5, 4, 1, 1, 5, 2, 7, 8, 1 };
		// countsort(a);
		int[] b = { 74, 367, 87, 92, 371, 544, 19, 47, 496, 382, 211, 631, 345, 912, 900 };
		radixsort(b);
		polynomial(2, 3);
	}

	public static void radixsort(int[] a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}

		}
		int x = 10;
		while (max != 0) {
			a = countsort(a, x);
			max = max / 10;
			x = x * 10;

		}
		display(a);
	}

	public static void countsort(int[] a) {
		int[] n = new int[a.length];
		int[] fmap = new int[10];
		for (int i = 0; i < a.length; i++) {
			fmap[a[i]]++;
		}

		for (int i = 1; i < fmap.length; i++) {
			fmap[i] += fmap[i - 1];
		}

		for (int i = a.length - 1; i >= 0; i--) {
			n[fmap[a[i]] - 1] = a[i];
			fmap[a[i]]--;
		}
		display(n);
	}

	public static void display(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static int[] countsort(int[] a, int index) {
		int[] n = new int[a.length];
		int[] fmap = new int[10];
		for (int i = 0; i < a.length; i++) {
			fmap[((a[i] % index) / (index / 10))]++;
		}

		for (int i = 1; i < fmap.length; i++) {
			fmap[i] += fmap[i - 1];
		}

		for (int i = a.length - 1; i >= 0; i--) {
			n[fmap[((a[i] % index) / (index / 10))] - 1] = a[i];
			fmap[((a[i] % index) / (index / 10))]--;
		}
		return n;
	}
	public static void polynomial(int x,int n)
	{
		int sum=0;
		int y=x;
		for(int i=n;i>=1;i--)
		{
			sum+=i*x;
			x=x*y;
		}
		System.out.println(sum);
	}

}

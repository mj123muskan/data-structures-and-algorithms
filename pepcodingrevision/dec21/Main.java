package dec21;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int[] a = new int[n];
			for (int h = 0; h < n; h++) {
				a[h] = scn.nextInt();
			}
			tell(a, n, k);
		}

	}

	private static void tell(int[] a, int n, int k) {
		int x = 0;
		int f = -1;
		int t = -1;
		int min = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++)// aall negative
		{
			if (a[i] >= 0) {
				t = 0;
				break;
			}
			if (a[i] > min) {
				min = a[i];
			}
		}
		if (t == -1) {
			System.out.println(min);
		} else {

			for (int i = 0; i < a.length; i++) {// all postive
				if (a[i] < 0) {
					f = 0;
					break;
				}
				x += a[i];

			}
		}
		if (f == -1) {
			System.out.println(x * k);
		} else {
			if(t!=-1 && f!=-1){
			int l = 0;
			int r = n - 1;
			int sum = 0;

			if (a[l] >= 0 && a[r] >= 0) {
				int low = l;
				int high = r;
				while (a[low] > 0 && a[high] > 0) {
					if (a[low] >= 0) {
						sum += a[low];
						low++;
					}
					if (a[high] >= 0) {
						sum += a[high];
						high--;
					}

				}
				for (int i = 0; i < n; i++) {
					if (a[i] > sum) {
						sum = a[i];
					}
				}
				System.out.println(sum);
			
			}
			} else {
				if (t != -1 && f!=-1) {
					int s = 0;
					int maxsum = Integer.MIN_VALUE;
					for (int i = 0; i < a.length; i++) {
						if (a[i] < 0) {
							if (s > maxsum) {
								maxsum = s;
							}
							s = 0;
							continue;
						}
						s += a[i];
					}

					if (s > maxsum) {
						maxsum = s;
					}

					for (int i = 0; i < n; i++) {
						if (a[i] > maxsum) {
							maxsum = a[i];
						}
					}
					System.out.println(maxsum);
				}
			}
		}

	}
}
// }else if(a[l]<0 && a[r]>=0){
//
// }else if(a[l]>=0 && a[r]<0)
// {
//
// }

// private static void tell(int[] a, int n, int k) {
// int[] b = new int[n * k];
// int y = 0;
// for (int j = 0; j < k; j++) {
// for (int i = 0; i < n; i++) {
// b[y] = a[i];
// y++;
// }
// }
// // for(int i=0;i<b.length;i++)
// // {
// // System.out.println(b[i]);
// // }
// int sum=0;
// int maxsum=Integer.MIN_VALUE;
// for(int i=0;i<b.length;i++)
// {
// if(b[i]<0)
// {
// if(sum>maxsum)
// {
// maxsum=sum;
// }
// sum=0;
// continue;
// }
// sum+=b[i];
// }
//
// if(sum>maxsum)
// {
// maxsum=sum;
// }
// System.out.println(maxsum);
// }

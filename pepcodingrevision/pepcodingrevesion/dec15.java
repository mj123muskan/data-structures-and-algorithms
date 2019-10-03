package pepcodingrevesion;

import java.util.Scanner;

public class dec15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// give an array of lights each an elemnt of array is a ,then
		// a-5=green,5=yellow,a=red,find out when they gain become green
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] b = new int[n];

		for (int i = 0; i < n; i++) {
			b[i] = scn.nextInt();
		}
		int mintime = Integer.MAX_VALUE;
		for (int light : b) {
			if (light < mintime) {
				mintime = light;

			}
		}
		int time = 2 * mintime;
		int increment = 0;
		do {
			time += increment;
			increment = areallgreen(b, time, n);
		} while (increment != 0);
		System.out.println(time);

	}

	public static int areallgreen(int[] b, int t, int n) {
		int increment =0;
		for(int light:b)
		{
			int rem=t%(2*light);
			if(rem>=light-5)
			{
				int tempincrement=2*light-rem;
				if(tempincrement>increment)
				{
					increment=tempincrement;
				}
			}
		}
		return increment;
	}

}

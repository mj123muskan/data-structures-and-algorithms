package arrays;

public class quadtraticsorted {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		int []a={2,5,8,10,15};
		int []b={10,-100,-200};
		int []res=quadratic(a, b);
		display(res);
	}
	public static void display(int []a)
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	public static int[] quadratic(int[] a, int[] b) {
		int[] res = new int[a.length];
		int left = 0;
		int right = a.length - 1;
		int i = 0;
		if (b[0] > 0) {
			i = a.length - 1;
		}

		while (left <= right) {
			int x = calculate(a[left], b);
			int y = calculate(a[right], b);
			if (x > y) {
				if (b[0] > 0) {
					res[i] = x;
					i--;
					left++;
				} else {
					res[i] = y;
					i++;
					right--;
				}
			} else {
				if (b[0] > 0) {
					res[i] = y;
					i--;
					right--;
				} else {
					res[i] = x;
					i++;
					left++;
					;
				}

			}
		}
		return res;
	}

	private static int calculate(int i, int[] b) {
		int sum = 0;
		sum += (i * i * b[0]) + (i * b[1]) + b[2];
		return sum;
	}

}

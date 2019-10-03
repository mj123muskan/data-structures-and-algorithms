package aug19;

public class mergesort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] one = { 10, 20, 30, 40, 50 };
		int[] two = { 11, 22, 33, 44, 55, 66, 77 };
		// int []a=mergetwosortedarrays(one,two);
		int[] a = { 2, 7, 5, 4, 6, 8, 9, 1 };
		int x = mergesort(a, 0, a.length - 1);
		display(a);
		System.out.println("inversion s are "+ x);

	}

	public static void display(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static int mergesort(int[] arr, int lo, int hi)// int return type to
															// count inversions
	{
		if (lo == hi) {
			return 0;

		}
		int mid = (lo + hi) / 2;
		int i1 = mergesort(arr, lo, mid);
		int i2 = mergesort(arr, mid + 1, hi);
		int i3 = merge(arr, lo, mid, hi);
		return i1+i2+i3;
	}

	private static int merge(int[] arr, int lo, int mid, int hi) {
		// TODO Auto-generated method stub
		int coun = 0;
		System.out.println("hello");
		int i = lo, j = mid + 1, k = 0;
		int[] r = new int[hi - lo + 1];
		while (i <= mid && j <= hi) {
			if (arr[i] <= arr[j]) {
				r[k] = arr[i];
				i++;
				k++;
			} else if (arr[i] > arr[j]) {
				coun+=mid-i+1;
				r[k] = arr[j];
				j++;
				k++;
			}
		}
		while (i <= mid) {
			r[k] = arr[i];
			i++;
			k++;
		}
		while (j <= hi) {
			r[k] = arr[j];
			j++;
			k++;
		}
		for (int m = 0; m < r.length; m++) {
			arr[m + lo] = r[m];
		}
		// System.out.println("hello");
		return coun;

	}

	private static int[] mergetwosortedarrays(int[] one, int[] two) {
		// TODO Auto-generated method stub
		int i = 0, j = 0, k = 0;
		int[] r = new int[one.length + two.length];
		while (i < one.length && j < two.length) {
			if (one[i] <= two[j]) {
				r[k] = one[i];
				i++;
				k++;
			} else if (one[i] > two[j]) {
				r[k] = two[j];
				j++;
				k++;
			}
		}
		while (i < one.length) {
			r[k] = one[i];
			i++;
			k++;
		}
		while (j < two.length) {
			r[k] = two[j];
			j++;
			k++;
		}
		return r;
	}

}

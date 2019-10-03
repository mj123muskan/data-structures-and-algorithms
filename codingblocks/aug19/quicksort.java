package aug19;

public class quicksort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 12, 9, 3, 8, 1, 6, 7, 4 };
		System.out.println(partitioning(a, 3));
		display(a);
//		int[] b = { 0, 4, 9, 0, 3, 0, 3, 7, 0, 1, 2, 0 };
//		movenonzerostoend(b);
//		int[] c = { 2, 1, 1, 1, 0, 2, 2, 0, 1, 2, 0, 2, 1 };
//		sort012(c);
		quicksort(a,0,a.length-1);
		display(a);
	}

	public static int partitioning(int[] a, int pivot) {
		int i = 0;
		int p = 0;
		while (i < a.length) {
			if (a[i] < a[pivot]) {
				swap(a, i, p);
				i++;
				p++;
			} else if (a[i] >= a[pivot]) {
				i++;
			}
		}
		return p;
	}

	private static void swap(int[] a, int i, int p) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[p];
		a[p] = temp;

	}

	public static void movenonzerostoend(int[] a) {
		int p = a.length - 1;
		int i = a.length - 1;
		while (i >= 0) {
			if (a[i] == 0) {
				i--;
			} else {
				swap(a, i, p);
				p--;
				i--;
			}
		}
		display(a);
	}

	public static void display(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void sort012(int[] a) {
		int i = 0;
		int p = 0;
		int hi = a.length - 1;

		while (i < a.length && i <= hi) {
			if (a[i] == 0) {
				swap(a, i, p);
				i++;
				p++;
			} else if (a[i] == 1) {
				i++;

			} else if (a[i] == 2) {
				swap(a, i, hi);

				hi--;
			}
		}
		display(a);
	}

	public static void quicksort(int[] a, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int p = partition(a, lo, hi);
		quicksort(a, lo, p - 1);
		quicksort(a, p + 1, hi);

	}

	private static int partition(int[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		int p=lo;
		int i=lo;
		int pivot=a[hi];
		
		while (i <=hi ) {
			if (a[i] <=pivot) {
				swap(a, i, p);
				i++;
				p++;
			} else if (a[i] > pivot) {
				i++;
			}
		}
		
		return p-1;
	}
}

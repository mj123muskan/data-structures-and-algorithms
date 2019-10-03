package pepcodingrevesion;

public class FenvickTree {

	public static void main(String[] args) {
		int[] arr = { 12, 10, 2, -5, 4, -6, -2, -5, 8, 9 };
		FenvickTree ft = new FenvickTree(arr);
		System.out.println(ft.getsum(2, 7));
		ft.update(3, -5);
		ft.update(6, 10);
		System.out.println(ft.getsum(2, 7));

	}

	private int[] oarr;
	private int[] farr;

	private int getLastSetBit(int i) {
		return i & -i;
	}

	public FenvickTree(int[] arr) {
		this.oarr = new int[arr.length];
		this.farr = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			update(i, arr[i]);
		}
	}

	public int getsum(int i) {
		int sum = 0;
		int pos = i + 1;
		while (pos != 0) {
			sum += farr[pos];
			int lsbofpos = getLastSetBit(pos);
			pos -= lsbofpos;
		}
		return sum;
	}

	public int getsum(int i, int j) {
		int sumtilliminus1 = getsum(i - 1);
		int sumtillj = getsum(j);
		return sumtillj - sumtilliminus1;
	}

	public void update(int i, int delta) {
		int pos = i + 1;
		while (pos < farr.length) {
			farr[pos] += delta;
			int lsbpos = getLastSetBit(pos);
			pos += lsbpos;
		}
		oarr[i] += delta;
	}

}

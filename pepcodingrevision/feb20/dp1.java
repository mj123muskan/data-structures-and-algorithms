package feb20;

public class dp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// long start = System.currentTimeMillis();
		// System.out.println(fibonnaci(44));
		// long end = System.currentTimeMillis();
		// System.out.println(end - start);

		// long start = System.currentTimeMillis();
		// System.out.println(fibmimoisez(44, new int[45]));
		// long end = System.currentTimeMillis();
		// System.out.println(end - start);

		// long start = System.currentTimeMillis();
		// System.out.println(fibtabular(44, new int[45]));
		// long end = System.currentTimeMillis();
		// System.out.println(end - start);

		// long start = System.currentTimeMillis();
		// System.out.println(countboardpath(0, 28));
		// long end = System.currentTimeMillis();
		// System.out.println(end - start);

		// long start = System.currentTimeMillis();
		// System.out.println(countboardpathmemoised(0, 28, new int[29]));
		// long end = System.currentTimeMillis();
		// System.out.println(end - start);

		// long start = System.currentTimeMillis();
		// System.out.println(countboardpathtabulated(0, 28));
		// long end = System.currentTimeMillis();
		// System.out.println(end - start);

		// long start = System.currentTimeMillis();
		// System.out.println(countmazepath(0, 0, 3, 3));
		// long end = System.currentTimeMillis();
		// System.out.println(end - start);
		//
//		long start = System.currentTimeMillis();
//		System.out.println(countmazepathtabulated(0, 0, 3, 3));
//		long end = System.currentTimeMillis();
//		System.out.println(end - start);
		
		long start = System.currentTimeMillis();
		System.out.println(countmazepathmemoised(0, 0, 3, 3, new int [4][4]));
		long end = System.currentTimeMillis();
		System.out.println(end - start);


	}

	public static int fibonnaci(int n) {// recursion
		if (n == 0 || n == 1) {
			return n;
		}
		int fbnm1 = fibonnaci(n - 1);
		int fbnm2 = fibonnaci(n - 2);
		int fn = fbnm1 + fbnm2;
		return fn;
	}

	public static int fibmimoisez(int n, int[] strg) {// dp
		if (n == 0 || n == 1) {
			return n;
		}
		if (strg[n] != 0) {
			return strg[n];
		}
		int fbnm1 = fibmimoisez(n - 1, strg);
		int fbnm2 = fibmimoisez(n - 2, strg);
		int fn = fbnm1 + fbnm2;
		strg[n] = fn;
		return fn;

	}

	public static int fibtabular(int n, int[] strg)// iterative
	{
		strg[0] = 0;
		strg[1] = 1;
		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}
		return strg[n];
	}

	public static int countboardpath(int s, int d) {// recursive
		if (s == d)
			return 1;

		if (s > d)
			return 0;
		int x = 0;
		for (int i = 1; i <= 6; i++) {
			int src = countboardpath(s + i, d);
			x += src;
		}
		return x;
	}

	public static int countboardpathmemoised(int s, int d, int[] strg) {// dp
		if (s == d)
			return 1;

		if (s > d)
			return 0;

		if (strg[s] != 0)
			return strg[s];

		int x = 0;
		for (int i = 1; i <= 6; i++) {
			int src = countboardpathmemoised(s + i, d, strg);
			x += src;
		}
		strg[s] = x;
		return x;
	}

	public static int countboardpathtabulated(int s, int d) {// iterative
		int[] strg = new int[d + 6];
		strg[d] = 1;

		for (int j = d - 1; j >= 0; j--) {
			strg[j] = strg[j + 1] + strg[j + 2] + strg[j + 3] + strg[j + 4] + strg[j + 5] + strg[j + 6];
		}
		return strg[0];
	}

	public static int countmazepath(int sr, int sc, int er, int ec) {// recursion
		if (sr == er && sc == ec) {
			return 1;
		}

		if (sr > er || sc > ec)
			return 0;

		int h = countmazepath(sr, sc + 1, er, ec);
		int v = countmazepath(sr + 1, sc, er, ec);

		return h + v;
	}

	public static int countmazepathtabulated(int sr, int sc, int er, int ec) {// iterative
		int[][] strg = new int[er + 1][ec + 1];

		strg[er][ec] = 1;
		for (int i = er; i >= 0; i--) {
			for (int j = ec; j >= 0; j--) {
				if (i != er && j != ec) {
					strg[i][j] = strg[i + 1][j] + strg[i][j + 1];// +strg[i+1][j+1]
																	// for
																	// diagnols
				} else {
					strg[i][j] = 1;
				}
			}
		}
		return strg[0][0];
	}

	public static int countmazepathmemoised(int sr, int sc, int er, int ec, int[][] strg) {
		if (sr == er && sc == ec) {
			return 1;
		}

		if (sr > er || sc > ec)
			return 0;

		if (strg[sr][sc] != 0) {
			return strg[sr][sc];
		}
		int h = countmazepath(sr, sc + 1, er, ec);
		int v = countmazepath(sr + 1, sc, er, ec);
		strg[sr][sc] = h + v;
		return h + v;
	}
}

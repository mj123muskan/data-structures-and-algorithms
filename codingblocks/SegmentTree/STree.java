package SegmentTree;

public class STree {
	static int[] ba;
	static int[] sa;

	static void preprocess() {
		int h = getlog(ba.length) + 1;
		int size = (1 << h) - 1;
		sa = new int[size];
		build(0, ba.length - 1, 0);
	}

	static void build(int ss, int se, int si) {
		if (ss == se) {
			sa[si] = ba[ss];
			return;
		}

		int mid = (ss + se) / 2;
		build(ss, mid, 2 * si + 1);
		build(mid + 1, se, 2 * si + 2);
		sa[si] = sa[2 * si + 1] + sa[2 * si + 2];

	}

	static void update(int idx, int val, int ss, int se, int si) {
		if ((ss == se) && (ss == idx)) {
			sa[si] = val;
			return;
		}

		int mid = (ss + se) / 2;
		if (idx <= mid) {
			update(idx, val, ss, mid, 2 * si + 1);
		} else {
			update(idx, val, mid + 1, se, 2 * si + 2);
		}
		sa[si] = sa[2 * si + 1] + sa[2 * si + 2];

	}

	private static int getlog(int n) {
		// TODO Auto-generated method stub
		int log = 0;
		while ((1 << log) < n) {
			log++;
		}
		return log;
	}

	static int query(int qs, int qe, int ss, int se, int si) {
		if (qs <= ss && qe >= se) {
			return sa[si];
		} else if (qs > se || qe < ss) {
			return 0;
		} else {
			int mid = (ss + se) / 2;
			int lc = query(qs, qe, ss, mid, 2 * si + 1);
			int rc = query(qs, qe, mid + 1, se, 2 * si + 2);
			return lc + rc;
		}
	}

	static void display() {
		for (int i = 0; i < sa.length; i++) {
			System.out.print(sa[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ba=new int[]{2,5,3,1,7,4,9};
		preprocess();
		display();
		System.out.println(query(2, 5, 0, ba.length-1, 0)+" "+ query(3, 6, 0, ba.length-1, 0));
		update(2, 10, 0, ba.length-1, 0);
		display();
		System.out.println(query(2, 5, 0, ba.length-1, 0)+" "+query(3, 6, 0, ba.length-1, 0));

	}

}


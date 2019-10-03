package aug19;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class august19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());

		lists.get(1).add(10);
		lists.get(1).add(20);
		lists.get(1).add(30);
		lists.get(1).add(40);

		lists.get(0).add(12);
		lists.get(0).add(14);
		lists.get(0).add(18);
		lists.get(0).add(42);

		lists.get(2).add(5);
		lists.get(2).add(7);
		lists.get(2).add(15);
		lists.get(2).add(16);

		lists.get(3).add(11);
		lists.get(3).add(17);
		lists.get(3).add(21);
		lists.get(3).add(50);
		int[] arr = { 20, 5, 17, 8, 16, 22, 42, 9, 34, 50 };
		System.out.println(mergeksortedlists(lists));
		System.out.println(getklargest(arr, 3));

	}

	public static ArrayList<Integer> mergeksortedlists(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> merged = new ArrayList<>();
		PriorityQueue<pair> pq = new PriorityQueue<>();

		for (int i = 0; i < lists.size(); i++) {
			pair p = new pair(lists.get(i).get(0), i, 0);
			pq.add(p);
		}

		while (pq.size() != 0) {
			pair d = pq.remove();
			merged.add(d.data);
			d.indexno++;

			if (d.indexno < lists.get(d.listno).size()) {
				d.data = lists.get(d.listno).get(d.indexno);
				pq.add(d);
			}

		}
		return merged;

	}

	public static class pair implements Comparable<pair> {
		int data;
		int listno;
		int indexno;

		public pair(int data, int listno, int indexno) {
			this.data = data;
			this.listno = listno;
			this.indexno = indexno;
		}

		@Override
		public int compareTo(pair p) {

			return this.data - p.data;
		}
	}

	public static ArrayList<Integer> getklargest(int[] arr, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		PriorityQueue<pair> pq = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pair p = new pair(arr[i], 0, 0);
			pq.add(p);

		}

		for (int i = k; i < arr.length; i++) {
			pair d = pq.remove();
			if (d.data < arr[i]) {
				d.data = arr[i];
			}
			pq.add(d);
		}
		for (int i = 0; i < k; i++) {
			result.add(pq.remove().data);
		}
		return result;
	}
}

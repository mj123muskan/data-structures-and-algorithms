package aug19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class pq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub4int
		int[] arr = { 2, 17, 8, 9, 3, 5, 6 };
		// kthsmallest(arr, 3);
		//int[] a = { 7, 15, 5, 22, 18, 20, 27, 35, 40, 30 };
		//ksorted(a, 2);
		ArrayList<Integer> a1=new ArrayList<>(Arrays.asList(5,15,25,35,40));
		ArrayList<Integer> a2=new ArrayList<>(Arrays.asList(11,14,22,28));
		ArrayList<Integer> a3=new ArrayList<>(Arrays.asList(2,7,17));
		ArrayList<Integer> a4=new ArrayList<>(Arrays.asList(9,12,18,24,36));
		ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
		lists.add(a1);
		lists.add(a2);
		lists.add(a3);
		lists.add(a4);
		klistsort(lists, 17, 4);
	}

	public static void kthsmallest(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}
		for (int j = k; j < arr.length; j++) {
			if (arr[j] < pq.peek()) {
				pq.remove();
				pq.add(arr[j]);
			}
		}

		System.out.println(pq.remove());
	}

	public static void ksorted(int[] a, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i <= k; i++) {
			pq.add(a[i]);

		}
		for (int j = k + 1; j < a.length; j++) {
			System.out.print(pq.remove() + " ");
			pq.add(a[j]);
		}
		while (pq.size() != 0) {
			System.out.print(pq.remove() + " ");
		}
	}

	public static class element implements Comparable<element> {
		int val;
		int li;
		int di;

		element(int val, int li, int di) {
			this.val = val;
			this.li = li;
			this.di = di;
		}

		@Override
		public int compareTo(element o) {
			// TODO Auto-generated method stub
			return this.val-o.val;
		}
	}

//	public static void klistsort(ArrayList<ArrayList<Integer>> lists, int n, int k) {
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		HashMap<Integer, element> h = new HashMap<>();
//		for (int i = 0; i < k; i++) {
//			for (int j = 0; j < lists.get(i).size(); j++) {
//				element e = new element(lists.get(i).get(j), i, j);
//				h.put(lists.get(i).get(j), e);
//			}
//		}
//		for (int i = 0; i < k; i++) {
//			pq.add(lists.get(i).get(0));
//		}
//
//		while (pq.size() != 0) {
//			int x = pq.peek();
//			int cl = h.get(x).li;
//			int ci = h.get(x).di;
//			System.out.print(pq.remove() + " ");
//			if(ci+1<lists.get(cl).size()){
//			pq.add(lists.get(cl).get(ci + 1));
//			}
//		}
//
//	}
	
	
	public static void klistsort(ArrayList<ArrayList<Integer>> lists, int n, int k) {
		PriorityQueue<element> pq = new PriorityQueue<>();
		
		for (int i = 0; i < k; i++) {
			
			element e = new element(lists.get(i).get(0), i, 0);
			pq.add(e);
		}

		while (pq.size() != 0) {
			int x = pq.peek().val;
			int cl = pq.peek().li;
			int ci = pq.peek().di;;
			System.out.print(pq.remove().val + " ");
			if(ci+1<lists.get(cl).size()){
			pq.add(new element(lists.get(cl).get(ci+1), cl, ci+1));
			}
		}

	}
}

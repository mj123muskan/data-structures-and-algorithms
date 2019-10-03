package aug20;

import java.util.ArrayList;

public class clientgenerics {

	public static void main(String[] args) throws Exception {

		// linkedlist<String> ll = new linkedlist<>();
		// ll.addlast("assDdd");
		// ll.addlast("khdgchj");
		// ll.display();
		//
		// int arr[] = {6876,8778,878,87,8,8} ;
		// System.out.println(getklargest(arr, 3));
	//	HashMap<String, Integer> map = new HashMap<>();
//		map.put("india", 120);
//		map.put("china", 200);
//		map.put("us", 25);
//		map.put("uk", 20);
//		map.put("nigeria", 50);
//		map.display();
//		System.out.println(
//				"..............................................................................................");
//		map.put("india", 300);
//		map.put("afgan", 18);
//		map.display();
//		System.out.println(
//				"............................................................................................");
//		System.out.println(map.containskey("india"));
//		System.out.println(map.containskey("abs"));
//		System.out.println(".....................................................................................");
//		System.out.println(map.get("india"));
//		System.out.println(map.get("abs"));
//		System.out.println(".....................................................................................");
//		System.out.println(map.remove("india"));
//		System.out.println(map.remove("abs"));
//		System.out.println(".....................................................................................");
//		System.out.println(map.keyset());
//		System.out.println(".....................................................................................");
//		map.put("france", 12);
//		map.put("denmark", 20);
//		map.display();
//		System.out.println(".....................................................................................");
//		map.put("singapore", 13);
//		map.put("nepal", 90);
//		map.display();
//		System.out.println(".....................................................................................");
		
		HEncoder s=new HEncoder("aaaabbabaabakhdkjchjlyatdeliwhedhkjgd cmugfbfvhjbuknawyaeutsgqwudhjkasdgincowetruaweefiulwgdfiuagweiufigaweiufgaqgfpaqgwiufgwrimfbq23kyweifh");
System.out.println(s.compress("my name is muskan"));
System.out.println(s.decompress("1000010000101011000101110111000011001010110011001000000101100100001101110000011011011010111"
));

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
		Heap<pair> pq = new Heap<>();
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

package hashmap;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class huffman {
	public static class Node implements Comparable<Node> {// not working
		String data;
		int freq;
		Node left;
		Node right;

		public Node(String data, int freq, Node left, Node right) {
			this.data = data;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Node o) {
			return this.freq - o.freq;
		}
	}

	private static void Huffman(String str, int[] arr) {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		HashMap<Character, String> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(str.charAt(i), "");
			pq.add(new Node(Character.toString(str.charAt(i)), arr[i], null, null));
		}

		while (pq.size() > 1) {
			Node x = pq.remove();
			Node y = pq.remove();
			Node merged = new Node(x.data + y.data, x.freq + y.freq, x, y);
			pq.add(merged);
		}

		Node root = pq.remove();

		preorder(root, map, "");
		String[] a = new String[map.size()];
		for (int i = 0; i < str.length(); i++) {
			a[i] = map.get(str.charAt(i));
			// System.out.print( + ' ');
		}
		Arrays.sort(a);

		for (int i = 0; i < a.length; i++) {

			System.out.print(a[i] + ' ');
		}
	}

	public static void preorder(Node node, HashMap<Character, String> map, String s) {
		if (node.left == null && node.right == null) {
			map.put(node.data.charAt(0), s);
			return;
		}
		preorder(node.left, map, s + "0");
		preorder(node.right, map, s + "1");
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// String str = scn.next();
		// int[] arr = new int[str.length()];
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = scn.nextInt();
		// }
		// Huffman(str, arr);
		System.out.println(Integer.parseInt("101"));
	}

}

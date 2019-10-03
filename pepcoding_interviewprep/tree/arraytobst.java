package tree;

import java.util.Scanner;

public class arraytobst {

	public static void BSTFormation(int[] arr, int i, int j) {

		Node root = arraytobst(arr, i, j);
		// System.out.println("......................");
		preorder(root);

	}

	public static void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}

	public static Node arraytobst(int[] a, int i, int j) {
		if (i == j) {
			return new Node(a[i], null, null);
		}

		int mid = (i + j) / 2;
		// System.out.print(mid+" ");

		Node l = mid != i ? arraytobst(a, i, mid - 1) : null;

		Node r = mid != j ? arraytobst(a, mid + 1, j) : null;

		Node rr = new Node(a[mid], l, r);
		return rr;
	}

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node l, Node r) {
			this.data = data;
			left = l;
			right = r;
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		BSTFormation(arr, 0, arr.length - 1);
	}

}
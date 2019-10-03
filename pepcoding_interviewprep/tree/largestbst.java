package tree;

import java.util.*;

public class largestbst {

	// TreeNode class for a node of a Binary Search Tree
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = right = null;
		}
	}

	// This is a functional problem. You have to complete this function.
	// It takes as input the root node of the given tree. It should return the
	// number of
	// nodes in the largest subtree which is a BST.
	public static int largestBst(TreeNode node) {
		// write your code here.

		pair r = largestbst(node);
		return size;

	}

	static int size = 0;
	static TreeNode rr = null;

	public static pair largestbst(TreeNode node) {
		if (node == null) {
			return new pair(true, 0);
		}
		pair l = largestbst(node.left);
		pair r = largestbst(node.right);
		boolean lx = false;
		boolean ly = false;

		if (node.left != null) {
			if (node.val > node.left.val) {
				lx = true;
			}
		} else {
			lx = true;
		}

		if (node.right != null) {
			if (node.val < node.right.val) {
				ly = true;
			}
		} else {
			ly = true;
		}

		boolean x = (l.isbst && r.isbst) && lx && ly;

		pair mp = new pair(x, l.size + r.size + 1);
		if (mp.isbst) {
			if (mp.size > size) {
				size = mp.size;
				rr = node;
			}
		}
		return mp;
	}

	public static class pair {
		boolean isbst;
		int size;

		public pair(boolean g, int x) {
			isbst = g;
			size = x;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().trim();
		Integer[] treeArr = inputSplitSpace(input);
		TreeNode root = createTree(treeArr);
		System.out.println(largestBst(root));
	}

	// utility function to display a binary tree.
	public static void display(TreeNode node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left == null ? "." : node.left.val;
		str += " <= " + node.val + " => ";
		str += node.right == null ? "." : node.right.val;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	// utility function, don't change its code
	public static Integer[] inputSplitSpace(String str) {
		String[] sArr = str.split(" ");
		Integer[] arr = new Integer[sArr.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sArr[i].equals("null") ? null : Integer.parseInt(sArr[i]);
		}
		return arr;
	}

	// utility function to create a tree, don't change its code.
	public static TreeNode createTree(Integer[] arr) {
		ArrayDeque<TreeNode> que = new ArrayDeque<>();
		TreeNode root = new TreeNode(arr[0]);
		que.addLast(root);
		int i = 1;
		while (!que.isEmpty() && i < arr.length) {
			TreeNode nn = que.removeFirst();

			if (i < arr.length && arr[i] != null) {
				TreeNode n = new TreeNode(arr[i]);
				nn.left = n;
				que.addLast(n);
			}
			i++;

			if (i < arr.length && arr[i] != null) {
				TreeNode n = new TreeNode(arr[i]);
				nn.right = n;
				que.addLast(n);
			}
			i++;
		}

		return root;
	}

}
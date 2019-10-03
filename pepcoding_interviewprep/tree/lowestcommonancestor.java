package tree;

import java.util.*;
import java.io.*;

class TreeNode {
	int data;
	TreeNode left, right;

	TreeNode(int item) {
		data = item;
		left = right = null;
	}
}

class BinaryTree {

	public TreeNode lca(TreeNode root, int n1, int n2) {
		if (root == null) {
			return null;
		}
		if (root.data == n1 || root.data == n2) {
			return root;
		}

		TreeNode le = lca(root.left, n1, n2);
		TreeNode re = lca(root.right, n1, n2);
		if (le != null && re != null) {
			return root;
		}
		return (le != null) ? le : re;
	}

}

public class lowestcommonancestor {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, TreeNode> m = new HashMap<Integer, TreeNode>();
		int n = sc.nextInt();
		TreeNode root = null;
		while (n > 0) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			char lr = sc.next().charAt(0);
			TreeNode parent = m.get(n1);
			if (parent == null) {
				parent = new TreeNode(n1);
				m.put(n1, parent);
				if (root == null)
					root = parent;
			}
			TreeNode child = new TreeNode(n2);
			if (lr == 'L')
				parent.left = child;
			else
				parent.right = child;
			m.put(n2, child);
			n--;
		}

		int firstNode = sc.nextInt();
		int secondNode = sc.nextInt();

		BinaryTree bt = new BinaryTree();
		TreeNode lca = bt.lca(root, firstNode, secondNode);
		System.out.println(lca.data);

	}
}

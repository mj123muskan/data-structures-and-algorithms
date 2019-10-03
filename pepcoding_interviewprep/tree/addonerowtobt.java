package tree;

import java.util.*;

public class addonerowtobt {

	public static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode r = new TreeNode(v);
			r.left = root;
			return r;
		}
		LinkedList<pair> q = new LinkedList<>();
		q.addLast(new pair(root, 1));

		while (q.size() != 0) {
			pair p = q.removeFirst();
			if (p.l == d) {
				break;
			}
			if (p.l == d - 1) {
				TreeNode le = null;
				TreeNode re = null;
				if (p.n.left != null) {
					le = p.n.left;
				}
				if (p.n.right != null) {
					re = p.n.right;
				}
				p.n.left = new TreeNode(v);
				p.n.right = new TreeNode(v);
				p.n.left.left = le;
				p.n.right.right = re;

			}
			if (p.n.left != null) {
				q.addLast(new pair(p.n.left, p.l + 1));
			}
			if (p.n.right != null) {
				q.addLast(new pair(p.n.right, p.l + 1));
			}
		}
		return root;

	}

	public static class pair {
		TreeNode n;
		int l;

		public pair(TreeNode nn, int ll) {
			n = nn;
			l = ll;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v, d;
		String line1 = sc.nextLine().trim();
		String line2 = sc.nextLine().trim();
		Integer[] vd = inputSplitSpace(line1);
		v = vd[0];
		d = vd[1];
		Integer[] treeArr = inputSplitSpace(line2);
		TreeNode root = createTree(treeArr);
		TreeNode res = addOneRow(root, v, d);
		display(res);

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

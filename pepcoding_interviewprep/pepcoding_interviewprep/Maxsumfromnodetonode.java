package pepcoding_interviewprep;

import java.util.ArrayDeque;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Maxsumfromnodetonode {

	public static pair MaxPathSum(TreeNode node) {
		if (node == null) {
			pair p = new pair();
			p.sum = 0;
			return p;
		}
		pair my = new pair();
		pair l = MaxPathSum(node.left);
		pair r = MaxPathSum(node.right);
		if (node.val >= 0) {
			if (l.isdisconnected && r.isdisconnected) {
				my.sum = Math.max(l.sum, Math.max(r.sum, node.val));
				if (my.sum == node.val) {
					my.isdisconnected = false;
				} else {
					my.isdisconnected = true;
				}
			} else if (l.isdisconnected && !r.isdisconnected) {
				my.sum = Math.max(l.sum, (r.sum + node.val));
				if (my.sum == l.sum) {
					my.isdisconnected = true;
				} else {
					my.isdisconnected = false;
				}
			} else if (!l.isdisconnected && r.isdisconnected) {
				my.sum = Math.max(r.sum, (l.sum + node.val));
				if (my.sum == r.sum) {
					my.isdisconnected = true;
				} else {
					my.isdisconnected = false;
				}
			} else if (!l.isdisconnected && !r.isdisconnected) {
				my.sum = l.sum + r.sum + node.val;
				my.isdisconnected = false;
			}
		} else {
			my.sum = Math.max(l.sum, r.sum);
			my.isdisconnected = true;
		}
		return my;
	}

	public static class pair {
		int sum;
		boolean isdisconnected;

	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int data, TreeNode left, TreeNode right) {
			this.val = data;
			this.left = left;
			this.right = right;
		}

		public TreeNode(int data) {
			this.val = data;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();

			sb.append(left != null ? left.val : ".");
			sb.append(" -> " + val + " <- ");
			sb.append(right != null ? right.val : ".");
			sb.append("\n");

			if (left != null)
				sb.append(left);
			if (right != null)
				sb.append(right);

			return sb.toString();
		}
	}

	// constructor.=====================================================

	public static TreeNode constructor_levelOderSerailize(Integer[] arr) {
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

	// generalUtil.============================================

	public static Integer[] inputSplitSpace(String str) {
		String[] sArr = str.split(" ");
		Integer[] arr = new Integer[sArr.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sArr[i].equals("null") ? null : Integer.parseInt(sArr[i]);
		}
		return arr;
	}

	// ================================================================================

	public static void solve() {
		Integer[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		// System.out.println(root.toString());
		pair p = MaxPathSum(root);
		System.out.println(p.sum);

	}

}

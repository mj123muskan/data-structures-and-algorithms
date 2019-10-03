package tree;

import java.util.*;

class TreeNode {//tle
	int data;
	TreeNode left;
	TreeNode right;

	TreeNode(int d) {
		data = d;
		left = null;
		right = null;
	}
}

class LinkedListNode {
	int data;
	LinkedListNode next;

	LinkedListNode(int d) {
		data = d;
		next = null;
	}
}

class BinaryTree {

	public TreeNode convert(LinkedListNode head, TreeNode node) {

		LinkedList<TreeNode> q = new LinkedList<>();
		TreeNode root = new TreeNode(head.data);
		head = head.next;

		q.addLast(root);
		while (q.size() != 0) {
			TreeNode rp = q.removeFirst();

			LinkedListNode l = null;
			if (head != null) {
				l = head;
			}
			LinkedListNode r = null;
			if (head!=null && head.next != null) {
				r = head.next;
			}
			if (head != null && head.next != null) {
				head = head.next.next;
			}
			if (rp.left == null) {
				if (l != null) {
					TreeNode le = new TreeNode(l.data);
					rp.left = le;
					q.addLast(le);
				} else {
					rp.left = null;
				}

			}

			if (rp.right == null) {
				if (r != null) {
					TreeNode re = new TreeNode(r.data);
					rp.right = re;
					q.addLast(re);
				} else {
					rp.right = null;
				}
			}

		}
		return root;

	}

}

public class btfromll {
	static LinkedListNode lhead;
	static Queue<TreeNode> queue = new LinkedList<TreeNode>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeNode node = null;
		lhead = null;
		LinkedListNode head = null;
		while (!queue.isEmpty()) {
			queue.poll();
		}
		int n = sc.nextInt();
		if (n != 0) {
			btfromll llist = new btfromll();
			int a1 = sc.nextInt();
			head = new LinkedListNode(a1);
			llist.addToTheLast(head);
			lhead = head;
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new LinkedListNode(a));
			}
		}
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.convert(lhead, node);
		levelOrder(root, n);
	}

	public static void levelOrder(TreeNode root, int n) {
		queue.add(root);
		while (!queue.isEmpty() && n-- > 0) {
			TreeNode proot = queue.remove();
			if (proot.left != null) {
				queue.add(proot.left);
			}
			if (proot.right != null) {
				queue.add(proot.right);
			}
			System.out.print(proot.data + " ");
		}
	}

	public void addToTheLast(LinkedListNode head) {
		if (lhead == null)
			lhead = head;
		else {
			LinkedListNode temp = lhead;
			while (temp.next != null)
				temp = temp.next;
			temp.next = head;
		}
	}
}

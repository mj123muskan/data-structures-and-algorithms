package tree;

import java.util.*;

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

class BinaryTree {

	int getMaxWidth(Node root) {
		LinkedList<Node> q = new LinkedList<>();
		q.add(root);
		int max = Integer.MIN_VALUE;
		while (q.size() != 0) {
			int count = q.size();
			if (count > max) {
				max = count;
			}

			while (count-- > 0) {
				Node x = q.removeFirst();
				if (x.left != null) {
					q.add(x.left);
				}
				if (x.right != null) {
					q.add(x.right);
				}
			}

		}

		return max;
	}

}

public class maxwidth {
	public static void insert(Node root, int a, int a1, char lr) {
		if (root == null) {
			return;
		}
		if (root.data == a) {
			switch (lr) {
			case 'L':
				root.left = new Node(a1);
				break;
			case 'R':
				root.right = new Node(a1);
				break;
			}
			return;
		}
		insert(root.left, a, a1, lr);
		insert(root.right, a, a1, lr);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n == 0) {
			System.out.println(0);

		}
		Node root = null;
		for (int i = 0; i < n; i++) {

			int a = sc.nextInt();
			int a1 = sc.nextInt();

			char lr = sc.next().charAt(0);

			if (i == 0) {

				root = new Node(a);

				switch (lr) {

				case 'L':
					root.left = new Node(a1);
					break;
				case 'R':
					root.right = new Node(a1);
					break;
				}
			} else {
				insert(root, a, a1, lr);
			}
		}

		BinaryTree g = new BinaryTree();
		System.out.println(g.getMaxWidth(root));

	}
}

package tree;

import java.util.*;

class TreeNode {
	int key;
	TreeNode left, right;

	public TreeNode(int key) {
		this.key = key;
		left = right = null;
	}
}

class BinaryTree {
	static ArrayList<Integer> psf = new ArrayList<>();
	static ArrayList<Integer> best = new ArrayList<>();

	public int longestConsecutive(TreeNode node) {
		longestConsecutivett(node);
		
	
		return best.size();
	}

	public void longestConsecutivett(TreeNode node) {
		if (node == null) {

			return;
		}
		if (psf.size() == 0 || node.key > psf.get(psf.size() - 1)) {
			psf.add(node.key);

			if (psf.size() > best.size()) {
				best = new ArrayList<>(psf);
			}

			longestConsecutive(node.left);
			longestConsecutive(node.right);
			psf.remove(psf.size() - 1);

		} else {
			ArrayList<Integer> temp = new ArrayList<>(psf);
			psf = new ArrayList<>();
			psf.add(node.key);

			if (psf.size() > best.size()) {
				best = new  ArrayList<>(psf);
			}
			

			longestConsecutive(node.left);
			longestConsecutive(node.right);
			psf = new ArrayList<>(temp);
		}

	}

}

public class Main {

	public static void insert(TreeNode root, int a1, int a2, char ch) {
		if (root == null)
			return;
		if (root.key == a1) {
			switch (ch) {
			case 'L':
				root.left = new TreeNode(a2);
				break;
			case 'R':
				root.right = new TreeNode(a2);
				break;
			}
		} else {
			insert(root.left, a1, a2, ch);
			insert(root.right, a1, a2, ch);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		TreeNode root = null;
		if (n == 0) {
			System.out.println();
		}
		for (int i = 0; i < n; i++) {
			int a1 = sc.nextInt();
			int a2 = sc.nextInt();
			char ch = sc.next().charAt(0);
			if (root == null) {
				root = new TreeNode(a1);
				switch (ch) {
				case 'L':
					root.left = new TreeNode(a2);
					break;
				case 'R':
					root.right = new TreeNode(a2);
					break;
				}
			} else {
				insert(root, a1, a2, ch);
			}
		}
		BinaryTree bt = new BinaryTree();

		System.out.println(bt.longestConsecutive(root));
	}

}

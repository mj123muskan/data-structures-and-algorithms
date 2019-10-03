package august5;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class bst {
	class Node {
		int data;
		Node left;
		Node right;
	}

	private class heapmover {
		Node node;
		int sum = 0;
	}

	private Node root;
	int size;

	public int size() {
		return size;
	}

	public void display() {

		display(root);

	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String str = getString(node);
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	private String getString(Node node) {
		String rv = "";
		if (node.left != null) {
			rv = rv + node.left.data + " => ";
		} else {
			rv = rv + ". => ";
		}

		rv = rv + node.data;

		if (node.right != null) {
			rv = rv + " <= " + node.right.data;
		} else {
			rv = rv + " <= .";
		}

		return rv;
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}
		int ls = size2(node.left);
		int rs = size2(node.right);
		return ls + rs + 1;
	}

	public int max() {
		return max(root);
	}

	public int min() {
		return min(root);
	}

	private int max(Node node) {
		if (node.right == null) {
			return node.data;
		} else {
			return max(node.right);

		}
	}

	private int min(Node node) {
		if (node.left == null) {
			return node.data;
		} else {
			return min(node.left);

		}
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		int ls = height(node.left);
		int rs = height(node.right);

		if (ls > rs) {
			return ls + 1;
		} else {
			return rs + 1;
		}

	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (data < node.data) {
			return find(node.left, data);
		} else if (data > node.data) {
			return find(node.right, data);
		} else {
			return true;
		}

	}

	public void preO() {
		preO(this.root);
	}

	private void preO(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		preO(node.left);
		preO(node.right);
	}

	public void postO() {
		postO(this.root);
	}

	private void postO(Node node) {
		if (node == null) {
			return;
		}

		postO(node.left);
		postO(node.right);
		System.out.println(node.data);
	}

	public void InO() {
		InO(this.root);
	}

	private void InO(Node node) {
		if (node == null) {
			return;
		}

		InO(node.left);
		System.out.println(node.data);
		InO(node.right);

	}

	private class pair {
		Node node;
		boolean selfdone;
		boolean leftdone;
		boolean rightdone;

	}

	private void preOI(Node node) {
		Stack<pair> stack = new Stack<>();
		pair Pair = new pair();

		Pair.node = root;

		stack.push(Pair);

		while (stack.size() != 0) {
			pair topPair = stack.peek();
			if (topPair.selfdone == false) {
				topPair.selfdone = true;
				System.out.print(topPair.node.data + " , ");
			} else if (topPair.leftdone == false) {
				topPair.leftdone = true;
				if (topPair.node.left != null) {
					pair leftpair = new pair();

					leftpair.node = topPair.node.left;

					stack.push(leftpair);
				}
			} else if (topPair.rightdone == false) {
				topPair.rightdone = true;

				if (topPair.node.right != null) {
					pair righpair = new pair();

					righpair.node = topPair.node.right;

					stack.push(righpair);
				}
			}

			else {
				stack.pop();
			}
		}
	}

	public void preOI() {
		preOI(root);
	}

	private void postOI(Node node) {
		Stack<pair> stack = new Stack<>();
		pair Pair = new pair();

		Pair.node = root;

		stack.push(Pair);

		while (stack.size() != 0) {
			pair topPair = stack.peek();
			if (topPair.leftdone == false) {
				topPair.leftdone = true;
				if (topPair.node.left != null) {
					pair leftpair = new pair();

					leftpair.node = topPair.node.left;

					stack.push(leftpair);
				}
			} else if (topPair.rightdone == false) {
				topPair.rightdone = true;

				if (topPair.node.right != null) {
					pair righpair = new pair();

					righpair.node = topPair.node.right;

					stack.push(righpair);
				}
			} else if (topPair.selfdone == false) {
				topPair.selfdone = true;
				System.out.print(topPair.node.data + " , ");

			}

			else {
				stack.pop();
			}
		}
	}

	public void postOI() {
		postOI(root);
	}

	private void InOI(Node node) {
		Stack<pair> stack = new Stack<>();
		pair Pair = new pair();

		Pair.node = root;

		stack.push(Pair);

		while (stack.size() != 0) {
			pair topPair = stack.peek();
			if (topPair.leftdone == false) {
				topPair.leftdone = true;
				if (topPair.node.left != null) {
					pair leftpair = new pair();

					leftpair.node = topPair.node.left;

					stack.push(leftpair);
				}
			} else if (topPair.selfdone == false) {
				topPair.selfdone = true;
				System.out.print(topPair.node.data + " , ");

			} else if (topPair.rightdone == false) {
				topPair.rightdone = true;

				if (topPair.node.right != null) {
					pair righpair = new pair();

					righpair.node = topPair.node.right;

					stack.push(righpair);
				}
			} else {
				stack.pop();
			}
		}
	}

	public void IntOI() {
		InOI(root);
	}

	public void levelO() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);

		while (queue.size() != 0) {
			Node temp = queue.removeFirst();

			System.out.println(temp.data + "  ,");

			if (temp.left != null) {
				queue.addLast(temp.left);
			}
			if (temp.right != null) {
				queue.addLast(temp.right);
			}

		}

	}

	public void levelOlw() {
		LinkedList<Node> cl = new LinkedList<>();
		LinkedList<Node> nl = new LinkedList<>();
		cl.addLast(root);

		while (cl.size() != 0) {
			Node temp = cl.removeFirst();

			System.out.println(temp.data + "  ,");
			if (temp.left != null) {
				nl.addLast(temp.left);
			}
			if (temp.right != null) {
				nl.addLast(temp.right);
			}

			if (cl.size() == 0) {
				cl = nl;
				nl = new LinkedList<>();
				System.out.println();

			}

		}

	}

	public int diameter() {
		return diameter(this.root);

	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int ld = diameter(node.left);
		int rd = diameter(node.right);

		int lh = height(node.left);
		int rh = height(node.right);

		int fraud = lh + rh + 2;

		return Math.max(ld, Math.max(fraud, rd));
	}

	public int diameterBtr() {
		Diapair pair = diameterBtr(root);
		return pair.diameter;
	}

	private Diapair diameterBtr(Node node) {
		if (node == null) {
			Diapair bp = new Diapair();
			bp.diameter = 0;
			bp.height = -1;
			return bp;
		}
		Diapair diameter = new Diapair();
		Diapair lpair = diameterBtr(node.left);
		Diapair rpair = diameterBtr(node.right);

		Diapair mp = new Diapair();

		mp.height = Math.max(lpair.height, rpair.height) + 1;
		mp.diameter = Math.max(lpair.height + rpair.height + 2, Math.max(lpair.diameter, rpair.diameter));
		return mp;
	}

	private class Diapair {
		int diameter;
		int height;
	}

	public boolean Isbalance() {
		balpair pair = Isbalance(root);
		return pair.balance;
	}

	private balpair Isbalance(Node node) {
		if (node == null) {
			balpair bp = new balpair();
			bp.balance = true;
			bp.height = -1;
			return bp;
		}

		balpair lpair = Isbalance(node.left);
		balpair rpair = Isbalance(node.right);

		balpair mp = new balpair();

		mp.height = Math.max(lpair.height, rpair.height) + 1;

		if (lpair.balance == false || rpair.balance == false) {
			mp.balance = false;
		} else if (Math.abs(lpair.height - rpair.height) > 1) {
			mp.balance = false;
		} else {
			mp.balance = true;
		}
		return mp;
	}

	private class balpair {
		boolean balance;
		int height;
	}

	public bst(int[] sa) {
		this.root = this.construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int lo, int hi) {
		if (lo > hi) {
			return null;
		}

		int mid = (lo + hi) / 2;

		Node node = new Node();
		this.size++;

		node.data = sa[mid];

		node.left = this.construct(sa, lo, mid - 1);
		node.right = this.construct(sa, mid + 1, hi);

		return node;

	}

	// private void rwsol(Node node,heapmover h){
	// if(node==null)
	// {
	// return;
	// }
	// heapmover mover=new heapmover();
	// rwsol(node.right,mover);
	// int temp=node.data;
	// node.data =mover.sum ;
	// mover.sum+=temp;
	// rwsol(node.left,mover);
	//
	// }
	//
	//
	// public void rwsol(){
	// heapmover h=new heapmover();
	// rwsol(root,h);
	// }

	public void pir(int lo, int hi) {
		pir(lo, hi, root);
	}

	private void pir(int lo, int hi, Node node) {
		if (node == null) {
			return;
		}
		if (node.data >= lo && node.data <= hi) {
			System.out.println(node.data);
			pir(lo, hi, node.left);
			pir(lo, hi, node.right);
		} else if (node.data < lo) {
			pir(lo, hi, node.right);
		} else if (node.data < lo) {
			pir(lo, hi, node.left);
		}

	}

	public void add(int data) {
		add(root, data);
	}

	private void add(Node node, int data) {
		if (data > node.data && node.right != null) {
			add(node.right, data);
		} else if (data < node.data && node.left != null) {
			add(node.left, data);
		} else if (data < node.data && node.left == null) {
			node.left = new Node();
			node.left.data = data;
			this.size++;
		} else if (data > node.data && node.right == null) {
			node.right = new Node();
			node.right.data = data;
			this.size++;

		}
	}

	public void remove(int data) {
		remove(root, null, true, data);
	}

	private void remove(Node child, Node parent, boolean ilc, int data) {
		if (data > child.data) {
			remove(child.right, child, false, data);
		} else if (data < child.data) {
			remove(child.left, child, true, data);
		} else {
			if (child.left != null && child.right != null) {
				int lmax = max(child.left);
				child.data = lmax;
				remove(child.left, child, true, lmax);
			} else {
				if (ilc == true) {
					parent.left = child.left != null ? child.left : child.right;
				} else if (ilc == false) {
					parent.right = child.left != null ? child.left : child.right;
				}
			}

		}

	}

}

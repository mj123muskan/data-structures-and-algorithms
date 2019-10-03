package pepcodingrevesion;

public class SegmentTree {
	private class Node {
		int data;
		Node left;
		Node right;
		int ssi;// segment start index
		int sei;// segemnt end index
	}

	private Node root;

	public SegmentTree(int[] arr) {
		this.root = this.construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {
		if (lo == hi) {

			Node n = new Node();
			n.data = arr[lo];
			n.left = null;
			n.right = null;
			n.ssi = lo;
			n.sei = lo;
			return n;
		}
		int mid = (lo + hi) / 2;
		Node temp = new Node();
		temp.ssi = lo;
		temp.sei = hi;
		temp.left = construct(arr, lo, mid);
		temp.right = construct(arr, mid + 1, hi);
		temp.data = temp.left.data + temp.right.data;
		return temp;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			System.out.print("  [" + node.left.data + "@" + node.left.ssi + "to " + node.left.sei + "]  ");
		} else {
			System.out.print(".");
		}
		System.out.print("  <=[" + node.data + "@" + node.ssi + "to " + node.sei + "]=> ");
		if (node.right != null) {
			System.out.print("  [" + node.right.data + "@" + node.right.ssi + " to" + node.right.sei + "]  ");
		} else {
			System.out.print(".");
		}
		System.out.println();
		display(node.left);
		display(node.right);

	}

	public int getsum(int qsi, int qei) {
		return getsum(root, qsi, qei);
	}

	private int getsum(Node node, int qsi, int qei) {
		if (qsi <= node.ssi && qei >= node.sei) {
			return node.data;
		} else if (qsi > node.sei || qei < node.ssi) {
			return 0;
		} else// paRTIAL overlap
		{
			int li = getsum(node.left, qsi, qei);
			int ri = getsum(node.right, qsi, qei);
			return li + ri;

		}

	}

	public void update(int i, int delta) {
		 update(root, i, delta);
	}

	private void  update(Node node, int i, int delta) {
		

if(	i>=node.ssi && i<=node.sei)
{
	if(node.sei==node.ssi)
	{
		node.data+=delta;
		return;
	}
	else
	{
		update(node.left,i,delta);
		update(node.right,idelta);
		node.data=node.left
	}
}
}

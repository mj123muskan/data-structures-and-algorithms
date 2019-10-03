package july29;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class generictree {

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

	}

	private Node root;
	private int size;

	public generictree() {
		Scanner scn = new Scanner(System.in);
		root = takeinput(null, 0, scn);
	}

	public Node takeinput(Node parent, int childindex, Scanner scn) {
		if (parent == null) {
			System.out.println("enter data for root");
		} else {
			System.out.println("enter " + childindex + " th child of" + parent.data);
		}
		int data = scn.nextInt();
		Node child = new Node();
		child.data = data;
		size++;

		System.out.println("how many grandchildren for" + child.data);
		int numgc = scn.nextInt();

		for (int i = 0; i < numgc; i++) {
			Node gc = takeinput(child, i, scn);
			child.children.add(gc);

		}
		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isempty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	private void display(Node node) {
		String result = getStringforNode(node);
		System.out.println(result);
		for (int i = 0; i < node.children.size(); i++) {
			display(node.children.get(i));
		}
	}

	private String getStringforNode(Node node) {
		String rv = node.data + " => ";
		for (Node child : node.children) {
			rv += child.data + ",";
		}
		rv += ".";
		return rv;
	}

	public void display() {
		display(root);
	}

	public int size2() {
		return this.size2(root);

	}

	private int size2(Node node) {
		int size = 0;
		for (Node child : node.children) {
			int csize = size2(child);
			size += csize;
		}
		size = size + 1;
		return size;
	}

	public int max2() {
		return this.max2(root);

	}

	private int max2(Node node) {
		int max = node.data;
		for (Node child : node.children) {
			int maxc = max2(child);
			if (maxc > max) {
				max = maxc;
			}
		}
		return max;
	}

	public int hieght() {
		return this.hieght(root);

	}

	private int hieght(Node node) {
		int max = -1;
		for (Node child : node.children) {
			int maxh = hieght(child);
			if (maxh > max) {
				max = maxh;
			}
		}
		max += 1;
		return max;
	}

	public boolean find(int data) {
		return this.find(data, root);
	}

	private boolean find(int data, Node node) {
		if (data == node.data) {
			return true;
		}

		for (Node child : node.children) {
			boolean fc = find(data, child);

			if (fc == true) {
				return true;
			}

		}

		return false;
	}

	public void printatdepth(int targetdepth) {
		printatdepth(root, targetdepth, 0);
	}

	private void printatdepth(Node node, int targetdepth, int currentdepth) {

		if (currentdepth == targetdepth) {
			System.out.println(node.data);
			return;
		}
		for (Node child : node.children) {
			printatdepth(child, targetdepth, currentdepth + 1);

		}

	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {
		for (Node child : node.children) {
			mirror(child);

		}
		int li = 0;
		int ri = node.children.size() - 1;
		while (li < ri) {
			Node right = node.children.get(ri);
			Node left = node.children.get(li);

			node.children.set(li, right);
			node.children.set(ri, left);
			li++;
			ri--;
		}

	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node node) {
		for (Node child : node.children) {
			linearize(child);

		}
		while (node.children.size() > 1) {
			Node removed = node.children.remove(1);
			Node zerotail = node.children.get(0);
			while (zerotail.children.size() != 0) {
				zerotail = zerotail.children.get(0);
			}
			zerotail.children.add(removed);
		}

	}

	public void flatten() {
		flatten(root);
	}

	private void flatten(Node node) {
		for (Node child : node.children) {
			flatten(child);

		}
		ArrayList<Node> nlc = new ArrayList<>();
		for (Node child : node.children) {
			nlc.add(child);
			for (Node grandc : child.children) {
				nlc.add(grandc);

			}
			child.children = new ArrayList<>();
		}
		node.children = nlc;
	}

	public void removeleaf() {
		removeleaf(root);
	}

	private void removeleaf(Node node) {
		for (int i = 0; i < node.children.size(); i++) {
			Node child = node.children.get(i);
			if (child.children.size() == 0) {
				node.children.remove(i);
				i--;
			}

		}

		for (Node child : node.children) {
			removeleaf(child);

		}

	}

	private class pair {
		Node node;
		boolean selfdone;
		int numberofchildrenserviced = 0;

	}

	public void preorderiterative() {
		Stack<pair> stack = new Stack();
		pair pairforroot = new pair();
		pairforroot.node = root;
		stack.push(pairforroot);
		while (stack.size() != 0) {
			pair toppair = stack.peek();
			if (toppair.selfdone == false) {
				toppair.selfdone = true;
				System.out.println(pairforroot.node.data);
			} else if (toppair.numberofchildrenserviced < toppair.node.children.size()) {

				pair pairforchildren = new pair();
				pairforchildren.node = toppair.node.children.get(toppair.numberofchildrenserviced);
				stack.push(pairforchildren);
				toppair.numberofchildrenserviced++;
			} else {
				stack.pop();

			}
		}
	}

	public void levelorder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		while (queue.size() != 0) {
			Node temp = queue.removeFirst();
			System.out.println(temp.data);
			for (Node child : temp.children) {
				queue.addLast(child);
			}
		}

	}

	public void levelorderlinewise() {
		LinkedList<Node> queuecurrent = new LinkedList<>();
		LinkedList<Node> queuenext = new LinkedList<>();
		queuecurrent.addLast(root);
		while (queuecurrent.size() != 0) {
			Node temp = queuecurrent.removeFirst();
			System.out.println(temp.data);
			for (Node child : temp.children) {
				queuenext.addLast(child);
			}
			if (queuecurrent.size() == 0) {
				System.out.println();
				queuecurrent = queuenext;
				queuenext = new LinkedList<>();
			}
		}

	}

	public int sumofallnodes() {
		return sumofallnodes(root);
	}

	private int sumofallnodes(Node node) {
		int sum = 0;

		for (Node child : node.children) {

			int x = sumofallnodes(child);
			sum += x;
		}
		sum += node.data;
		return sum;
	}

//	public int find2ndlargest() {
//		return find2ndlargest(root);
//	}
//
//	private int find2ndlargest(Node node) {
//		for (Node child : node.children) {
//			int x = find2ndlargest(child);
//		}
//		return 0;
//	}
	
	public  int countleaves()
	{
		return countleaves(root,0);
	}

private int countleaves(Node node,int count) {
	for (int i = 0; i < node.children.size(); i++) {
		Node child = node.children.get(i);
		if (child.children.size() == 0) {
		count++;
			i--;
		}

	}

	for (Node child : node.children) {
		countleaves(child,count);

	}
	return count;
}


}

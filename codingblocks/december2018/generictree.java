package december2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class generictree {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

	}

	private Node root;
	private int size;

	public generictree(int[] a) {
		Stack<Node> s = new Stack<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == -1) {
				s.pop();
			} else {
				if (s.size() == 0) {
					Node root = new Node();
					root.data = a[i];
					this.root = root;
					this.size++;
					s.push(root);
				} else {
					Node node = new Node();
					node.data = a[i];
					s.peek().children.add(node);
					this.size++;
					s.push(node);
				}
			}

		}

	}

	// public generictree(int []a,int i){
	// root=construct(a,i);
	//
	//
	// }
	// private Node construct(int[] a, int i) {
	// // TODO Auto-generated method stub
	// if(i==a.length)
	// {
	// return null;
	// }else if(a[i]==-1)
	// {
	// return null;
	// }
	// if(i==0)
	// {
	// Node node=new Node();
	// node.data=a[i];
	// root=node;
	// }else
	// {
	// Node node=new Node();
	// node.data=a[i];
	//
	// }
	// Node node=new Node();
	// node.data=a[i];
	// i++;
	//
	// return null;
	// }
	public void display() {
		display(root);
	}

	private void display(Node node) {
		// TODO Auto-generated method stub
		String s = "";
		s += node.data + " ->";
		for (Node child : node.children) {
			s += child.data + ", ";

		}
		s += ".";
		System.out.println(s);
		for (Node child : node.children) {
			display(child);

		}

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		int s = 0;
		for (Node child : node.children) {
			s += size(child);
		}
		s += 1;
		return s;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		// TODO Auto-generated method stub
		int max = 0;
		for (Node child : node.children) {
			int mr = max(child);
			max = Math.max(mr, max);
		}
		max = Math.max(node.data, max);
		return max;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int h = -1;
		for (Node child : node.children) {
			int mr = height(child);
			h = Math.max(h, mr);
		}
		h += 1;
		return h;
	}

	public boolean find(int data) {
		return find(data, root);
	}

	private boolean find(int data, Node node) {
		if (data == node.data) {
			return true;
		}
		for (Node child : node.children) {
			boolean f = find(data, child);
			if (f == true) {
				return true;
			}
		}

		return false;
	}

	public String serialize() {
		return serialize(root);
	}

	private String s = " ";

	private String serialize(Node node) {
		// TODO Auto-generated method stub

		s += node.data + "_";
		for (Node child : node.children) {
			s = serialize(child);
		}

		s += "#";

		return s;
	}

	public ArrayList<Integer> nodetorootPath(int data) {
		return nodetorootPath(data, root);
	}

	private ArrayList<Integer> nodetorootPath(int data, Node node) {
		if (data == node.data) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(node.data);
			return list;
		}

		for (Node child : node.children) {
			ArrayList<Integer> r = nodetorootPath(data, child);
			if (r.size() != 0) {
				r.add(node.data);
				return r;
			}
		}
		return new ArrayList<>();
	}

	public void removeleaves() {
		removeleaves(root);
	}

	private void removeleaves(Node node) {
		for (int i = node.children.size() - 1; i >= 0; i--) {
			if (node.children.get(i).children.size() == 0) {
				node.children.remove(i);
			}
		}

		for (Node child : node.children) {
			removeleaves(child);
		}

	}

	// public void linearize() {
	// linearize(root);
	// }

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {
		// TODO Auto-generated method stub
		for (Node child : node.children) {
			mirror(child);
		}

		Collections.reverse(node.children);
	}

	// private void linearize(Node node) {
	// // TODO Auto-generated method stub
	//
	// for (Node child : node.children) {
	// linearize(child);
	// }
	// Node sibling = node;// keeps track of leaf node to which next child is
	// // attatched
	// for (int i = 0; i < node.children.size(); i++) {
	// Node child = node.children.get(i);
	// if (sibling != node) {// if first child it has to be attatched to
	// // the parent
	// node.children.remove(i);
	// i--;
	// sibling.children.add(child);
	// }
	// while (child.children.size() != 0)// to reach the leaf node
	// {
	// child = child.children.get(0);
	// }
	// sibling = child;
	// }
	// }

	public Node first = new Node();
	public Node second = new Node();

	public int secondlargest() {
		first.data = 0;
		second.data = 0;
		secondlargest(root);
		return second.data;
	}

	private void secondlargest(Node node) {
		if (node.data > first.data) {
			second = first;
			first = node;
		} else if (node.data > second.data && node.data < first.data) {
			second = node;
		}
		for (Node child : node.children) {
			secondlargest(child);
		}
	}

	public void linearize() {
		// linearize(root);
		linearize2(root);
	}
	//
	// private void linearize(Node node) {
	// for (Node child : node.children) {
	// linearize(child);
	// }
	//
	// for (int i = node.children.size() - 1; i > 0; i--) {
	// Node ch = node.children.remove(i);
	// Node prev = gettail(node.children.get(i - 1));
	// prev.children.add(ch);
	//
	// }
	// }
	//
	// private Node gettail(Node node) {
	//
	// while (node.children.size() != 0) {
	// node = node.children.get(0);
	// }
	// return node;
	// }

	private Node linearize2(Node node) {
		if (node.children.size() == 0) {
			return node;
		}

		Node tail = linearize2(node.children.get(node.children.size() - 1));
		while (node.children.size() > 1) {
			Node lr = node.children.remove(node.children.size() - 1);
			Node sl = node.children.get(node.children.size() - 1);
			Node t = linearize2(sl);
			t.children.add(lr);
		}
		return tail;

	}

	public static boolean isisomorphic(generictree gt1, generictree gt2) {
		return isisomorphic(gt1.root, gt2.root);
	}

	private static boolean isisomorphic(Node node1, Node node2) {
		// TODO Auto-generated method stubint
		if (node1.children.size() != node2.children.size()) {
			return false;
		}
		for (int i = 0; i < node1.children.size(); i++) {
			boolean x = isisomorphic(node1.children.get(i), node2.children.get(i));
			if (x == false) {
				return false;
			}
		}

		return true;
	}

	public static boolean ismirror(generictree gt1, generictree gt2) {

		return ismirror(gt1.root, gt2.root);
	}

	private static boolean ismirror(Node node1, Node node2) {
		if (node1.children.size() != node2.children.size()) {
			return false;
		}
		for (int i = 0; i < node1.children.size(); i++) {
			boolean x = ismirror(node1.children.get(i), node2.children.get(node1.children.size() - i - 1));
			if (x == false) {
				return false;
			}
		}

		return true;
	}

	public boolean issymmetric() {
		if (ismirror(root, root)) {
			return true;
		} else {
			return false;
		}
	}

	private int ss = 0;
	private int min = Integer.MAX_VALUE;
	private int max = Integer.MIN_VALUE;
	private int height = -1;

	public void multisolver() {
		multisolver(root, 0);
		System.out.println("size  " + ss + "min " + min + "max " + max + "height " + height);
	}

	private void multisolver(Node node, int depth) {
		if (node.data < min) {
			min = node.data;
		}
		if (node.data > max) {
			max = node.data;
		}
		if (depth > height) {
			height = depth;
		}
		ss++;
		for (Node child : node.children) {
			multisolver(child, depth + 1);
		}

	}

	public void multi(int data) {
		floor = Integer.MIN_VALUE;
		ceil = Integer.MAX_VALUE;
		su = 0;
		p = 0;
		
		multi(data, root);
		System.out.println("predecessor "+p+" succesor "+su+ " floor "+floor+" ceil " +ceil);
	}

	private int p = 0;
	private int su = 0;
	private boolean datafaund;
	private boolean succ;

	private void multi(int data, Node node) {
		if(datafaund && !succ)
		{
			su=node.data;
			succ=true;
			
		}
		if(data==node.data)
		{
			datafaund=true;
		}

		if (!datafaund) {
			p = node.data;
		}
		
		if (node.data < data && node.data > floor) {
			floor = node.data;
		}
		if (node.data > data && node.data < ceil) {
			ceil = node.data;
		}

		for (Node child : node.children) {
			multi(data, child);
		}
		
	}

	private Integer floor = Integer.MIN_VALUE;
	private Integer ceil = Integer.MAX_VALUE;

}

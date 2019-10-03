package august5;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import javax.tools.ToolProvider;

public class binarytree {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

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

	public binarytree() {
		Scanner scn = new Scanner(System.in);
		this.root = takeinput(scn, null, false);

	}

	private Node takeinput(Scanner scn, Node parent, boolean ilc) {
		if (parent == null) {
			System.out.println("enter data for root");
		} else if (ilc) {
			System.out.println("enter left child for: " + parent.data);
		} else {
			System.out.println("enter right child for: " + parent.data);
		}

		int data = scn.nextInt();

		Node child = new Node();
		child.data = data;
		this.size++;

		System.out.println("do you have left child for" + child.data);
		boolean hlc = scn.nextBoolean();
		if (hlc) {
			child.left = this.takeinput(scn, child, true);
		}
		System.out.println("do you have right child for" + child.data);
		boolean hrc = scn.nextBoolean();
		if (hrc) {
			child.right = this.takeinput(scn, child, false);
		}

		return child;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String printt = forprinting(node);
		System.out.println(printt);
		display(node.left);
		display(node.right);
	}

	private String forprinting(Node node) {
		String rv = "";
		if (node.left != null) {
			rv += node.left.data + "->";
		} else {
			rv += ".->";
		}
		rv += node.data;
		if (node.right != null) {
			rv += "<-" + node.right.data;
		} else {
			rv += "<-.";
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

	private int max(Node node) {
		if (node == null) {
			return 0;
		}
		{
			int max = node.data;
			int leftmax = max(node.left);
			int rightmax = max(node.right);

			if (leftmax > max) {
				max = leftmax;
			}

			else {
				if (rightmax > max) {
					max = rightmax;
				}
			}
			return max;

		}
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		{
			int max = node.data;
			int leftheight = max(node.left);
			int rightheight = max(node.right);

			if (leftheight > max) {
				max = leftheight;
			}

			else {
				if (rightheight > max) {
					max = rightheight;
				}
			}
			return max + 1;

		}
	}

	private class pair {
		Node node;
		boolean selfdone;
		boolean leftdone;
		boolean rightdone;

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
			} else if (toppair.leftdone == false) {
				toppair.leftdone = true;
				pair pairforleft = new pair();
				pairforleft.node = toppair.node.left;
				stack.push(pairforleft);
			} else if (toppair.rightdone == false) {
				toppair.rightdone = true;
				pair pairforright = new pair();
				pairforright.node = toppair.node.right;
				stack.push(pairforright);
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
			if (temp.left != null) {
				queue.addLast(temp.left);
			}
			if (temp.right != null) {
				queue.addLast(temp.right);
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
			if (temp.left != null) {
				queuenext.addLast(temp.left);
			}
			if (temp.right != null) {
				queuenext.addLast(temp.right);
			}
			if (queuecurrent.size() == 0) {
				System.out.println();
				queuecurrent = queuenext;
				queuenext = new LinkedList<>();
			}
		}

	}

	public void pws() {
		pws(null, root, false);
	}

	private void pws(Node parent, Node node, Boolean ilc) {
		if (node == null) {
			return;
		}
		pws(node, node.left, true);
		pws(node, node.right, false);
		if (parent != null) {
			if (ilc == true && parent.right == null) {

				System.out.println(node.data);

			}
			if (ilc == false && parent.right != null) {
				System.out.println(node.data);

			}

		}

	}

	public void removeleaf() {
		removeleaf(null, root, false);
	}

	private void removeleaf(Node parent, Node node, Boolean ilc) {
		if (node == null) {
			return;
		}
		pws(node, node.left, true);
		pws(node, node.right, false);
		if (parent != null) {
			if (node.right == null && node.right == null) {

				if (ilc == true) {
					parent.left = null;

				} else
					parent.right = null;
				this.size--;
			}

		}

	}

	public int sumofallnodes() {
		return sumofallnodes(root);
	}

	private int sumofallnodes(Node node) {
		int sum = 0;

		// if(node.left==null &&node.right==null)
		// {
		// return node.data;
		// }
		if (node == null) {
			return 0;
		}
		int ls = sumofallnodes(node.left);

		int rs = sumofallnodes(node.right);
		sum += ls + rs;
		sum += node.data;
		return sum;
	}

	public void dublicateq2() {
		dublicateq2(root);
	}

	private void dublicateq2(Node node) {
		if (node == null) {
			return;
		}
		dublicateq2(node.left);
		dublicateq2(node.right);
		Node insert = new Node();
		insert.data = node.data;
		insert.left = node.left;
		insert.right = null;
		node.left = insert;

	}
	
	public void sumofallroottoleafpaths()
	{
		sumofallroottoleafpaths(root,"",0);
	}

	private void sumofallroottoleafpaths(Node node,String nsf,int ssf) {
		if(node==null)
		{
			return;
		}
if(node.left==null && node.right==null)
{
	ssf+=node.data;
	
	System.out.println(nsf+node.data+":"+ssf);
	
	
	return;
}

sumofallroottoleafpaths(node.left, nsf+"->"+node.data, ssf+node.data);
sumofallroottoleafpaths(node.right, nsf+"->"+node.data, ssf+node.data);
		
	}
}

package linkedlist;

import java.util.*;

public class AddPolynomial {

	// Class declaration for a Node of the Linked List
	static class Node implements Comparable<Node> {
		int coeff;
		int pow;
		Node next;

		Node(int a, int b) {
			coeff = a;
			pow = b;
			next = null;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return o.pow - this.pow;
		}

	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input the head of two linked lists representing
	// two polynomial numbers.
	// Print the polynomial formed by adding both LL in the function itself.

	public static void addPolynomial(Node poly1, Node poly2) {
		Node head = null;
		Node temp = null;
		Node p1 = poly1;
		Node p2 = poly2;
		while (p1 != null && p2 != null) {
			if (p1.pow == p2.pow) {
				Node n = new Node(p1.coeff + p2.coeff, p1.pow);
				if (head == null) {
					head = temp = n;
				} else {
					temp.next = n;
					temp = n;
				}
				p1 = p1.next;
				p2 = p2.next;

			} else if (p1.pow > p2.pow) {
				Node n = new Node(p1.coeff, p1.pow);
				if (head == null) {
					head = temp = n;
				} else {
					temp.next = n;
					temp = n;
				}
				p1 = p1.next;

			} else {
				Node n = new Node(p2.coeff, p2.pow);
				if (head == null) {
					head = temp = n;
				} else {
					temp.next = n;
					temp = n;
				}
				p2 = p2.next;

			}
		}

		while (p1 != null) {
			Node n = new Node(p1.coeff, p1.pow);
			if (head == null) {
				head = temp = n;
			} else {
				temp.next = n;
				temp = n;
			}
			p1 = p1.next;
		}
		while (p2 != null) {
			Node n = new Node(p2.coeff, p2.pow);
			if (head == null) {
				head = temp = n;
			} else {
				temp.next = n;
				temp = n;
			}
			p2 = p2.next;
		}
		Node t=head;
		while(t!=null)
		{
			System.out.print(t.coeff+"x^"+t.pow+" + ");
		}

	}

	//

	// -----------------------------------------------------

	static Node head;

	static Node head2;

	static Node head3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		int b1 = sc.nextInt();
		head = insert(head, a1, b1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			head = insert(head, a, b);
		}

		int n2 = sc.nextInt();
		int a2 = sc.nextInt();
		int b2 = sc.nextInt();
		head2 = insert(head2, a2, b2);

		for (int i = 1; i < n2; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			head2 = insert(head2, a, b);
		}

		addPolynomial(head, head2);
	}

	/*
	 * Input Parameters: head: head of the linked list in which a new node is to
	 * be inserted. data: the data value of the node which is to be inserted.
	 * 
	 * Return Value: head of the linked list in which the node is inserted
	 */
	public static Node insert(Node head, int a, int b) {

		if (head == null) {
			return new Node(a, b);
		}

		head.next = insert(head.next, a, b);

		return head;
	}

	/*
	 * Input Parameters: head: head of the linked list in which is to be
	 * displayed.
	 * 
	 * Return Value: null
	 */
	public static void display(Node head) {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.coeff + "x^" + node.pow + " ");
		}
	}

}

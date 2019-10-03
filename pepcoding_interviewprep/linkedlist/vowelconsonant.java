package linkedlist;

import java.util.Scanner;

public class vowelconsonant {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char h = sc.next().charAt(0);
		insert(h);

		for (int i = 1; i < n; i++) {
			char ch = sc.next().charAt(0);
			insert(ch);
		}

		head = arcv(head);
		display();

	}

	// ---------------------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function should return the head of node after sorting.
	public static Node arcv(Node head) {
		Node v = null;
		Node c = null;
		Node vh = v;
		Node ch = c;
		Node temp = head;
		while (temp != null) {
			if (temp.data == 'a' || temp.data == 'e' || temp.data == 'i' || temp.data == 'o' || temp.data == 'u') {
				Node n = new Node(temp.data, null);
				if (v == null) {
					v = n;
					vh = n;
				} else {
					v.next = n;
					v = v.next;
				}
			} else {
				Node n = new Node(temp.data, null);
				if (c == null) {
					c = n;
					ch = n;
				} else {
					c.next = n;
					c = c.next;
				}
			}
			temp = temp.next;
		}
		Node nodetoreturn = null;
		if (vh != null && ch != null) {
			v.next = ch;
			nodetoreturn = vh;
		} else if (vh == null && ch != null) {
			nodetoreturn = ch;
		} else {
			nodetoreturn = vh;
		}
		return nodetoreturn;
	}

	// ------------------------------------------------------------------

	private static class Node {
		char data;
		Node next;

		public Node(char data, Node next) {
			this.data = data;
			this.next = next;
		}

	}

	static Node head;
	static Node tail;
	static int size;

	public static void insert(char data) {

		Node nn = new Node(data, null);
		if (head == null) {
			head = nn;
			tail = nn;
		} else {
			tail.next = nn;
			tail = nn;
		}
		size++;
	}

	public static void display() {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}

}
package test;

import java.util.HashSet;
import java.util.Scanner;

public class t1 {
	public static class Node {
		int data;
		Node next;

		public Node(int d, Node n) {
			data = d;
			next = n;
		}
	}

	public static Node[] mergeAltNodes(Node l1, Node l2, int s1, int s2) {
		// DisplayMode(l1);
		Node[] res = new Node[2];
		Node t1 = l1;
		Node t2 = l2;
		while (s1 != 0) {
			if (s2 == 0) {
				break;
			}
			Node x = t1.next;
			t1.next = t2;
			t2 = t2.next;
			t1.next.next = x;
			t1 = x;
			s1--;
			s2--;
		}
		res[0] = l1;
		res[1] = t2;
		return res;
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		HashSet<Integer> hs=new HashSet<>();
		
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int s1 = 0;
		Node l1 = null;
		Node t1 = null;
		for (int i = 0; i < n; i++) {
			Node nn = new Node(scn.nextInt(), null);
			if (l1 == null) {
				l1 = t1 = nn;
			} else {
				t1.next = nn;
				t1 = nn;
			}
			s1++;
		}

		int m = scn.nextInt();
		int s2 = 0;
		Node l2 = null;
		Node t2 = null;
		for (int i = 0; i < m; i++) {
			Node nn = new Node(scn.nextInt(), null);
			if (l2 == null) {
				l2 = t2 = nn;
			} else {
				t2.next = nn;
				t2 = nn;
			}
			s2++;
		}
		Node[] j = mergeAltNodes(l1, l2, s1, s2);
		for (int i = 0; i < j.length; i++) {
			if (j[i] != null) {
				Node t = j[i];
				while (t != null) {
					System.out.print(t.data + " ");
				}
				System.out.println();
			}
		}
	}

}

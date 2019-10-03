package linkedlist;


import java.util.Scanner;

public class sortonabsolute {


//---------------------------------------------------------------
    //This is a functional problem. Only this function has to be written.
    //You should return the head of node after sorting.
	  public static Node sort(Node head) {
	         Node v = null;//positive
			Node c = null;//negative
			Node vh = v;
			Node ch = c;
			Node temp = head;
			Node x=c;
			
			while (temp != null) {
				if (temp.data>=0) {
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
						x=n;
					} else {
						ch=n;
						ch.next=c;
						c=ch;
					}
				}
				temp = temp.next;
			}
			Node nodetoreturn = null;
			if (vh != null && ch != null) {
				x.next = vh;
				nodetoreturn = ch;
			} else if (vh == null && ch != null) {
				nodetoreturn = ch;
			} else {
				nodetoreturn = vh;
			}
			return nodetoreturn;
	     }
//------------------------------------------------------------------





    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);    
            
        int n = sc.nextInt();
        int a1 = sc.nextInt();

        insert(a1); // inserting first node

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            insert(a);
        }

        head = sort(head);
        display();

    }


    private static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    static Node head;
    static Node tail;
    static int size;

    public static void insert(int data) {

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
            System.out.print(node.data+" ");
        }
    }

}

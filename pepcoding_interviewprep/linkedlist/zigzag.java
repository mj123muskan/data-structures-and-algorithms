package linkedlist;


import java.util.Scanner;


public class zigzag {

    
    // ---------------------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    public static void fashion(Node head){
        // write your code here
    	Node prev=head;
        Node curr=head.next;
        int f=1;//f=1 prev<curr f=-1 prev>curr
        while(curr!=null)
        {
            if((f==1 && prev.data<curr.data)|| (f==-1 && prev.data>curr.data))
            {
                prev=curr;
                curr=curr.next;
            }else
            {
                int temp=prev.data;
                prev.data=curr.data;
                curr.data=temp;
                prev=curr;
                curr=curr.next;
            }
            f=f*-1;
        }
        
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a1 = sc.nextInt();
        insert(a1);

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            insert(a);
        }

        fashion(head);
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
            System.out.print(node.data + " ");
        }
    }

}

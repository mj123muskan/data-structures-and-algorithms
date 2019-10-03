package linkedlist;


import java.util.*;

public class mergealternate {

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This takes as input the heads of first and second linked list.
    // It should return an array containing containing heads of resultant
    // first and second linked list at index 0 and 1 respectively.
    public static Node[] mergeAlt(Node head1, Node head2){
        //write your code here, and print the result
        Node [] res=new Node[2];
        Node x=head1;
        Node t1=head1;
        Node tn1=head1.next;
        Node t2=head2;
        Node tn2=head2.next;
       
        Node y=null;
        while(t1!=null )
        {
            t1.next=t2;
            t2.next=tn1;
            t1=tn1;
            t2=tn2;
           
            if(t1.next==null){
                t1.next=t2;
               y=t2.next;
               t2.next=null;
               break;
                
            }else if(t2.next==null){
                y=t1.next;
                t1.next=t2;
                break;
            }else{
            tn1=t1.next;
            tn2=t2.next;
            }
        }
        res[0]=x;
        //t1.next=null;
        if(y!=null)
        {
            res[1]=y;
        }
        return res;
        
    }
    

    // -----------------------------------------------------

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int a1 = sc.nextInt();
        head1 = insert(head1, a1);

        for (int i = 1; i < n1; i++) {
            int a = sc.nextInt();
            head1 = insert(head1, a);
        }

        int n2 = sc.nextInt();
        int a2 = sc.nextInt();
        head2 = insert(head2, a2);

        for (int i = 1; i < n2; i++) {
            int a = sc.nextInt();
            head2 = insert(head2, a);
        }
        Node[] res = mergeAlt(head1, head2);
        display(res[0]);
        display(res[1]);
        //head3 = sublinkedList(head, head2);
        //display(head3);

    }

    // Class declaration for a Node of the Linked List
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    static Node head1;

    static Node head2;

    static Node head3;

    /*
     * Input Parameters: head: head of the linked list in which a new node is to
     * be inserted. data: the data value of the node which is to be inserted.
     * 
     * Return Value: head of the linked list in which the node is inserted
     */
    public static Node insert(Node head, int data) {

        if (head == null) {
            return new Node(data);
        }

        head.next = insert(head.next, data);
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
            System.out.print(node.data + " ");
        }
        System.out.println();
    }

}
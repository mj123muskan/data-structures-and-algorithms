package linkedlist;

import java.util.Scanner;

public class binarylltodecimal{


//---------------------------------------------------------------
    //This is a functional problem. Only this function has to be written.
    //You should return an integer denoting decimal equivalent of binary linked list.
    public static int func(Node head){
    	 Node temp=head.next;
         int sum=0;
         if(head.data==0){
         sum=0;
         }else
         {
             sum=1;
         }
         while(temp!=null)
         {
             if(temp.data==1)
             {
                 sum=sum*2+1;
             }else
             {
                 sum=sum*2;
             }
             temp=temp.next;
         }
         return sum;
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

        int res = func(head);
        System.out.println(res);

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

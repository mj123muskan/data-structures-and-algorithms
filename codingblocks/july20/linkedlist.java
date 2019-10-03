package july20;

import java.util.LinkedList;

import aug20.linkedlist.Node;

public class linkedlist {
	private class Node {
		private int data;
		Node next;

	}

	private Node head;
	private Node tail;
	private int size;

	private class heapmover {
		Node node;
		int count;
		Node kthfromlast;

	}

	public void addlast(int val) {
		Node node = new Node();
		node.data = val;
		node.next = null;
		if (size == 0) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
	}

	public int size() {
		return size;
	}

	public boolean isempty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		Node node = this.head;

		while (node != null) {
			System.out.print(node.data + "  ");
			node = node.next;
		}
		System.out.println();
	}

	public void addfirst(int val) {
		Node node = new Node();
		node.data = val;
		node.next = null;
		if (size == 0) {
			head = node;
			tail = node;
		} else {
			node.next = head;

			head = node;
		}

		size++;
	}

	public int getfirst() throws Exception {
		if (size == 0) {
			throw new Exception("empty");

		}
		return head.data;
	}

	public int getlast() throws Exception {
		if (size == 0) {
			throw new Exception("empty");

		}
		return tail.data;
	}

	public int getat(int x) throws Exception {
		if (size == 0) {
			throw new Exception("empty");

		} else if (x < 0 || x >= size) {
			throw new Exception("out of bound");

		} else

		{
			Node temp = head;
			for (int i = 0; i < x; i++) {
				temp = temp.next;
			}
			return temp.data;
		}
	}

	public Node getnodeat(int x) throws Exception {
		if (size == 0) {
			throw new Exception("empty");

		} else if (x < 0 || x >= size) {
			throw new Exception("out of bound");

		} else

		{
			Node temp = head;
			for (int i = 0; i < x; i++) {
				temp = temp.next;
			}
			return temp;
		}
	}

	public void addat(int x, int val) throws Exception {
		if (x < 0 || x >= size) {
			throw new Exception("out of bound");
		} else

		{
			if (x == 0) {
				addfirst(val);
			} else if (x == size) {
				addlast(val);
			} else {
				Node m1 = getnodeat(x - 1);
				Node p1 = m1.next;
				Node node = new Node();
				node.data = val;
				m1.next = node;
				node.next = p1;
				size++;

			}
		}
	}

	public void reversepointerrecursive() {
		reversepointerrecursivehelper(head);
		Node temp = head;
		head = tail;
		tail = temp;
		temp.next = null;
	}

	private void reversepointerrecursivehelper(Node node) {
		if (node.next == null) {
			return;
		}
		reversepointerrecursivehelper(node.next);
		node.next.next = node;
	}

	public void reversepointeriterative() {
		Node p = head;
		Node c = head.next;
		while (c != null) {
			Node n = c.next;
			c.next = p;
			p = c;
			c = n;
		}
		Node temp = head;
		head = tail;
		tail = temp;
		temp.next = null;
	}

	public void displayreverse() {
		displayreversehelper(this.head);
		System.out.println("----------------------------------------------------------------");
	}

	private void displayreversehelper(Node node) {
		if (node == null) {
			return;
		}
		displayreversehelper(node.next);
		System.out.print(node.data + "  ");
	}

	public void reverseDataIterative() throws Exception {
		int l = 0;
		int r = this.size - 1;
		while (l < r) {
			Node left = getnodeat(l);
			Node right = getnodeat(r);
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
			l++;
			r--;

		}
	}

	public void reversedatarecursive() {
		heapmover left = new heapmover();
		left.node = head;

		reversedatarecursivehelper(left, head, 0);
	}

	private void reversedatarecursivehelper(heapmover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		reversedatarecursivehelper(left, right.next, floor + 1);
		if (floor >= size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;
			left.node = left.node.next;
		}

	}
	public int removeat(int idx)throws Exception 
	{
		if(size==0)
		{
			throw new Exception("list is empty");
		}
		if(idx<0 || idx>=this.size)
		{
			throw new Exception("list is empty");
		}
		if(idx==0)
		{
			return removefirst();
		}else if(idx==size-1)
		{
			return removelast();
		}
		else
		{
			Node m1=getnodeat(idx-1);
			Node curr=m1.next;
			Node  p1=curr.next;
			m1.next=p1;
			this.size--;
			return curr.data;
		}
	}
	public int removefirst() throws Exception {
		if (size == 0) {
			throw new Exception("empty");
		} else if (size == 1) {
			Node temp = head;
			head = null;
			tail = null;
			size--;
			return temp.data;

		} else {
			Node temp = head;
			head = head.next;
			size--;
			return temp.data;

		}
	}

	public int removelast() throws Exception {
		if (size == 0) {
			throw new Exception("empty");
		}
		int rv = tail.data;
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			tail = getnodeat(size - 2);
			tail.next = null;
		}

		size--;
		return rv;
	}
	// public int removeat(int x)throws Exception
	// {
	// if(size==0)
	// {
	// throw new Exception("empty");
	// }
	// if(x==0)
	// {
	// removefirst();
	// }else if(x==size-1)
	// {
	// removelast();
	// }else
	// {
	// Node m1=getnodeat(x-1);
	// Node p1=m1.next;
	// int r=p1.data;
	// m1.next=p1.next;
	// p1.next=null;
	//
	// size--;
	// return r;
	// }

	public void fold() {
		heapmover left = new heapmover();
		left.node = head;

		foldhelper(left, head, 0);
	}

	private void foldhelper(heapmover left, Node right, int floor) {
		if (right == null) {
			return;
		}

		foldhelper(left, right.next, floor + 1);
		if (floor >= size / 2) {
			Node temp = left.node.next;
			right.next = left.node.next;
			left.node.next = right;
			left.node = temp;

		}
		if (floor == size / 2) {
			tail = right;
			tail.next = null;
		}

	}

	public int kthfromlast(int k) {
		heapmover left = new heapmover();
		left.node = head;

		kthfromlast(left, head, k);
		return left.kthfromlast.data;

	}

	private void kthfromlast(heapmover left, Node right, int k) {
		if (right == null) {
			return;
		}
		kthfromlast(left, right.next, k);
		left.count++;
		if (left.count == k) {
			left.kthfromlast = right;
		}
	}

	public boolean ispalindrome() {
		heapmover left = new heapmover();
		left.node = head;
		return isplaindromehelper(left, head);

	}

	private boolean isplaindromehelper(heapmover left, Node right) {
		if (right == null) {
			return true;
		}
		boolean x = isplaindromehelper(left, right.next);
		if (x == false) {
			return false;
		}
		if (left.node.data == right.data) {
			left.node = left.node.next;
			return true;
		} else
			return false;

	}

	private Node midnodee() {
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public int midnode() {
		Node x = midnodee();
		return x.data;

	}

	public linkedlist mergertwosortedlists(linkedlist a) {
		linkedlist result = new linkedlist();
		Node one = this.head;
		Node two = a.head;
		while (one != null && two != null) {
			if (one.data > two.data) {
				result.addlast(two.data);
				two = two.next;
			} else {
				result.addlast(one.data);
				one = one.next;
			}
		}
		while (one != null) {

			result.addlast(one.data);
			one = one.next;
		}
		while (two != null) {

			result.addlast(two.data);
			two = two.next;
		}
		return result;
	}

	public linkedlist mergesort() {
		if (head == tail) {
			return this;
		}
		Node mid = midnodee();
		Node midn = mid.next;
		linkedlist fhalf = new linkedlist();
		linkedlist shalf = new linkedlist();

		fhalf.head = head;
		fhalf.tail = mid;
		fhalf.tail.next = null;
		shalf.head = midn;
		shalf.tail = tail;
		shalf.tail.next = null;
		fhalf = fhalf.mergesort();
		shalf = shalf.mergesort();

		linkedlist result = fhalf.mergertwosortedlists(shalf);
		return result;
	}

	public linkedlist kreverse(int n) throws Exception {
		linkedlist pre = new linkedlist();

		while (this.size != 0) {
			linkedlist curr = new linkedlist();
			int count = n;
			while (count != 0) {
				int val = this.removefirst();
				curr.addfirst(val);
				count--;
			}
			if (pre.size == 0) {
				pre = curr;
			} else {
				pre.tail.next = curr.head;
				pre.tail = curr.tail;
				pre.size += curr.size;
			}
		}
		return pre;

	}

//	public linkedlist removedublicate() throws Exception {
//		linkedlist pre = new linkedlist();
//
//		while (this.size != 1) {
//
//			if (this.head.data == this.head.next.data) {
//				this.removefirst();
//
//			} else {
//				pre.addlast(head.data);
//				this.removefirst();
//
//			}
//
//		}
//		return pre;
//	}
	 public linkedlist removedublicate() throws Exception {
	 linkedlist pre = new linkedlist();
	
	 while (this.size != 0) {
	 int data = this.removefirst();
	
	 if (pre.isempty() || pre.tail.data != data) {
	 pre.addlast(data);
	 }
	 }
	 return pre;
	 }

}

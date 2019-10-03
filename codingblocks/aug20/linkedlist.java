package aug20;


public class linkedlist <T>{
	private class Node {
		private T data;
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

	public void addlast(T val) {
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

	public void addfirst(T val) {
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

	public T getfirst() throws Exception {
		if (size == 0) {
			throw new Exception("empty");

		}
		return head.data;
	}

	public T getlast() throws Exception {
		if (size == 0) {
			throw new Exception("empty");

		}
		return tail.data;
	}

	public T getat(int x) throws Exception {
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

	public void addat(int x, T val) throws Exception {
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
			T temp = left.data;
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
			T temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;
			left.node = left.node.next;
		}

	}

	public T removefirst() throws Exception {
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

	public T removelast() throws Exception {
		if (size == 0) {
			throw new Exception("empty");
		}
		T rv = tail.data;
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
	
	public T removeat(int idx)throws Exception 
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
}
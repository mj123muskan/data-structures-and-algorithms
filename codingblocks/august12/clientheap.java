package august12;

import august5.bst;

public class clientheap {
	public static void main(String[] args) {
		heap heap =new heap();
		heap.add(10);
		heap.add(20);
		heap.add(30);
		heap.add(40);
		heap.add(50);
		heap.add(60);
		heap.add(70);
		heap.display();
		heap.remove();
		heap.display();
		
		

	}

}

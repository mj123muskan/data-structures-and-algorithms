package aug19;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPQ {
	PriorityQueue<Integer> right = new PriorityQueue<>();
	PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());

	private void handlebalance() {
		if (left.size() - right.size() == 2) {
			right.add(left.remove());
		} else if (right.size() - left.size() == 2) {
			left.add(right.remove());
		}
	}

	void add(int val) {// logn

		if (left.size() == 0) {
			left.add(val);
		} else if (val < left.peek()) {
			left.add(val);
		} else if (val > left.peek()) {
			right.add(val);
		}
		handlebalance();
	}

	int remove() {// logn
		int x = 0;
		if (left.size() >= right.size()) {
			x = left.remove();
		} else {
			x = right.remove();
		}
		handle0inleft1inright();// if left is empty right is 10 and we want to
								// add 50 withut this function 50 would have
								// been added in left
		return x;
	}

	private void handle0inleft1inright() {
		if (left.size() == 0 && right.size() == 1) {
			left.add(right.remove());
		}

	}

	int peek() {// o1
		if (left.size() >= right.size()) {
			return left.peek();
		} else {
			return right.peek();
		}
	}

	int size() {
		return left.size() + right.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianPQ mpq = new MedianPQ();

		mpq.add(10);
		mpq.add(20);
		mpq.add(5);
		mpq.add(50);
		mpq.add(30);
		System.out.println(mpq.peek());
		System.out.println(mpq.remove());
		mpq.add(80);
		System.out.println(mpq.peek());
		mpq.add(100);
		mpq.add(110);
		System.out.println(mpq.peek());

	}

}

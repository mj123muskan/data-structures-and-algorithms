package july19;

public class qeue {
	int[] data;
	int front;
	int size;

	qeue(int cap) {
		this.data = new int[cap];
	}

	public void enqueue(int val) throws Exception {
		if (this.size == this.data.length) {
			throw new Exception(" q is full");
		}

		int tail = (this.front + this.size) % this.data.length;
		this.data[tail] = val;
		this.size++;

	}

	public int dequeue() throws Exception {
		if (size == 0) {
			throw new Exception("q is empty");
		}

		int temp = this.data[this.front];
		this.data[this.front] = 0;
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return temp;

	}

	public int front() throws Exception {
		if (this.size == 0) {
			throw new Exception("q is empty");
		}

		return this.data[this.front];

	}

	public int size() {
		return this.size;

	}

	public boolean isempty() {
		if (this.size == 0)
			return true;
		else
			return false;
	}

	public void display() {
		System.out.println("-----------");
		for (int i = 0; i < size; i++) {
			System.out.print(this.data[(front + i) % data.length] + "  ");
		}
		System.out.println(".");
		System.out.println("-----------");
	}

}

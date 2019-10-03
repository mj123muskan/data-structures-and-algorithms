 package aug20;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
	ArrayList<T> data = new ArrayList<>();

	public int size() {
		return this.data.size();
	}

	public boolean isempty() {
		return this.data.isEmpty();
	}

	public void display() {
		System.out.println(data);
	}

	public void add(T value) {
		data.add(value);
		upheapyfy(data.size() - 1);

	}

	private void upheapyfy(int ci) {
		int pi = (ci - 1) / 2;
		if (data.get(pi).compareTo(data.get(ci))>0) {
			T p = data.get(pi);
			T q = data.get(ci);
			data.set(pi, q);
			data.set(ci, p);
			upheapyfy(pi);
		}
	}

	public T remove() {

		T p = data.get(0);
		T q = data.get(data.size() - 1);
		data.set(0, q);
		data.set(data.size() - 1, p);
		T rv = data.remove(data.size() - 1);
		downheapify(0);
		return rv;
	}

	private void downheapify(int pi) {
		int lci = (2 * pi) + 1;
		int rci = lci + 1;
		int min = pi;
		if (lci < data.size() && data.get(lci).compareTo(data.get(min))<0) {
			min = lci;
		}
		if (rci < data.size() && data.get(rci).compareTo(data.get(min))<0 ) {
			min = rci;
		}
		if (min != pi) {
			T p = data.get(min);
			T q = data.get(pi);
			data.set(pi, p);
			data.set(min, q);
			downheapify(min);
		}

	}

	public void swap(int pi, int ci) {
		T p = data.get(pi);
		T q = data.get(ci);
		data.set(pi, q);
		data.set(ci, p);
	}
}







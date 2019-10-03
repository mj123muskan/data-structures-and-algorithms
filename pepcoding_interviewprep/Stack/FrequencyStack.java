package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class FrequencyStack {
	private static class FreqStack {
		public static HashMap<Integer, Integer> f;
		public static HashMap<Integer, Stack<Integer>> h;

		public FreqStack() {
			f = new HashMap<>();
			h = new HashMap<>();
		}

		public static void push(int x) {
			int j = 0;
			if (f.containsKey(x)) {
				j = f.get(x) + 1;
				f.put(x, f.get(x) + 1);

			} else {
				j = 1;
				f.put(x, 1);
			}

			if (h.containsKey(j)) {
				Stack<Integer> s = h.get(j);
				s.push(x);
				h.put(j, s);
			} else {
				Stack<Integer> s = new Stack<>();
				s.push(x);
				h.put(j, s);
			}

		}

		public static int pop() {
			Stack<Integer> s = h.get(h.size());
			int y = s.pop();
			if (s.size() != 0) {
				h.put(h.size(), s);
			} else {
				h.remove(h.size());
			}

			return y;
		}
	}

	// Dont make changes here
	public static void main(String[] args) {
		FreqStack fq = new FreqStack();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 0;
		while (i != n) {
			int q = sc.nextInt();
			if (q == 1) {
				i++;
				fq.push(sc.nextInt());
			} else if (q == 2)
				System.out.println(fq.pop());
			i++;
		}
	}

}

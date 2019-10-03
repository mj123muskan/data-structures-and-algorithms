package Stack;

import java.util.*;
import java.util.Scanner;

public class minelementstack {//3 test cases not passed

	static int minEle;
	static Stack<Integer> s = new Stack<>();

	// Complete the below 3 functions only
	static int getMin() {
		if(s.size()==0)
		{
		return -1;
		}else{
		return minEle;
		}
	}

	static int pop() {
		if(s.size()==0)
		{
			return -1;
		}else
		if (s.peek() < minEle) {
			minEle = 2 * minEle - s.peek();
			return s.pop();
		} else {
			return s.pop();
		}
	}

	static void push(int x) {
		if (s.size() == 0) {
			s.push(x);
			minEle = x;
		} else if (x >= minEle) {
			s.push(x);
		} else {
			s.push(x + x - minEle);
			minEle = x;
		}

	}

	// Dont make changes here
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] query = new int[n];
		for (int i = 0; i < n; i++) {
			query[i] = sc.nextInt();
		}
		int i = 0;
		while (i < n) {
			if (query[i] == 1) {
				i++;
				push(query[i]);
			} else if (query[i] == 2) {
				System.out.println(pop());
			} else if (query[i] == 3) {
				System.out.println(getMin());
			}
			i++;
		}
	}

}

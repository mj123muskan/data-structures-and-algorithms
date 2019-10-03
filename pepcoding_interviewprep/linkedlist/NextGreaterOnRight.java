package linkedlist;

import java.util.*;
import java.io.*;

public class NextGreaterOnRight {
	static class stack {
		int top;
		int items[] = new int[100];

		// Stack functions to be used by printNGE
		void push(int x) {
			if (top == 99) {
				System.out.println("Stack full");
			} else {
				items[++top] = x;
			}
		}

		int pop() {
			if (top == -1) {
				System.out.println("Underflow error");
				return -1;
			} else {
				int element = items[top];
				top--;
				return element;
			}
		}

		boolean isEmpty() 
	 	 	 { 
	 	 	 	 return (top == -1) ? true : false; 
	 	 	 }
	}

	/*
	 * prints element and NGE pair for all elements of arr[] of size n
	 */
	static void printNGE(int ht[], int n) 
	 { 
	 	  Stack<Integer>s=new Stack<>();
		int[] ser = new int[ht.length];

		ser[ht.length - 1] = -1;

		s.push(ht[n-1]);
		for (int i = ht.length - 2; i >= 0; i--) {
			//while (s.items.length > 0 && s.top <= ht[i]) {
				while (s.size() > 0 && s.peek() <= ht[i]) {
				s.pop();
			}
			if (s.size() == 0) {
				ser[i] = 0;
			} else {
				ser[i] = s.peek();

			}
			s.push(ht[i]);
		}
		for(int i=0;i<n;i++)
		{
			System.out.println(ser[i]);
		
		}
	 }  
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		printNGE(arr, n);
	}
}

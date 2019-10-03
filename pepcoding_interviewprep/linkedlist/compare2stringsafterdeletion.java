package linkedlist;

import java.util.Scanner;
import java.util.Stack;

public class compare2stringsafterdeletion {
	public static boolean compareString(String s, String t) {
		// write your code here
		Stack<Character> s1 = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '#') {
				s1.pop();
			} else {
				s1.push(s.charAt(i));
			}
		}
System.out.println();
System.out.println(s1);
		Stack<Character> s2 = new Stack<>();
		for (int i = 0; i < t.length(); i++) {
			if (t.charAt(i) == '#') {
				s2.pop();
			} else {
				s2.push(t.charAt(i));
			}
		}
		System.out.println(s2);
		String sn = "";
		String tn = "";
		
		while (s1.size() != 0) {
			sn += s1.pop();
		}
		while (s2.size() != 0) {
			tn += s2.pop();
		}
System.out.println(sn);
System.out.println(tn);
		if (sn.equals(tn)) {
			return true;
		} else {
			return false;
		}
	}

	// Driver program
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();

		System.out.println(compareString(s1, s2));
	}
}

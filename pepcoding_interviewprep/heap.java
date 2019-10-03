import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int w = sc.nextInt();

		int n = sc.nextInt();
		int[] profits = new int[n];
		int[] capital = new int[n];

		for (int i = 0; i < n; i++) {
			profits[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			capital[i] = sc.nextInt();
		}

		System.out.println(findMaximizedCapital(k, w, profits, capital));
	}
	 private static int heightofheap(int N) {
//Write your code here
double h=Math.ceil(Math.log(N+1)/Math.log(2))-1;
return (int)h;
	 }

	public static int findMaximizedCapital(int k, int W, int[] P, int[] C) {

		PriorityQueue<project> pc = new PriorityQueue<>(new capital());
		PriorityQueue<project> pp = new PriorityQueue<>(new profit());
		for (int i = 0; i < C.length; i++) {
			project p = new project(P[i], C[i]);
			pc.add(p);
		}

		while (k != 0) {
			while (pc.size() != 0 && pc.peek().c <= W) {
				pp.add(pc.remove());
			}
			W += pp.remove().p;
			k--;
		}
		return W;
	}

	public static class project {
		int p;
		int c;

		public project(int pp, int cc) {
			p = pp;
			c = cc;
		}
	}

	public static class profit implements Comparator<project> {
		public int compare(project p1, project p2) {
			return p2.p - p1.p;
		}
	}

	public static class capital implements Comparator<project> {
		public int compare(project p1, project p2) {
			return p1.c - p2.c;
		}
	}

}

package Stack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class stack {
	static HashSet<Integer> f=new HashSet<>();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		// String s = scn.next();
		// System.out.println(calculator(s));
		// int n=scn.nextInt();
		// int ast[]=new int[n];
		// for(int i=0;i<n;i++)ast[i]=scn.nextInt();
		// int res[]=asteroidCollision(ast);
		// for(int v:res){
		// System.out.println(v);
		// }
		// int target = scn.nextInt();
		// int n = scn.nextInt();
		// int[] pos = new int[n];
		// int[] speed = new int[n];
		// for (int i = 0; i < n; i++)
		// pos[i] = scn.nextInt();
		// for (int i = 0; i < n; i++)
		// speed[i] = scn.nextInt();
		// System.out.println(carFleet(target, pos, speed));
		// int n = scn.nextInt();
		// char ch[] = new char[n];
		//
		// for (int i = 0; i < n; i++) {
		// ch[i] = scn.next().charAt(0);
		//
		// }
		// uniqueChar(ch);
		// int [][] m={{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
		// System.out.println(maxAareainmatrix01(m));
		// System.out.println(maxsumsubarraylargestsecondlargest(new int[] { 4,
		// 5, 2, 7, 3 }));
		// System.out.println(reversebrackets("{}{}{}}}}}"));
		// String s = scn.next();
		// int k = scn.nextInt();
		// System.out.println(decodeIndex(s, k));
		// HashMap<Character,Integer> p=new HashMap<>();
		// p.put('+', 1);
		// p.put('-', 1);
		// p.put('*', 2);
		// p.put('/', 2);
		// p.put('%', 2);
		// p.put('^', 3);
		// System.out.println(infix("(4*6-2^(1*(3-1)))", p));
		// System.out.println(canonicalpath("/a//b////c/d//././/.."));
		// System.out.println(connectingropes(new int[]{4,2,7,6,9}));
		// int[][] a = { { 0, 0, 1, 1, 1 }, { 1, 0, 0, 1, 1 }, { 0, 1, 0, 1, 1
		// }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 1, 0 } };
		// System.out.println(celebrity(a));
		// System.out.println(removeKforsmall("100666467597842741045214049439390784211649496856591813011720399",10));
		// Stack<Integer> s = new Stack<>();
		// s.push(1);
		// s.push(2);
		// s.push(3);
		// s.push(4);
		// stackreverse(s);
		// System.out.println(s);
		// int[][] a = { { 0, 1, 0, 0, 0, 1, 0 }, { 1, 1, 1, 0, 0, 1, 1 }, { 0,
		// 2, 0, 0, 0, 1, 0 },
		// { 0, 0, 0, 1, 1, 1, 0 }, { 0, 1, 0, 2, 1, 0, 0 }, { 2, 1, 0, 0, 1, 1,
		// 0 }, { 0, 1, 1, 0, 0, 0, 0 },
		// { 0, 0, 1, 1, 1, 1, 0 } };
		// int [][]a={ {2, 1, 0, 2, 1},
		// {1, 0, 1, 2, 1},
		// {1, 0, 0, 2, 1}};
		// System.out.println(rottenoranges(a));
		// int n = scn.nextInt();
		// int k = scn.nextInt();
		// ArrayList<Integer> pid = new ArrayList<>(n);
		// ArrayList<Integer> ppid = new ArrayList<>(n);
		// for (int i = 0; i < n; i++) {
		// pid.add(scn.nextInt());
		// }
		// for (int i = 0; i < n; i++) {
		// ppid.add(scn.nextInt());
		// }
		// ArrayList<Integer> res = killProcess(pid, ppid, k);
		// Collections.sort(res);
		// System.out.println(res);
		// int n = scn.nextInt();
		// int L = scn.nextInt();
		// List<String> logs = new ArrayList<>(L);
		// for (int i = 0; i < L; i++) {
		// logs.add(scn.next());
		// }
		// int[] res = exclusiveTime(n, logs);
		// for (int i = 0; i < res.length; i++) {
		// System.out.print(res[i] + " ");
		// }

		// Scanner sc = new Scanner(System.in);
		// System.out.print(parseTernary(scn.next()));
		// String s = scn.next();
		// System.out.println(scoreOfParentheses(s));
		// int N = scn.nextInt();
		// int[] pushed = new int[N];
		// int[] popped = new int[N];
		// for (int i = 0; i < N; i++)
		// pushed[i] = scn.nextInt();
		// for (int i = 0; i < N; i++)
		// popped[i] = scn.nextInt();
		// System.out.print(validateStackSequences(pushed, popped));
		Scanner sc = new Scanner(System.in);
		// int N = sc.nextInt();
		// int knightPos[] = new int[2];
		// int targetPos[] = new int[2];
		// knightPos[0]=sc.nextInt();knightPos[1]=sc.nextInt();
		// targetPos[0]=sc.nextInt();targetPos[1]=sc.nextInt();
		// System.out.println(knightChessboard(knightPos, targetPos, N));
//		Queue<Integer> q = new LinkedList<Integer>();
//		int n = sc.nextInt();
//		int k = sc.nextInt();
//		for (int i = 0; i < n; i++)
//			q.add(sc.nextInt());
//		reverseQueueFirstKElements(q, k);
		 int n = sc.nextInt();
         int N = sc.nextInt();
         char[] tasks = new char[N];
         for (int i = 0; i < N; i++) {
             tasks[i] = sc.nextLine().charAt(0);
         }
         System.out.println(minInterval(tasks, n));
         //Scanner sc = new Scanner(System.in);
         System.out.print(frequencySort(sc.next()));
	}
	 public static String frequencySort(String s) {
	     
         // Write your code here
         HashMap<Character,Integer> map=new HashMap<>();
         char rs;
         for (int i = 0; i < s.length(); i++) {
			rs = s.charAt(i);
			if (map.containsKey(rs)) {
				map.put(rs, map.get(rs) + 1);
			} else {
				map.put(rs, 1);
			}
		
		}
		PriorityQueue<sortpair> pq=new PriorityQueue<>();
		for(char y:map.keySet())
		{
		    sortpair t=new sortpair(y,map.get(y));
		    pq.add(t);
		}
		String p="";
		while(pq.size()!=0)
		{
		    sortpair u=pq.remove();
		    while(u.f!=0){
		   p+=u.x;
		    u.f--;
		        
		    }
		    
		}
		return p;
         
     }
public static class sortpair implements Comparable<sortpair> {
		char x;
		int f;

		public sortpair(char xx, int ff) {
			x = xx;
			f = ff;
		}

		@Override
		public  int compareTo(sortpair o) {
		
				return o.f - this.f;
		
		}
	}
 

	 public static int minInterval(char[] tasks, int n) {//runtime error
	     // Write your code here
	     HashMap<Character,Integer> map=new HashMap<>();
	     for(int i=0;i<tasks.length;i++)
	     {
	         if(map.containsKey(tasks[i]))
	         {
	             map.put(tasks[i],map.get(tasks[i])+1);
	         }else
	         {
	             map.put(tasks[i],1);
	         }
	     }
	     PriorityQueue<cpupair> pq=new PriorityQueue(Collections.reverseOrder());
	     Queue<cpupair> q=new LinkedList<>();
	     ArrayList<Character> list=new ArrayList<>(map.keySet());
	     int count=0;
	     for(char cc:list)
	     {
	         pq.add(new cpupair(cc,map.get(cc)));
	     }
	     cpupair w=pq.remove();
	     //System.out.print(w.c+" ");
	     w.f--;
	     q.add(w);
	     count++;
	     while(pq.size()!=0 && q.size()!=0)
	     {
	         for(int i=0;i<n;i++){
	             if(pq.size()==0)
	             {
	                 count++;
	             }else
	             {
	         cpupair t=pq.remove();
	         //System.out.print(t.c);
	         
	         count++;
	         t.f--;
	         q.add(t);
	             }
	         }
	         while(q.size()!=0)
	         {
	             pq.add(q.remove());
	         }
	         
	         
	         
	     }
	     return count;
	     }

	public static class cpupair implements Comparable<cpupair> {
		char c;
		int f;

		public cpupair(char cc, int ff) {
			c = cc;
			f = ff;
		}

		@Override
		public int compareTo(cpupair o) {
			// TODO Auto-generated method stub
			return this.f-o.f;
		}
	}

	public static void printMax(int[] arr, int k) {
		// Write your code here
		Deque<Integer> dq = new LinkedList<>();
		dq.addLast(0);
		for (int i = 1; i < arr.length; i++) {
			int x = dq.removeLast();
			dq.addLast(x);
			while ((dq.size() != 0) && (arr[i] >= arr[x])) {
				dq.removeLast();
			}
			dq.addLast(i);

			if ((i - dq.peek() + 1) >= k) {
				dq.removeFirst();
			}
			System.out.println(arr[dq.peek()] + " ");

		}

	}

	static void reverseQueueFirstKElements(Queue<Integer> queue, int k) {
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < k; i++) {
			s.push(queue.remove());
		}

		while (s.size() != 0) {
			queue.add(s.pop());
		}

		for (int i = 0; i < (queue.size() - k); i++) {
			queue.add(queue.remove());
		}

		while (queue.size() != 0) {
			System.out.println(queue.remove());
		}
	}

	// Write the code
	static int[] kx = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[] ky = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static int knightChessboard(int kp[], int tp[], int n)// 2 test cases
	{
		LinkedList<knightpair> p = new LinkedList<>();
		p.addLast(new knightpair(kp[0], kp[1], 0));
		boolean[][] visited = new boolean[n + 1][n + 1];
		visited[kp[0]][kp[1]] = true;
		int s = -1;
		while (!p.isEmpty()) {
			knightpair r = p.removeFirst();

			if (!visited[r.x][r.y]) {
				visited[r.x][r.y] = true;
			}
			s = r.step;
			if (r.x == tp[0] && r.y == tp[1]) {
				return s;
			}

			for (int i = 0; i < 8; i++) {
				int nx = r.x + kx[i];
				int ny = r.y + ky[i];
				// System.out.println(nx+" "+ny);
				if (nx > 0 && ny > 0 && nx < n && ny < n && visited[nx][ny] == false) {
					visited[nx][ny] = true;
					knightpair t = new knightpair(nx, ny, r.step + 1);
					p.addLast(t);
				}
			}

		}
		return -1;

	}

	public static class knightpair {
		int x;
		int y;
		int step;

		public knightpair(int xx, int yy, int s) {
			x = xx;
			y = yy;
			step = s;
		}
	}

	public static Stack<Integer> sortstack(Stack<Integer> input) {
		Stack<Integer> s = new Stack<>();

		while (input.size() != 0) {
			int x = input.pop();

			while (s.size() != 0 && s.peek() > x) {
				input.push(s.pop());
				// count++;
			}
			s.push(x);

		}

		return s;
	}

	static long removeRep(long n) {
		Stack<Character> h = new Stack<>();
		String s = Long.toString(n);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (h.size() == 0) {
				h.push(c);
			} else if (h.peek() == c) {

			} else {
				h.push(c);
			}
		}

		Stack<Character> rev = new Stack<>();
		while (h.size() != 0) {
			rev.push(h.pop());

		}

		String k = "";
		while (rev.size() != 0) {
			k += rev.pop();
		}

		return Long.parseLong(k);
		// Write your code here
	}

	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		int[] x = new int[popped.length];
		int k = 0;
		for (int i = popped.length - 1; i >= 0; i--) {
			x[k] = popped[i];
			k++;
		}
		int count = 0;
		for (int i = 0; i < popped.length; i++) {
			if (x[i] == pushed[i]) {
				count++;
			}
		}
		if (count == popped.length)// to check if pushed and popped are
									// completey rversed
		{
			return true;
		}
		Stack<Integer> s = new Stack<>();
		int j = 0;
		for (int i = 0; i < pushed.length; i++) {
			s.push(pushed[i]);
			if (popped[j] == s.peek()) {
				s.pop();
				j++;
			}

		}
		if (j == s.size()) {
			return true;
		} else {
			return false;
		}
	}

	public static int scoreOfParentheses(String s) {
		// Write your code here
		Stack<String> h = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				h.push("****");
			} else if (c == ')') {
				if (h.peek() == "****") {
					h.pop();
					h.push("1");
				} else {
					int sum = 0;
					while (h.peek() != "****") {
						sum += Integer.parseInt(h.pop());
					}
					sum = sum * 2;
					h.pop();
					h.push(sum + "");
				}
			}
		}
		int m = 0;
		while (h.size() != 0) {
			m += Integer.parseInt(h.pop());
		}
		return m;
	}

	public static String parseTernary(String e) {
		Stack<String> s = new Stack<>();
		int i = e.length() - 1;
		while (i >= 0) {
			char c = e.charAt(i);
			if (c >= '0' && c <= '9') {
				String p = "";
				if (e.charAt(i - 1) == '-') {
					p = p + e.charAt(i - 1);
					i--;
				}
				p = p + c;
				s.push(p);
			} else if (c == '?') {
				s.push("****");
			} else if (c == 't' || c == 'f') {
				s.push(c + "");
			} else if (c == ':') {

			} else if (c == 'T') {
				if (s.peek() == "****") {

					s.pop();
					String v1 = s.pop();
					String v2 = s.pop();
					s.push(v1);
				} else {
					s.push(c + "");
				}
			} else if (c == 'F') {
				if (s.peek() == "****") {
					s.pop();
					String v1 = s.pop();
					String v2 = s.pop();
					s.push(v2);
				} else {
					s.push(c + "");
				}
			}

			i--;
		}

		return s.pop();
	}

	public static class pair {
		int pid;
		boolean isstart;
		int time;
		int nmt;

		public pair(int p, boolean b, int t, int nt) {
			pid = p;
			isstart = b;
			time = t;
			nmt = nt;

		}
	}

	public static int[] exclusiveTime(int n, List<String> logs) {
		// Write your code here
		int[] res = new int[n];
		Stack<pair> s = new Stack<>();
		for (int i = 0; i < logs.size(); i++) {
			String[] k = logs.get(i).split(":", 0);
			/*
			 * for(int p=0;p<k.length;p++) { System.out.print(k[p]+" "); }
			 * System.out.println();
			 */
			if (k[1].equals("start")) {
				pair p = new pair(Integer.parseInt(k[0]), true, Integer.parseInt(k[2]), 0);
				s.push(p);

			} else// end
			{
				pair r = s.pop();
				int time = Integer.parseInt(k[2]) - r.time + 1;
				res[r.pid] = time - r.nmt;
				if (s.size() != 0) {
					pair f = s.pop();
					f.nmt += time;
					s.push(f);
				}
			}
			/*
			 * System.out.println(s); System.out.println();
			 */

		}

		return res;
	}

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	public static ArrayList<Integer> killProcess(ArrayList<Integer> pid, ArrayList<Integer> ppid, int kill) {
		// Write your code here
		HashMap<Integer, Node> map = new HashMap<>();
		for (int i = 0; i < pid.size(); i++) {
			int x = pid.get(i);
			Node n = new Node();
			n.data = x;
			map.put(x, n);
		}

		for (int i = ppid.size() - 1; i >= 0; i--) {
			int x = ppid.get(i);
			int c = pid.get(i);
			if (x != 0) {
				Node p = map.get(x);
				Node child = map.get(c);
				p.children.add(child);
				map.put(x, p);
			}

		}

		Node root = map.get(kill);
		ArrayList<Integer> res = new ArrayList<>();

		preorder(root, res);
		return res;

	}

	public static void preorder(Node root, ArrayList<Integer> res) {
		res.add(root.data);
		for (int i = 0; i < root.children.size(); i++) {
			preorder(root.children.get(i), res);
		}
	}

	static int tt = 0;

	// public static int rottenoranges(int[][] a) {
	//
	// rottenoranges(a, new boolean[a.length][a[0].length], tt);
	// return tt;
	// }
	//
	// public static class pair {
	// int x;
	// int y;
	// int time;
	//
	// public pair(int xx, int yy, int t) {
	// x = xx;
	// y = yy;
	// time = t;
	//
	// }
	// }

	public static int[] xd = { 0, 1, 0, -1 };
	public static int[] yd = { 1, 0, -1, 0 };

	// private static void rottenoranges(int[][] a, boolean[][] bs, int t) {//
	// test
	// // case
	// // fail
	// // TODO Auto-generated method stu
	// LinkedList<pair> q = new LinkedList<>();
	// int cr = 0;
	// int cf = 0;
	// int e = 0;
	// for (int i = 0; i < a.length; i++) {
	// for (int j = 0; j < a[i].length; j++) {
	// if (a[i][j] == 2) {
	// pair p = new pair(i, j, 0);
	// cr++;
	// q.addLast(p);
	// bs[i][j] = true;
	// } else if (a[i][j] == 1) {
	// cf++;
	// } else {
	// e++;
	// bs[i][j] = true;
	// }
	// }
	// }
	// int k = 0;
	// int ti = 0;
	// while (q.size() != 0) {
	// pair r = q.removeFirst();
	// System.out.println(r.x + " " + r.y);
	//
	// if (!bs[r.x][r.y] == true) {
	// bs[r.x][r.y] = true;
	// k++;
	// }
	// ti = r.time;
	// for (int i = 0; i < xd.length; i++) {
	//
	// int nx = r.x + xd[i];
	// int ny = r.y + yd[i];
	// if (nx < a.length && ny < a[0].length && nx >= 0 && ny >= 0 && a[nx][ny]
	// != 2 && a[nx][ny] != 0
	// && bs[r.x][r.y] != true) {
	// pair n = new pair(nx, ny, r.time + 1);
	// q.addLast(n);
	// }
	// }
	//
	// }
	//
	// if (k == cf) {
	// tt = ti;
	// } else {
	// tt = -1;
	// }
	//
	// }

	// public static int[] ksubarraymaxsum(int []a,int a)
	// {
	//
	// }
	// public static
	public static void stackreverse(Stack<Integer> s) {
		if (s.size() == 0) {
			return;
		}
		int x = s.pop();
		stackreverse(s);
		System.out.println(s);
		s.push(x);
	}

	public static String removeKforsmall(String s, int k) {
		Stack<Integer> h = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			int c = s.charAt(i) - '0';
			if (h.size() == 0) {
				h.push(c);
				i++;
			} else if (c > h.peek()) {
				h.push(c);
				i++;
			} else {
				while (h.size() != 0 && (c < h.peek() && k != 0)) {
					h.pop();
					k--;
				}
				h.push(c);
				i++;
				if (k == 0) {
					break;
				}
			}
			System.out.println(h + " " + k);
		}
		System.out.println(h + " " + k);
		while (i < s.length()) {
			h.push(s.charAt(i) - '0');
			i++;
		}
		System.out.println(h + " " + k);
		// for (int i = 0; i < s.length(); i++) {
		// int c = s.charAt(i) - '0';
		// if (h.size() == 0) {
		// h.push(c);
		// } else if (c > h.peek() || (k == 0)) {
		// h.push(c);
		// } else {
		// while (h.peek() > c && k != 0) {
		// h.pop();
		// k--;
		// }
		// h.push(c);
		// }
		// }
		//
		while (k != 0) {
			h.pop();
			k--;
		}
		//
		StringBuilder res = new StringBuilder();
		int[] f = new int[h.size()];
		int p = h.size() - 1;
		while (h.size() != 0) {
			f[p] = h.pop();
			p--;
		}

		for (int j = 0; j < f.length; j++) {

			res.append(f[j]);
		}
		// System.out.println(res);
		String l = res.toString();
		int w = 0;
		while (l.charAt(w) == '0') {
			w++;
		}
		return l.substring(w);

	}

	public static int celebrity(int[][] a) {// 2 test cases
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < a.length; i++) {
			s.push(i);
		}
		while (s.size() > 1) {
			int x = s.pop();
			int y = s.pop();
			if (a[x][y] == 1)// x knows y so x cant be celebrity
			{
				s.push(y);
			} else// x doesnt know y so y cant be celebrity
			{
				s.push(x);
			}
		}

		int z = s.pop();
		int f = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[z][i] != 0) {
				return -1;
			}
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i][z] != 1 && i != z) {
				return -1;
			}
		}

		return z;

	}

	public static int connectingropes(int[] a) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// PriorityQueue<Long>
		for (int i = 0; i < a.length; i++) {
			pq.add(a[i]);
		}
		int sum = 0;
		while (pq.size() > 1) {
			int x = pq.remove();
			int y = pq.remove();
			sum += x + y;
			pq.add(x + y);
		}
		return sum;
	}

	public static String canonicalpath(String s) {
		Stack<String> h = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				if (h.peek() == null) {
					h.push(s.charAt(i) + "");
				} else if (h.peek() == "/") {
					h.push(s.charAt(i) + "");
				} else {
					String k = h.pop();
					k += s.charAt(i);
					h.push(k);
				}
			} else if (s.charAt(i) == '/') {

				if (h.size() == 0 || h.peek() != "/") {
					h.push("/");
				}
			} else {
				if (s.charAt(i) == '.') {
					if (s.charAt(i + 1) == '.')// ..
					{
						if (h.size() != 0) {
							h.pop();
						}

						if (h.size() != 0) {
							h.pop();
						}
						i++;

					}
				}
			}
		}
		h.pop();

		StringBuilder res = new StringBuilder();
		res.append("/");
		if (h.size() != 0) {
			String[] c = new String[h.size() - 1];
			for (int i = h.size() - 2; i >= 0; i--) {
				c[i] = h.pop();
			}

			for (int i = 0; i < c.length; i++) {
				res.append(c[i]);
			}
		}
		// System.out.println(res);
		return res.toString();
	}

	public static String decodeIndex(String S, int k) {// one test case left
		// Write your code here only
		int size = 0;

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) >= '0' && S.charAt(i) <= '9') {
				if (S.charAt(i) != '0') {
					size = size * (S.charAt(i) - '0');
				}
			} else {
				size++;
			}
			// System.out.println(size);
		}
		System.out.println(size + " ");
		System.out.println();
		int i = S.length() - 1;
		while (i >= 0) {
			if (S.charAt(i) >= '0' && S.charAt(i) <= '9') {
				size = size / (S.charAt(i) - '0');
				k = k % size;
			} else {
				if ((k + 1) % size == 0) {
					return S.charAt(i) + "";
				} else {
					k = k % size;
					size--;
				}
			}
			System.out.println(size + " " + k);
			i--;
		}
		return "-1";
	}

	public static int reversebrackets(String s) {
		Stack<Character> h = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{') {
				h.push(s.charAt(i));
			} else if (s.charAt(i) == '}') {
				if ((h.size() == 0) || (h.peek() == '}')) {
					h.push(s.charAt(i));
				} else {
					h.pop();
				}
			}
		}
		int co = 0;
		int cc = 0;
		while (h.size() != 0) {
			if (h.pop() == '{') {
				co++;
			} else {
				cc++;
			}
		}
		int res = 0;
		int o = (int) Math.ceil((co * 1.0) / (2 * 1.0));
		int t = (int) Math.ceil((cc * 1.0) / (2 * 1.0));
		if (co % 2 != 0 && cc % 2 != 0) {
			res = o + t + 2;
		} else if (co % 2 == 0 && cc % 2 == 0) {
			res = o + t;
		} else {
			res = -1;
		}
		return res;
	}

	public static int maxsumsubarraylargestsecondlargest(int[] a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length - 1; i++) {
			int sum = a[i] + a[i + 1];
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	public static int maxAareainmatrix01(int[][] m) {
		int[] h = new int[m[0].length];
		for (int i = 0; i < m[0].length; i++) {
			h[i] = m[0][i];
		}
		int max = maxRectArea(h);
		for (int j = 1; j < m.length; j++) {
			for (int i = 0; i < m[0].length; i++) {
				if (m[j][i] == 0) {
					h[i] = 0;
				} else {

					h[i] = h[i] + 1;
				}
			}
			int y = maxRectArea(h);
			if (y > max) {
				max = y;
			}
		}
		return max;
	}

	public static int maxRectArea(int[] ht) {
		// write your code here
		Stack<Integer> s = new Stack<>();
		int[] ser = new int[ht.length];
		int[] sel = new int[ht.length];
		ser[ht.length - 1] = ht.length;
		sel[0] = -1;
		s.push(ht.length - 1);
		for (int i = ht.length - 2; i >= 0; i--) {
			while (s.size() > 0 && ht[s.peek()] >= ht[i]) {
				s.pop();
			}
			if (s.size() == 0) {
				ser[i] = ht.length;
			} else {
				ser[i] = s.peek();

			}
			s.push(i);
		}
		s = new Stack<>();
		s.push(0);
		for (int i = 1; i < ht.length; i++) {
			while (s.size() > 0 && ht[s.peek()] >= ht[i]) {
				s.pop();
			}
			if (s.size() == 0) {
				sel[i] = -1;
			} else {
				sel[i] = s.peek();

			}
			s.push(i);
		}
		// display(ser);
		// display(sel);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < ht.length; i++) {
			int area = (ser[i] - sel[i] - 1) * ht[i];
			if (area > max) {
				max = area;
			}
		}
		return max;

	}

	public static void uniqueChar(char[] str) {
		// Write your code here
		char[] a = new char[str.length];
		HashMap<Character, Integer> map = new HashMap<>();
		LinkedList<Character> q = new LinkedList<>();
		for (int i = 0; i < str.length; i++) {
			if (map.containsKey(str[i])) {
				map.put(str[i], map.get(str[i]) + 1);
				while (q.size() > 0 && map.get(q.peek()) != 1) {
					q.removeFirst();
				}
				if (q.size() == 0) {
					a[i] = '-';
				} else {
					a[i] = q.peek();
				}
			} else {
				map.put(str[i], 1);
				while (q.size() > 0 && map.get(q.peek()) != 1) {
					q.removeFirst();
				}
				if (q.size() == 0) {
					a[i] = str[i];
				} else {
					a[i] = q.peek();
				}
				q.addLast(str[i]);

			}
		}
	}

	public static int carFleet(int target, int[] p, int[] s) {// only one test
																// case cleared
		int fn = 0;
		// float t=((float)(target-p[0]))/s[0];
		float tl = 0;
		float tr = 0;

		for (int i = s.length - 1; i >= 0; i--) {
			float c = ((float) Math.abs(target - p[i])) / s[i];
			if (p[i] < target && tl == 0) {
				tl = c;
				fn++;

			} else if (p[i] > target && tr == 0) {
				tr = c;
				fn++;

			} else if (p[i] < target && tl != 0) {
				if (c > tl) {
					fn++;
					tl = c;
				}

			} else if (p[i] > target && tr != 0) {
				if (c > tr) {
					fn++;
					tr = c;
				}

			}

		}
		return fn;
	}

	public static int[] asteroidCollision(int[] a) {
		// Write your code

		Stack<Integer> s = new Stack<>();
		s.push(a[0]);
		for (int i = 1; i < a.length; i++) {

			int f = 0;
			while (s.size() > 0 && ((s.peek() < 0 && a[i] > 0))) {
				if (Math.abs(a[i]) == Math.abs(s.peek())) {
					s.pop();
				} else if (Math.abs(a[i]) > Math.abs(s.peek())) {
					s.pop();
				} else {
					f = 1;
					break;
				}
			}
			if (f == 0) {
				s.push(a[i]);
			}
		}
		int[] res = new int[s.size()];
		for (int j = res.length - 1; j >= 0; j--) {
			res[j] = s.pop();
		}
		return res;
	}

	public static int calculator(String s) {
		Stack<String> ns = new Stack<>();
		Stack<Character> cs = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			if ((s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
				int g = i;
				while (g < s.length() && (s.charAt(g) >= '0' && s.charAt(g) <= '9')) {
					g++;
				}

				ns.push(s.substring(i, g));
				i = g;
			} else if (s.charAt(i) == '(') {
				cs.push(s.charAt(i));
				i++;

			} else if (s.charAt(i) == ')') {
				while (cs.peek() != ')') {
					char c = cs.pop();
					int v1 = Integer.parseInt(ns.pop());
					int v2 = Integer.parseInt(ns.pop());
					ns.push(evaluate(v2, v1, c));
				}
				cs.pop();
				i++;

			} else {
				while (cs.size() > 0 && (cs.peek() == '+' || cs.peek() == '-') && (cs.peek() != '(')) {
					char c = cs.pop();
					int v1 = Integer.parseInt(ns.pop());
					int v2 = Integer.parseInt(ns.pop());
					ns.push(evaluate(v2, v1, c));
				}
				cs.push(s.charAt(i));
				i++;

			}
		}

		while (cs.size() != 0) {
			char c = cs.pop();
			int v1 = Integer.parseInt(ns.pop());
			int v2 = Integer.parseInt(ns.pop());
			ns.push(evaluate(v2, v1, c));

		}

		return Integer.parseInt(ns.pop());
	}

	public static String evaluate(int n, int m, char c) {
		if (c == '+') {
			return (n + m) + "";
		} else if (c == '-') {
			return (n - m) + "";
		} else if (c == '*') {
			return (n * m) + "";
		} else if (c == '/') {
			return (n / m) + "";
		} else if (c == '%') {
			return (n % m) + "";
		} else {
			return (n ^ m) + "";
		}
	}

	public static int infix(String s, HashMap<Character, Integer> priority) {// empty
																				// stack
																				// exception
		Stack<String> ns = new Stack<>();
		Stack<Character> cs = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			if ((s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
				int g = i;
				while (g < s.length() && (s.charAt(g) >= '0' && s.charAt(g) <= '9')) {
					g++;
				}

				ns.push(s.substring(i, g));
				i = g;
			} else if (s.charAt(i) == '(') {
				cs.push(s.charAt(i));
				i++;

			} else if (s.charAt(i) == ')') {
				while (cs.peek() != ')') {
					char c = cs.pop();
					int v1 = Integer.parseInt(ns.pop());
					int v2 = Integer.parseInt(ns.pop());
					ns.push(evaluate(v2, v1, c));
				}
				cs.pop();
				i++;

			} else {
				while (cs.size() > 0 && (cs.peek() != '(') && (priority.get(cs.peek()) >= priority.get(s.charAt(i)))) {
					char c = cs.pop();
					int v1 = Integer.parseInt(ns.pop());
					int v2 = Integer.parseInt(ns.pop());
					ns.push(evaluate(v2, v1, c));
				}
				cs.push(s.charAt(i));
				i++;

			}
		}

		while (cs.size() != 0) {
			char c = cs.pop();
			int v1 = Integer.parseInt(ns.pop());
			int v2 = Integer.parseInt(ns.pop());
			ns.push(evaluate(v2, v1, c));

		}

		return Integer.parseInt(ns.pop());
	}

}

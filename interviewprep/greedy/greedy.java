package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class greedy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub]
		Scanner scn = new Scanner(System.in);
//	int n = scn.nextInt();
//		int k = scn.nextInt();
// int[] arr = new int[n];
////		//
//		 for (int i = 0; i < arr.length; i++) {
//		 arr[i] = scn.nextInt();
//		
//		 }
//		 
//		 int[] brr = new int[n];
////			//
//			 for (int i = 0; i < arr.length; i++) {
//			 brr[i] = scn.nextInt();
//			
//			 }
		// int k = scn.nextInt();
		// LexicoSmallestArrayInKSwaps(arr, n, k);
		//String s = scn.next();
		// RearrangeCharacters(s);
		// MaxHeightPyramid(arr,n);
		// MinCostToAcquireAllCoins(arr,n,k);

		// int n1 = scn.nextInt();
		// LinkedList<Integer> s1 = new LinkedList<>();
		// int sum1 = 0;
		// for (int i = 0; i < n1; i++) {
		// int x = scn.nextInt();
		// sum1 += x;
		// s1.addLast(x);
		// }
		// int n2 = scn.nextInt();
		// int sum2 = 0;
		// LinkedList<Integer> s2 = new LinkedList<>();
		// for (int i = 0; i < n2; i++) {
		// int x = scn.nextInt();
		// sum2 += x;
		// s2.addLast(x);
		// }
		// int n3 = scn.nextInt();
		// int sum3 = 0;
		// LinkedList<Integer> s3 = new LinkedList<>();
		// for (int i = 0; i < n3; i++) {
		// int x = scn.nextInt();
		// sum3 += x;
		// s3.addLast(x);
		// }
		// MaxSumPossibleAcrossStacks(s1, s2, s3,sum1,sum2,sum3);

		// MaximumSumAfterKNegations(arr,n,k);
//		int v = scn.nextInt();
//		int[][] graph = new int[v][v];
//		int edges = scn.nextInt();
//
//		int[][] bigrpah = new int[v][v];
//		for (int i = 0; i < edges; i++) {
//			int v1 = scn.nextInt();
//			int v2 = scn.nextInt();
//			graph[v1][v2] = 1;
//			bigrpah[v1][v2] = 1;
//			bigrpah[v2][v1] = 1;
//		}
//		display(graph);
//		System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");
//		display(bigrpah);
//		int src = scn.nextInt();
//		int des = scn.nextInt();
//		boolean[] visited = new boolean[v];
//		MinimumEdgesToReverse(graph, bigrpah, src, des, visited, 0);
//		System.out.println(min);
		//MinimumSumof2NumbersFormedFromDigitsOfArray(arr,n);
		//SmallestNumber(n,k);
		//AbsoluteDifferences(arr,brr);
//		int [][]a=new int[n][n];
//		for(int i=0;i<n;i++)
//		{
//			for(int j=0;j<n;j++)
//			{
//				a[i][j]=scn.nextInt();
//			}
//		}
//		MinimizeCashFlow(a);
//		int [][]qb=new int[n+1][k+1];
//		int cu=PaperCutMinimumSquares(n,k,qb);
//		System.out.println(cu);
		//MinInsertionsPalindrome(s);
//		int n=scn.nextInt();
//		jobsequencingpair []p=new jobsequencingpair[n];
//		for(int i=0;i<n;i++)
//		{ p[i]=new jobsequencingpair();
//			p[i].c=scn.next().charAt(0);
//			p[i].deadline=scn.nextInt();
//			p[i].profit=scn.nextInt();
//		}
//		JobSequencingProblem(p);
//		int n=scn.nextInt();
//		ActivitySelectionpair []p=new ActivitySelectionpair[n];
//		for(int i=0;i<n;i++)
//		{  
//			p[i]=new ActivitySelectionpair();
//			p[i].a=scn.nextInt();
//		}
//		for(int i=0;i<n;i++)
//		{
//			p[i].b=scn.nextInt();
//		}
//		ActivitySelectionProblem(p);
		int n=scn.nextInt();
		int cap=scn.nextInt();
		fractionalknapsackpair []p=new fractionalknapsackpair[n];
		for(int i=0;i<n;i++)
			{ p[i]=new fractionalknapsackpair();
				p[i].value=scn.nextInt();
				p[i].weight=scn.nextInt();
			}
		FractionalKnapSack(p,cap);
	}
	private static void FractionalKnapSack(fractionalknapsackpair[] p, int cap) {
		// TODO Auto-generated method stub
		Arrays.sort(p);
		
		int i=0;
		float max=0;
	while(cap!=0 && i!=p.length )
	{
		if(p[i].weight<=cap)
		{
			cap-=p[i].weight;
			max+=p[i].value;
		}else if(p[i].weight>cap)
		{ 
			max+=p[i].value*((float)cap/p[i].weight);
			cap=0;
		}
		i++;
	}
	System.out.println(max);	
	}
	private static class fractionalknapsackpair implements  Comparable<fractionalknapsackpair>
	{
		int weight;
		int value;
		@Override
		public int compareTo(fractionalknapsackpair o) {
			// TODO Auto-generated method stub
			
			return (o.value/o.weight)-(this.value/this.weight);
		}
		
	}
	private static class ActivitySelectionpair implements Comparable<ActivitySelectionpair>
	{
		int a;
		int b;
		@Override
		public int compareTo(ActivitySelectionpair o) {
			// TODO Auto-generated method stub
			return this.b-o.b;
		}
	}
	private static void ActivitySelectionProblem(ActivitySelectionpair [] p) {
		// TODO Auto-generated method stub
		Arrays.sort(p);
		System.out.println(p[0].a +" "+p[0].b);
		int j=0;
		for(int i=1;i<p.length;i++)
		{
			if(p[i].a>=p[j].b)
			{
				System.out.println(p[i].a+" "+p[i].b);
				j=i;
			}
		}
		
		
	}
	private static void JobSequencingProblem(jobsequencingpair[] p) {
		// TODO Auto-generated method stub
		Arrays.sort(p);
		char []strg=new char[p.length];
		for(int i=0;i<p.length;i++)
		{
			for(int j=p[i].deadline-1;j>=0;j--)
			{
				if(strg[j]=='\u0000')
				{
					strg[j]=p[i].c;
					break;
				}
			}
		}
		
		for(int i=0;i<strg.length;i++)
		{
			if(strg[i]!='\u0000')
			{
				System.out.print(strg[i]+" ");
			}
		}
		
	}
	private static class jobsequencingpair implements Comparable<jobsequencingpair>
	{
		char c;
		int deadline;
		int profit;
		@Override
		public int compareTo(jobsequencingpair o) {
			// TODO Auto-generated method stub
			return o.profit-this.profit;
		}
	}

	private static void MinInsertionsPalindrome(String s) {
		int [][]a=new int[s.length()][s.length()];
		
		
		for(int gap=1;gap<s.length();gap++)
		{
			for(int i=0,j=i+gap;j<s.length();i++,j++)
			{
				if(gap==1)
				{
					a[i][j]=s.charAt(i) != s.charAt(j)? 1: 0;;
				}else 
				if(s.charAt(i)==s.charAt(j))
				{
					a[i][j]=a[i+1][j-1];				
				}else
				{
					a[i][j]=Math.min(a[i+1][j], a[i][j-1])+1;
				}
			}
		}
		
		System.out.println(a[0][s.length()-1]);
		
	}

	private static int PaperCutMinimumSquares(int d1, int d2,int [][]qb) {
		if(d1==0||d2==0)
		{
			return 0;
		}
		if(qb[d1][d2]!=0)
		{
			return qb[d1][d2];
		}
		int cut=Integer.MAX_VALUE;
		for(int size=1;size<=Math.min(d1, d2);size++)
		{
			int cut1=PaperCutMinimumSquares(size, d2-size, qb);
			int cut2=PaperCutMinimumSquares(d1-size, d2, qb);
			
			int cut3=PaperCutMinimumSquares(d1-size, size, qb);
			int cut4=PaperCutMinimumSquares(d1, d2-size, qb);
			int x=0;
			 if(cut1+cut2<cut3+cut4)
			 {
				 x=cut1+cut2;
			 }else 
			 {
				 x=cut3+cut4;
			 }
			if(x+1<=cut)
			{
				cut=x+1;
				
			}

		}
		
		qb[d1][d2]=cut;
		return cut;
		
	}

	private static void MinimizeCashFlow(int[][] a) {
		// TODO Auto-generated method stub
		int []b=new int[a.length];
		int lena=0;
		int dena=0;
		int sumneg=0;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				b[i]-=a[i][j];
				b[i]+=a[j][i];
			}
			if(b[i]<0)
			{
				sumneg+=b[i];
			}
		}
		System.out.println(sumneg*-1);
	}
	
	private static void AbsoluteDifferences(int[] arr, int[] brr) {
		Arrays.sort(arr);
		Arrays.sort(brr);
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			sum+=Math.abs(arr[i]-brr[i]);
		}
		System.out.println(sum);
	}

	private static void SmallestNumber(int s, int d) {
		// TODO Auto-generated method stub
		
		if(s==0) {
			System.out.println(d==0? "0":"Not Possible");
			return;
		}
		if(s>9*d) {
			System.out.println("Not Possible");
			return;
		}
		s-=1;
		int []a=new int[d];
		
		for(int i=a.length-1;i>0;i--)
		{
			if(s>9)
			{
				a[i]=9;
				s-=9;
			}else
			{
				a[i]=s;
				s=0;
			}
		}
		a[0]=s+1;
		for(int h:a)
		{
			System.out.print(h);
		}
		
	}

	private static void MinimumSumof2NumbersFormedFromDigitsOfArray(int[] arr, int n) {
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0; i<arr.length; i++) {
			
			pq.add(arr[i]);
		}
		StringBuilder one=new StringBuilder();
		StringBuilder two=new StringBuilder();
		while(!pq.isEmpty()) {
			int num1=pq.remove();
			one.append(num1);
			if(!pq.isEmpty()) {
				int num2=pq.remove();
				two.append(num2);
			}
		}
		
		int sum=Integer.parseInt(one.toString())+Integer.parseInt(two.toString());
		System.out.println(sum);
	}

	private static int makenumber(int[] a, int i, int j) {
		int pow=(int)Math.pow(10., j-i-1);
		//System.out.println(pow);
		int num=0;
		//System.out.println("......................................");
		for(int x=i;x<=j;x++)
		{
			num+=a[x]*pow;
			pow=pow/10;
		}
		//System.out.println(".................................................");
		return num;
	}

	static int min = Integer.MAX_VALUE;

	private static void MinimumEdgesToReverse(int[][] graph, int[][] bigrpah, int src, int des, boolean[] visited,
			int minedges) {
		if (src == des) {
			if (minedges < min) {
				min = minedges;
			}
			return;
		}
		visited[src] = true;

		for (int i = 0; i < graph.length; i++) {
			if (bigrpah[src][i] == 1 && visited[i] == false) {
				MinimumEdgesToReverse(graph, bigrpah, i, des, visited, graph[src][i] == 1 ? minedges : minedges + 1);

			}
		}
		visited[src] = false;
		
		return;
	}

	private static void MaximumSumAfterKNegations(int[] arr, int n, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.add(arr[i]);
		}

		for (int i = 0; i < k; i++) {
			int x = pq.remove();
			pq.add(x * -1);
		}
		int sum = 0;
		while (pq.size() != 0) {
			sum += pq.remove();
		}

		System.out.println(sum);
	}

	private static void MaxSumPossibleAcrossStacks(LinkedList<Integer> s1, LinkedList<Integer> s2,
			LinkedList<Integer> s3, int sum1, int sum2, int sum3) {
		int maxsum = 0;
		while (s1.size() != 0 && s2.size() != 0 && s3.size() != 0) {
			if (sum1 == sum2 && sum1 == sum3) {
				maxsum += sum1;
				break;
			} else {
				int m = Math.max(sum1, Math.max(sum2, sum3));
				if (m == sum1) {
					sum1 -= s1.removeFirst();
				} else if (m == sum2) {
					sum2 -= s2.removeFirst();
				} else if (m == sum3) {
					sum3 -= s3.removeFirst();
				}
			}
		}

		System.out.println(maxsum);

	}

	private static void MinCostToAcquireAllCoins(int[] arr, int n, int k) {
		// TODO Auto-generated method stub

		Arrays.sort(arr);
		int cost = 0;
		int l = 0;
		int r = n - 1;

		while (l < r) {
			cost += arr[l];
			l++;
			r -= k;
		}
		System.out.println(cost);
	}

	private static void MaxHeightPyramid(int[] arr, int n) {
		Arrays.sort(arr);
		int level = 0;
		int placedsofar = 0;
		// int currelements=0;
		while (placedsofar < arr.length - 1) {
			if ((arr.length - placedsofar) < level) {
				placedsofar += (arr.length - placedsofar);
			} else {
				placedsofar += level;
			}
			level++;
		}
		System.out.println(level - 1);

	}

	private static class rearrangecharacterspair implements Comparable<rearrangecharacterspair> {
		char c;
		int frq;

		@Override
		public int compareTo(rearrangecharacterspair o) {
			if (this.frq != o.frq) {
				return this.frq - o.frq;
			} else {
				return o.c - this.c;
			}
		}

	}

	private static void RearrangeCharacters(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}

		PriorityQueue<rearrangecharacterspair> pq = new PriorityQueue<>();
		ArrayList<Character> keys = new ArrayList<>(map.keySet());
		for (Character t : keys) {
			int fre = map.get(t);
			rearrangecharacterspair p = new rearrangecharacterspair();
			p.c = t;
			p.frq = fre;
			pq.add(p);
		}
		StringBuilder f = new StringBuilder();

		rearrangecharacterspair prev = null;
		while (pq.size() > 0) {
			rearrangecharacterspair curr = pq.remove();

			f.append(curr.c);
			curr.frq -= 1;
			if (prev != null && prev.frq > 0) {
				pq.add(prev);
			}
			prev = curr;

		}

		if (f.toString().length() == s.length()) {
			System.out.println(f);
		} else {
			System.out.println("Invalid");
		}
	}

	private static void LexicoSmallestArrayInKSwaps(int[] arr, int n, int k) {
		int i = 0;
		while (k > 0 && i < arr.length) {
			int min = Integer.MAX_VALUE;
			int minidx = -1;
			for (int j = i; j <= i + k && j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					minidx = j;
				}
			}
			// System.out.println("'''''''''''''''''''''''''''''''''''''''''''''''''''");
			// System.out.println(arr[min]);
			int z = minidx;
			for (int x = 0; x < z - i; x++) {
				int temp = arr[minidx];
				arr[minidx] = arr[minidx - 1];
				arr[minidx - 1] = temp;
				minidx = minidx - 1;
			}
			k -= z - i;
			i++;
			// display(arr);
			// System.out.println("'''''''''''''''''''''''''''''''''''''''''''''");
		}
		display(arr);
	}

	public static void display(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void display(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}

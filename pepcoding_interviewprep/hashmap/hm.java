package hashmap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.jar.Pack200;

import linkedlist.PrintBinaryupton.pair;

public class hm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Scanner scn = new Scanner(System.in);
		// int[] answers = new int[sc.nextInt()];
		// for (int i = 0; i < answers.length; i++) {
		// answers[i] = sc.nextInt();
		// }
		// Scanner scn = new Scanner(System.in);
		// System.out.println(numRats(answers));
		// String s = scn.next();
		// String p = scn.next();
		// System.out.println(findAnagrams(s, p));
		// System.out.println(
		// pairsum(new int[] { 11, 3, 8, 9, 12, 7, 4, 14, 16, 21, 25, 0, 28, 29,
		// 35, 10, 17, 19, 20, 27 }, 7));
		// System.out.println(AreKanagrams("abbaccdadbc", "dddbccbdadb", 3));
		// int k = sc.nextInt();
		// int n = sc.nextInt();
		//
		// int[] arr = new int[n];
		// for (int i = 0; i < n; i++) {
		// arr[i] = sc.nextInt();
		// }
		//
		// int[] ans = kthsmallestfraction(arr, k);
		//
		// System.out.println(ans[0] + "/" + ans[1]);
		// int size = sc.nextInt();
		//
		// long[] arr = new long[size];
		//
		// for (int j = 0; j < size; j++) {
		// arr[j] = sc.nextLong();
		// }
		//
		// zerosumarr(arr);
		// Scanner in = new Scanner(System.in);
		// int n = in.nextInt();
		// int[] a = new int[n];
		// for (int i = 0; i < n; i++) {
		// a[i] = in.nextInt();
		// }
		// System.out.println(countSubArrays(a, n));
		// int n = scn.nextInt();
		// int sum = scn.nextInt();
		// int[] arr = new int[n];
		// for (int z = 0; z < n; z++) {
		// arr[z] = scn.nextInt();
		// }
		// System.out.println(subArraySum(arr, n, sum));
		// Scanner s = new Scanner(System.in);
		// int n = Integer.parseInt(s.nextLine());
		// String[] cpd = new String[n];
		// for (int i = 0; i < cpd.length; i++) {
		// cpd[i] = s.nextLine();
		// }
		// List<String> ans = subdomainVisits(cpd);
		// Collections.sort(ans);
		// System.out.println(ans);
		// int N = sc.nextInt();
		// int[] arr = new int[N];
		// for (int i = 0; i < N; i++) {
		// arr[i] = sc.nextInt();
		// }
		// sortByFreq(arr, N);
		// int n = scn.nextInt();
		// int[] arr = new int[n];
		// for (int i = 0; i < n; i++) {
		// arr[i] = scn.nextInt();
		// }
		// subarrAllOcc(arr);
		// System.out.println(minLength(sc.next()));
		// int n = sc.nextInt();
		// int[] arr = new int[n];
		// for (int i = 0; i < n; i++)
		// arr[i] = sc.nextInt();
		// for (int val : greatestSmaller(arr))
		// System.out.print(val + " ");
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		// findIfFake(br.readLine());
		// int n = sc.nextInt();
		//
		// int[] arr = new int[n];
		// for (int i = 0; i < n; i++) {
		// arr[i] = sc.nextInt();
		// }
		//
		// System.out.println(containsDuplicate(arr));
		// String line = scn.nextLine();
		// System.out.println(getHashValue(line));
		// int n = scn.nextInt();
		// int[] arr = new int[n];
		// for (int i = 0; i < n; i++) {
		// arr[i] = scn.nextInt();
		// }
		// System.out.println(sumLength(arr));
		// String s= scn.next();
		// System.out.print(firstUniqChar(s));
		// Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		// int k = scn.nextInt();
		// int[] num = new int[n];
		// for (int i = 0; i < n; i++) {
		// num[i] = scn.nextInt();
		// }
		// solve(num, k);
		// int row=scn.nextInt();
		// int col=scn.nextInt();
		// int[][] grid= new int[row][col];
		// for(int i=0;i<row;i++){
		// for(int j=0;j<col;j++){
		// grid[i][j]=scn.nextInt();
		// }
		// }
		// System.out.print(islandPerimeter(grid));
		// int n=scn.nextInt();
		// String[] words= new String[n];
		// for(int i=0;i<n;i++)
		// words[i]=scn.next();
		// String[] res= findWords(words);
		// for(int i=0;i<res.length;i++)
		// System.out.print(res[i]+" ");

		// int n = scn.nextInt();
		// int k = scn.nextInt();
		// int[] arr = new int[n];
		// for (int z = 0; z < n; z++) {
		// arr[z] = scn.nextInt();
		// }
		// kthlargestinstream(arr, k);
		// System.out.println(longestsubstringkunqiue("aabbccddddd", 1));
		// Input for number of meetings.
//		int N = sc.nextInt();
//
//		int[][] intervals = new int[N][2];
//
//		int start, end;
//		// Input for intervals.
//		for (int i = 0; i < intervals.length; i++) {
//
//			start = sc.nextInt();
//			end = sc.nextInt();
//
//			intervals[i][0] = start;
//			intervals[i][1] = end;
//		}
//
//		int result = minMeetingRooms(intervals);
//
//		System.out.println(result);
		 char[][] board = new char[9][9];
		 
         for (int i = 0; i < 9; i++) {
             for (int j = 0; j < 9; j++) {
                 board[i][j] = sc.next().charAt(0);
             }
         }
         if (isValidSudoku(board)) {
             System.out.println("Valid");
         } else {
             System.out.println("Invalid");
         }

	}

	 public static boolean isValidSudoku(char[][] board) {
         // write your code here.
         int []row=new int[10];
         int []col=new int[10];
         int [][][]box=new int[3][3][10];
         for(int i=0;i<board.length;i++)
         {
             for(int j=0;j<board[0].length;j++)
             { if(board[i][j]!='.'){
                 if(row[board[i][j]-'0']!='0')
                 {
                     return false;
                 }
                 row[board[i][j]-'0']='1';
             }
                 
             }
         }
         
         for(int i=0;i<board[0].length;i++)
         {
             for(int j=0;j<board.length;j++)
             {  if(board[i][j]!='.'){
                 if(col[board[j][i]-'0']!=0)
                 {
                     return false;
                 }
                 col[board[j][i]-'0']=1;
             }
             }
         }
         
          for(int i=0;i<board.length;i++)
         {
             for(int j=0;j<board[0].length;j++)
             { 
                 if(board[i][j]!='.'){
                 if(box[i%3][j%3][board[i][j]-'0']!=0)
                 {
                     return false;
                 }
                 box[i%3][j%3][board[i][j]-'0']=1;
                 }
                 
             }
         }
 return true;
     }
 
	
	public static void largestfibsubsequence(int[] arr) {
        //Write your code here
        HashMap<Integer, Boolean> map = new HashMap<>();
           HashMap<Integer,Integer> fmap=new HashMap<>();
        int max=arr[0];
        int min=arr[0];
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], true);
			if(arr[i]>max)
			{
			    max=arr[i];
			}
			
			if(arr[i]<min)
			{
			    min=arr[i];
			}
			if(fmap.containsKey(arr[i]))
			{
			    fmap.put(arr[i],fmap.get(arr[i])+1);
			}else
			{
			    fmap.put(arr[i],1);
			}
		}
		int x=0;
		int y=1;

HashSet<Integer> fib=new HashSet<>();
	while(x<=max)
	{
	    fib.add(x);
	   /* if(map.containsKey(x))
	    {
	        System.out.print(x+" ");
	    }*/
	    int sum=y+x;
	    x=y;
	    y=sum;
	}
	
	for(int i=0;i<arr.length;i++)
	{
	    if(fib.contains(arr[i]))
	    {
	       System.out.print(arr[i]+" "); 
	    }
	}

    }
	 public static int equivalentsubarrays(int[] a) {
		 //Write your code here
		 HashSet<Integer> hs=new HashSet<>();
		 for(int i=0;i<a.length;i++)
		 {
		     hs.add(a[i]);
		 }
		 
		 int k=hs.size();
		  HashMap<Integer,Integer>map=new HashMap<>();
		  int count=0;
		 int left=-1;

		 for(int i=0;i<a.length;i++)
		 {
		     
		     if(map.containsKey(a[i]))
		     {
		         map.put(a[i],map.get(a[i])+1);
		     }else
		     {
		        
		         map.put(a[i],1);
		     }
		     while(map.size()==k)
		     {
		         
		         left++;
		         map.put(a[left],map.get(a[left])-1);
		         if(map.get(a[left])==0)
		         {
		             map.remove(a[left]);
		         }
		         count+=a.length-i;
		     }
		 }
		 return count;
		 
		  }
	public static void uniquenumnersfromlr(int l, int r) {
		// Write your code here
		// Start traversing the numbers
		for (int i = l; i <= r; i++) {
			int num = i;
			boolean visited[] = new boolean[10];

			// Find digits and maintain its hash
			while (num != 0) {
				// if a digit occcurs more than 1 time
				// then break
				if (visited[num % 10])
					break;

				visited[num % 10] = true;

				num = num / 10;
			}

			// num will be 0 only when above loop
			// doesn't get break that means the
			// number is unique so print it.
			if (num == 0)
				System.out.print(i + " ");
		}
	}

	static int countOfSubstringWithKOnes(String c, int k) {
		char[] s = c.toCharArray();
		int[] a = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			a[i] = s[i] - '0';
		}
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int rs = 0;
		for (int i = 0; i < a.length; i++) {
			rs += a[i];
			if (map.containsKey(rs - k)) {
				count += map.get(rs - k);
			}
			if (map.containsKey(rs)) {
				map.put(rs, map.get(rs) + 1);
			} else {
				map.put(rs, 1);
			}
		}
		return count;
	}

	static int largestsubarraysum0(int a[], int n) {
		// Write your code here
		int k = 0;
		int max = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int rs = 0;
		for (int i = 0; i < a.length; i++) {
			rs += a[i];
			if (map.containsKey(rs - k)) {
				int len = i - map.get(rs - k);
				if (len > max) {
					max = len;
				}
			} else {
				map.put(rs, i);
			}
		}
		return max;
	}

	public static int minMeetingRooms(int[][] intervals) {
		// write your code here.
		int[] start = new int[intervals.length];
		for (int i = 0; i < intervals.length; ++i) {
			start[i] = intervals[i][0];
		}

		int[] end = new int[intervals.length];
		for (int l = 0; l < intervals.length; ++l) {
			end[l] = intervals[l][1];
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int j = 0;
		int k = 0;
		int rooms = 0;
		int max = Integer.MIN_VALUE;
		while (j < intervals.length) {
			if (start[j] < end[k]) {
				rooms++;
				if (rooms > max) {
					max = rooms;
				}
				j++;
			} else {
				if (start[j] > end[k]) {
					rooms--;
					k++;

				} else {

					k++;
					j++;
				}
			}
		}
		return max;
	}

	public static void display(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static int longestconsecuitveSubsequence(int n, int[] a) {
		// Write oyur code here
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(a[i], true);
		}

		for (int x : map.keySet()) {
			if (map.containsKey(x - 1)) {
				map.put(x, false);
			}
		}
		int max = 0;

		for (int x : map.keySet()) {
			int count = 0;
			while (map.containsKey(x)) {
				x = x + 1;
				count++;

			}
			if (count > max) {
				max = count;
			}

		}

		return max;

	}

	public static int longestPalindrome(String s) {
		// Write your code here
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		int sum = 0;
		int f = 0;
		for (char p : map.keySet()) {
			int x = map.get(p);
			if (x % 2 == 0) {
				sum += x;

			} else {
				f = 1;
				sum += x - 1;
			}
		}
		if (f == 1) {
			sum += 1;
		}
		return sum;
	}

	public static void longestsubarraysumdivisiblebyk(int n, int[] a, int k) {
		// Write your code here
		int max = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int rs = 0;
		for (int i = 0; i < a.length; i++) {
			rs += a[i];
			int x = rs % k;
			if (x < 0) {
				x = x + k;
			}
			if (map.containsKey(x)) {
				int len = i - map.get(x);
				if (len > max) {
					max = len;
				}
			} else {
				map.put(x, i);
			}
		}
		System.out.println(max);

	}

	public static void longestSubArraysumequaltoK(int n, int[] a, int k) {
		// Write your code here

		int max = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int rs = 0;
		for (int i = 0; i < a.length; i++) {
			rs += a[i];
			if (map.containsKey(rs - k)) {
				int len = i - map.get(rs - k);
				if (len > max) {
					max = len;
				}
			} else {
				map.put(rs, i);
			}
		}
		System.out.println(max);
	}

	public static void longestsubstringwithequalonesandzeroes(char[] s) {
		// Writ your code here.
		int[] a = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			a[i] = s[i] - '0';
		}

		for (int i = 0; i < s.length; i++) {
			if (a[i] == 0) {
				a[i] = -1;
			}
		}
		int max = Integer.MIN_VALUE;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int rs = 0;
		for (int i = 0; i < a.length; i++) {
			rs += a[i];
			if (map.containsKey(rs)) {
				int len = i - map.get(rs);
				if (len > max) {
					max = len;
				}
			} else {
				map.put(rs, i);
			}
		}
		System.out.println(max);

	}

	public static int lengthOfLongestSubstringwithoutrepetingchar(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		int left = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				while (map.containsKey(c) == true) {
					left++;
					char f = s.charAt(left);
					map.put(f, map.get(f) - 1);
					if (map.get(f) == 0) {
						map.remove(f);
					}
				}
				map.put(c, 1);
				int length = i - left;
				if (length > max) {
					max = length;
				}

			} else {
				map.put(c, 1);
				int length = i - left;
				if (length > max) {
					max = length;
				}
			}

		}

		return max;

	}

	public static int longestsubstringkunqiue(String s, int k) {
		HashMap<Character, Integer> hs = new HashMap<>();
		int left = -1;
		int l = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (hs.containsKey(c)) {
				hs.put(c, hs.get(c) + 1);
				if (hs.size() == k) {
					int currlength = i - left;
					if (currlength > max) {
						max = currlength;
					}
				}

			} else {
				while (hs.size() > k - 1) {
					left++;
					char f = s.charAt(left);
					hs.put(f, hs.get(f) - 1);
					if (hs.get(f) == 0) {
						hs.remove(f);

					}
				}
				hs.put(s.charAt(i), 1);
				int currlength = i - left;
				if (currlength > max) {
					max = currlength;
				}
			}
		}
		return max;
	}

	public static boolean  ishappy(int n) {
		// write your code here.
		HashSet<Integer> hs = new HashSet<>();
		int num = n;
		while (num != 1) {

			int sum = 0;

			while (num != 0) {
				int x = num % 10;

				sum += Math.pow(x, 2);
				num = num / 10;
			}
			if (hs.contains(sum)) {
				return false;
			} else {
				hs.add(sum);
				num = sum;
			}
		}

		return true;
	}

	public static boolean isIsomorphic(String s, String t) {
		// Write your code here
		HashMap<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				if (map.get(s.charAt(i)) != t.charAt(i)) {
					return false;
				}
			} else {
				map.put(s.charAt(i), t.charAt(i));
			}
		}
		return true;
	}

	public static void kthlargestinstream(int[] a, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int i = 0;
		for (i = 0; i < k - 1; i++) {
			System.out.print("-1" + " ");
			pq.add(a[i]);
		}

		while (i < a.length) {
			System.out.print(pq.peek() + " ");
			if (a[i] > pq.peek()) {

				pq.remove();
				pq.add(a[i]);
			}

			i++;
		}
		// write your code here

	}

	public static String[] findWords(String[] words) {// 1 test case
		HashMap<Character, Integer> map = new HashMap<>();

		char[] carr1 = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
		char[] carr2 = { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' };
		char[] carr3 = { 'z', 'x', 'c', 'v', 'b', 'n', 'm' };
		// Write your code here
		for (int i = 0; i < carr1.length; i++) {
			map.put(carr1[i], 1);
		}

		for (int i = 0; i < carr2.length; i++) {
			map.put(carr2[i], 2);
		}

		for (int i = 0; i < carr3.length; i++) {
			map.put(carr3[i], 3);
		}
		String[] res = new String[words.length];
		int k = 0;
		for (String w : words) {
			String r = w.toLowerCase();
			int f = map.get(r.charAt(0));
			int x = 0;
			for (int j = 1; j < r.length(); j++) {
				if (map.get(r.charAt(j)) != f) {
					x = 1;
					break;
				}
			}
			if (x == 0) {
				res[k] = w;
				k++;
			}

		}
		return res;

	}

	public static int islandPerimeter(int[][] grid) {
		int islands = 0, neighbours = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					islands++; // count islands
					if (i < grid.length - 1 && grid[i + 1][j] == 1) {
						neighbours++; // count down neighbours
					}
					if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
						neighbours++; // count right neighbours
					}
				}
			}
		}

		return islands * 4 - neighbours * 2;
	}

	public static class pair implements Comparable<pair> {
		int freq;
		int x;

		public int compareTo(pair o) {

			return o.freq - this.freq;

		}
	}

	public static ArrayList<Integer> topKFrequent(int n, int[] nums, int k) {
		// Write your code here
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			if (!hm.containsKey(nums[i])) {
				hm.put(nums[i], 1);

			} else {
				hm.put(nums[i], hm.get(nums[i]) + 1);
			}

		}
		ArrayList<Integer> list = new ArrayList<>();

		PriorityQueue<pair> pq = new PriorityQueue<>();
		for (int i1 : hm.keySet()) {
			pair p = new pair();
			p.freq = hm.get(i1);
			p.x = i1;

			pq.add(p);
		}
		for (int i = 0; i < k; ++i) {

			pair p = pq.remove();
			list.add(p.x);

		}

		return list;

	}

	public static void pairwithsum(int[] a, int[] b, int sum) {
		// Write your code here

		Arrays.sort(a);
		Arrays.sort(b);
		int left = 0;
		int right = b.length - 1;
		int f = 0;
		int l = 0;
		int r = 0;
		ArrayList<Integer> ll = new ArrayList<>();
		ArrayList<Integer> rr = new ArrayList<>();
		while (left < a.length && right >= 0) {
			int z = a[left] + b[right];
			if (z == sum) {
				f = 1;
				l = a[left];
				r = b[right];
				ll.add(l);
				rr.add(r);
				left++;
				right--;
			} else if (z < sum) {
				left++;
			} else {
				right--;
			}

		}
		// System.out.println(l+" "+r+" ");
		if (f == 0) {
			System.out.print(-1);
		} else {
			for (int i = 0; i < ll.size() - 1; i++) {
				System.out.print(ll.get(i) + " " + rr.get(i) + ", ");
			}
			System.out.print(ll.get(ll.size() - 1) + " " + rr.get(ll.size() - 1));
		}
	}

	public static int substringswithsimilarfirstandlastchar(String s) {
		// Write your code here
		ArrayList<Integer> list = new ArrayList<>();

		int count = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				count += map.get(c);
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		return count + s.length();
	}

	public static int findoddelement(int[] arr) {
		// write your code here.
		int f = 0;
		for (int i = 0; i < arr.length; i++) {
			f = f ^ arr[i];
		}
		return f;
	}

	public static void solve(int[] arr, int k) {

		// Write your code here
		HashMap<Integer, Integer> hs = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int c = arr[i];
			if (hs.containsKey(c)) {
				hs.put(c, hs.get(c) + 1);
			} else {
				hs.put(c, 1);
			}
		}
		// System.out.println(hs);
		for (int i = 0; i < arr.length; i++) {
			if (hs.containsKey(arr[i]) && hs.get(arr[i]) == 1) {
				System.out.println(arr[i]);
				break;
			}
		}

	}

	public static int firstUniqChar(String s) {
		// Write your code here
		HashMap<Character, Integer> hs = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (hs.containsKey(c)) {
				hs.put(c, hs.get(c) + 1);
			} else {
				hs.put(c, 1);
			}
		}
		System.out.println(hs);
		for (int i = 0; i < s.length(); i++) {
			if (hs.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) == 1) {
				return i;
			}
		}

		return -1;

	}

	public static int sumLength(int[] c) {
		// Write your code here
		HashSet<Integer> hs = new HashSet<>();
		int left = -1;
		float sum = 0;
		for (int i = 0; i < c.length; i++) {
			if (hs.contains(c[i])) {
				while (hs.contains(c[i])) {
					left++;
					// System.out.println("start " + left + "end " + i);
					int l = i - left;
					sum += (l * (l + 1)) / 2;
					hs.remove(c[left]);
				}
				hs.add(c[i]);
			} else {
				hs.add(c[i]);
			}
		}
		int x = hs.size();
		while (x != 0) {

			sum += x * (x + 1) / 2;
			x--;
		}
		return (int) sum;
	}

	// public static int[] topkfrequent()
	public static ArrayList<Integer> twoSum(ArrayList<Integer> a, int sum) {
		// Write your code here
		ArrayList<Integer> b = new ArrayList<>();
		for (int i = 0; i < a.size(); i++) {
			b.add(0);
		}
		Collections.copy(b, a);
		Collections.sort(a);
		int left = 0;
		int right = a.size() - 1;
		int f = 0;
		int l = 0;
		int r = 0;
		while (left < right) {
			int z = a.get(left) + a.get(right);
			if (z == sum) {
				f = 1;
				l = a.get(left);
				r = a.get(right);
				break;
			} else if (z < sum) {
				left++;
			} else {
				right--;
			}

		}
		// System.out.println(l+" "+r+" ");
		ArrayList<Integer> list = new ArrayList<>();
		int k = 0;
		if (f == 1) {
			for (int i = 0; i < a.size(); i++) {
				// System.out.println(a.get(i)+" ");
				if (k == 1) {
					break;
				}
				if (b.get(i) == l) {
					list.add(0, i);
					k++;
				} else if (b.get(i) == r) {
					list.add(1, i);
					k++;
				}
			}

			for (int i = b.size() - 1; i >= 0; i--) {
				// System.out.println(a.get(i)+" ");
				if (k == 2) {
					break;
				}
				if (b.get(i) == r) {
					list.add(1, i);
					k++;
				}
			}
		}
		Collections.sort(list);
		return list;

	}

	public static int getHashValue(String line) {
		String s = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, i);
		}
		int score = 0;
		// ArrayList<String> a=new ArrayList<>();
		String[] a = line.split(" ");
		for (String f : a) {
			for (int i = 0; i < f.length(); i++) {
				score += i + map.get(f.charAt(i));
			}
		}
		return score * a.length;
	}

	public static int tigerzindahai(String[] s) {
		HashSet<String> hs = new HashSet<>();
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("END")) {
				hs.clear();
			} else if (hs.contains(s[i])) {
				hs.remove(s[i]);
			} else {
				hs.add(s[i]);
			}
			// System.out.println(hs);
		}
		return hs.size();
	}

	public static boolean containsDuplicate(int[] nums) {
		// write your code here
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (hs.contains(nums[i])) {
				return true;
			} else {
				hs.add(nums[i]);
			}
		}
		return false;
	}

	public static void findIfFake(String s) {
		// Write your code here
		HashSet<Character> hs = new HashSet<>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int f = 0;
			if (hs.contains(c)) {
				f = 1;
			} else {
				hs.add(c);
			}
			if (c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u') {
				continue;
			} else {
				if (f == 0) {
					count++;
				}
			}
		}
		if (count % 2 == 0) {
			System.out.println("SHE!");
		} else {
			System.out.println("HE!");
		}
	}

	public static int[] greatestSmaller(int[] arr) {
		TreeSet<Integer> set = new TreeSet<>();
		int[] res = new int[arr.length];
		res[0] = -1;
		for (int i = 1; i < arr.length; i++) {
			set.add(arr[i - 1]);
			if (set.lower(arr[i]) == null) {
				res[i] = -1;
			} else {
				res[i] = set.lower(arr[i]);
			}
		}
		return res;

	}

	public static int minLength(String s) {
		// write your code here
		HashSet<Character> hs = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			hs.add(c);
		}

		int left = 0;
		int minlength = Integer.MAX_VALUE;
		// int right=0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);

			} else {
				map.put(c, 1);
			}
			while (map.size() == hs.size()) {
				int mylength = (i - left + 1);
				if (mylength < minlength) {
					minlength = mylength;
				}
				int f = map.get(s.charAt(left));
				if (f == 1) {
					map.remove(s.charAt(left));
				} else {
					map.put(s.charAt(left), f - 1);
				}

				left++;
			}

		}

		return minlength;
	}

	public static void subarrAllOcc(int[] arr) {
		// Write your code here
		HashMap<Integer, mfpair> map = new HashMap<>();
		int mf = 0;
		int msi = -1;
		int mei = -1;
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				mfpair x = map.get(arr[i]);
				x.f++;
				x.ei = i;
				map.put(arr[i], x);
				if (x.f > mf) {
					mf = x.f;
					msi = x.si;
					mei = x.ei;
				} else if (x.f == mf) {
					int ml = mei - msi + 1;
					int cl = x.ei - x.si + 1;
					if (cl < ml) {
						mf = x.f;
						msi = x.si;
						mei = x.ei;
					} else if (cl == ml) {
						if (msi > x.si) {
							mf = x.f;
							msi = x.si;
							mei = x.ei;
						}
					}
				}
			} else {
				map.put(arr[i], new mfpair(1, i, i));
			}
		}

		for (int g = msi; g <= mei; g++) {
			System.out.print(arr[g] + " ");
		}
	}

	public static class mfpair {
		int f;
		int si;
		int ei;

		public mfpair(int ff, int s, int e) {
			f = ff;
			si = s;
			ei = e;
		}

	}

	static void sortByFreq(int a[], int n) {
		// Write your code here
		HashMap<Integer, Integer> map = new HashMap<>();
		int rs = 0;
		for (int i = 0; i < a.length; i++) {
			rs = a[i];
			if (map.containsKey(rs)) {
				map.put(rs, map.get(rs) + 1);
			} else {
				map.put(rs, 1);
			}

		}
		PriorityQueue<sortpair> pq = new PriorityQueue<>();
		for (int y : map.keySet()) {
			sortpair t = new sortpair(y, map.get(y));
			pq.add(t);
		}

		while (pq.size() != 0) {
			sortpair u = pq.remove();
			while (u.f != 0) {
				System.out.print(u.x + " ");
				u.f--;

			}

		}

	}

	public static class sortpair implements Comparable<sortpair> {
		int x;
		int f;

		public sortpair(int xx, int ff) {
			x = xx;
			f = ff;
		}

		@Override
		public int compareTo(sortpair o) {
			if (this.f != o.f) {
				return o.f - this.f;
			} else {
				return (this.x - o.x);
			}
		}
	}

	public static List<String> subdomainVisits(String[] cp) {
		// Write your code here
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < cp.length; i++) {
			String[] s = cp[i].split(" ");
			int freq = Integer.parseInt(s[0]);
			String p = s[1];
			if (map.containsKey(p)) {
				map.put(p, map.get(p) + freq);
			} else {
				map.put(p, freq);
			}
			System.out.println(p);
			String[] h = p.split("\\.");
			String[] g = p.split("\\.", 2);
			if (h.length == 3) {
				if (map.containsKey(g[1])) {
					map.put(g[1], map.get(g[1]) + freq);
				} else {
					map.put(g[1], freq);
				}

				if (map.containsKey(h[2])) {
					map.put(h[2], map.get(h[2]) + freq);
				} else {
					map.put(h[2], freq);
				}

			} else if (h.length == 2) {
				if (map.containsKey(g[1])) {
					map.put(g[1], map.get(g[1]) + freq);
				} else {
					map.put(g[1], freq);
				}

			}

		}

		ArrayList<String> li = new ArrayList<>();

		for (String w : map.keySet()) {

			String p = map.get(w) + " " + w;
			li.add(p);
		}
		return li;

	}

	static int subArraySum(int arr[], int n, int s) {

		// write your code here
		HashMap<Integer, Integer> map = new HashMap<>();

		int count = 0;
		int sum = 0;
		map.put(sum, 1);
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey((sum - s))) {
				count += map.get(sum - s);
			}
			if (map.containsKey(sum)) {

				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}

		}
		return count;

	}

	public static int countSubArrays(int[] arr, int n) {
		// Write your code here.
		HashMap<Long, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}
		int count = 0;
		long sum = 0;
		map.put(sum, 1);
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum)) {
				count += map.get(sum);
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}

		}
		return (count);

	}

	static void zerosumarr(long[] arr) {
		// Write your code here

		HashMap<Long, Integer> map = new HashMap<>();

		int count = 0;
		long sum = 0;
		map.put(sum, 1);
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum)) {
				count += map.get(sum);
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}

		}
		System.out.println(count);

	}

	public static boolean vendor(int[] a, int n, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			} else {
				map.put(a[i], 1);
			}

			if (map.get(a[i]) > max) {
				max = map.get(a[i]);
			}
		}

		if (max <= (2 * k)) {
			return true;
		} else {
			return false;
		}
	}

	public static int[] kthsmallestfraction(int[] a, int k) {
		int[] res = new int[2];
		Arrays.sort(a);
		// for(int i=0;i<a.length;i++)
		// {
		// System.out.print(a[i]+" ");
		// }
		// System.out.println();
		PriorityQueue<kthpair> pq = new PriorityQueue<>();
		for (int i = 0; i < a.length - 1; i++) {
			kthpair p = new kthpair(i, a.length - 1, ((float) a[i] / a[a.length - 1]));
			pq.add(p);
		}
		kthpair kp = null;
		while (k != 0) {
			kp = pq.remove();
			// System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;");
			// System.out.println(a[kp.ni]+" /"+a[kp.di]+" ="+kp.frac);
			// System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");
			if (kp.ni < (kp.di - 1)) {
				kthpair c = new kthpair(kp.ni, kp.di - 1, ((float) a[kp.ni] / (a[kp.di] - 1)));
				// System.out.println("***********************************");
				// System.out.println(a[c.ni]+" /"+a[c.di]+" ="+c.frac);
				// System.out.println("***************************************");
				pq.add(c);
			}

			k--;
		}
		kp = pq.remove();
		res[0] = a[kp.ni];
		res[1] = a[kp.di];
		// System.out.println("..........................................................");
		return res;
	}

	public static class kthpair implements Comparable<kthpair> {
		int ni;
		int di;
		float frac;

		public kthpair(int n, int d, float f) {
			ni = n;
			di = d;
			frac = f;
		}

		@Override
		public int compareTo(kthpair o) {
			// TODO Auto-generated method stub
			if (this.frac - o.frac > 0) {
				return 1;
			} else {

				return -1;
			}

		}
	}

	public static int countarraywithsum(int[] a, int s) {// 1 test case
		HashMap<Integer, Integer> map = new HashMap<>();
		int rs = 0;
		int count = 0;
		map.put(0, 1);
		for (int i = 0; i < a.length; i++) {
			rs = rs + a[i];
			if (map.containsKey(rs)) {
				map.put(rs, map.get(rs) + 1);
			} else {
				map.put(rs, 1);
			}
			int x = rs - s;
			if (map.containsKey(x)) {
				count += map.get(x);
			}
		}
		return count;
	}

	public static boolean checkAp(int[] a) {
		HashSet<Integer> hs = new HashSet<>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
			if (a[i] < min) {
				min = a[i];
			}

			hs.add(a[i]);
		}
		// System.out.println(max);
		// System.out.println(min);
		float d = (max - min) / (a.length - 1);
		// System.out.println(d);
		float f = min;
		while (f != max) {
			if (hs.contains((int) (f + d)) == false) {
				return false;
			}
			f = f + d;
		}
		return true;
	}

	public static boolean isisogram(int[] a) {
		HashSet<Integer> hs = new HashSet<>();

		for (int i = 0; i < a.length; i++) {
			if (hs.contains(a[i])) {
				return false;
			} else {
				hs.add(a[i]);
			}
		}
		// char []c="sjs".toCharArray()
		return true;
	}

	public static boolean iscontiguos(int[] a) {
		HashSet<Integer> hs = new HashSet<>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
			if (a[i] < min) {
				min = a[i];
			}

			hs.add(a[i]);
		}
		if ((max - min + 1 - hs.size()) == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean are2arraysequal(int[] a, int[] b) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			int x = a[i];

			if (map.containsKey(x)) {
				map.put(x, map.get(x) + 1);
			} else {
				map.put(x, 1);
			}
		}
		for (int i = 0; i < b.length; i++) {
			int c = b[i];
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
			} else {
				return false;
			}
		}

		for (int c : map.keySet()) {
			if (map.get(c) != 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean AreKanagrams(String s, String p, int k) {// one test
																	// case
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if (map.containsKey(p)) {
				map.put(c, map.get(c) - 1);
			} else {
				map.put(c, -1);
			}
		}
		int sum = 0;
		for (char g : map.keySet()) {
			if (map.get(g) > 0) {
				sum += map.get(g);
			}
		}
		if (sum > k) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean pairsum(int[] a, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			int x = a[i] % k;
			if (a[i] < 0) {
				x += 7;
			}
			if (map.containsKey(x)) {
				map.put(x, map.get(x) + 1);
			} else {
				map.put(x, 1);
			}
		}

		for (int p : map.keySet()) {
			if (p == 0) {
				if (map.get(p) % 2 != 0) {
					return false;
				}
			} else {
				if (map.get(p) != Math.abs(map.get(k - p))) {
					return false;
				}
			}

		}
		return true;
	}

	public static ArrayList<Integer> findAnagrams(String s, String p) {

		ArrayList<Integer> res = new ArrayList<>();

		int[] sf = new int[26];
		int[] pf = new int[26];
		int i = 0;
		for (i = 0; i < p.length(); i++) {
			pf[p.charAt(i) - 'a']++;
			sf[s.charAt(i) - 'a']++;
		}
		while (i != s.length()) {
			if (compare(sf, pf) == true) {
				res.add(i - p.length());
			}
			sf[s.charAt(i) - 'a']++;
			sf[s.charAt(i - p.length()) - 'a']--;
			i++;
		}
		return res;
	}

	public static boolean compare(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	public static int numRats(int[] answers) {
		// Write your code here
		HashMap<Integer, Integer> hs = new HashMap<>();
		for (int i = 0; i < answers.length; i++) {
			if (hs.containsKey(answers[i])) {
				hs.put(answers[i], hs.get(answers[i]) + 1);
			} else {
				hs.put(answers[i], 1);
			}
		}
		ArrayList<Integer> ls = new ArrayList<>(hs.keySet());

		double sum = 0;
		for (int s : ls) {
			int x = hs.get(s);
			double k = Math.ceil(((double) x) / (s + 1));
			sum += k * (s + 1);
			System.out.println(sum);
		}
		return (int) sum;
	}

}

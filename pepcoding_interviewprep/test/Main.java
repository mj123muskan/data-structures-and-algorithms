package test;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int q = scn.nextInt();
		String[] a = new String[n];

		HashMap<Integer, ArrayList<Integer>> f = new HashMap<>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			a[i] = scn.next();
			int l = a[i].length();
			if (map.containsKey(l)) {
				ArrayList<Integer> list = map.get(l);
				list.add(i);
				map.put(l, list);
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(l, list);
			}

			int[] b = fmap(a[i],new int[5]);
//display(b);
			ArrayList<Integer> r = new ArrayList<>();

			for (int k = 0; k < b.length; k++) {
				r.add(b[k]);
			}
			//System.out.println(r);
			f.put(i, r);

		}
//		System.out.println(map);
//		System.out.println(f);

		for (int i = 0; i < q; i++) {
			String j = scn.next();
			int[] p = fmap(j,new int[5]);
			if (map.containsKey(j.length())) {
				ArrayList<Integer> index = map.get(j.length());
				for (int y : index) {
					int difference = diff(p, f.get(y));
					if (difference <= 1) {
						System.out.println("Yes");
						break;
					} else {
						System.out.println("No");
					}
				}

			} else {
				System.out.println("No");
			}
		}

	}

	public static int diff(int[] a, ArrayList<Integer> b) {
		int d = 0;
		int []p=new int[5];
		for (int i = 1; i < a.length; i++) {
			if(a[i]!=0)
			{
				p[i]+=a[i];
			}
		}
		for (int i = 1; i < a.length; i++) {
			if(b.get(i)!=0)
			{
				p[i]-=b.get(i);
			}
		}
		
		for(int y=0;y<p.length;y++)
		{
			d+=p[y];
		}
		return d;
	}

	public static int[] fmap(String s,int []a) {
		
		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i) - '0']++;
			
		}
		//display(a);
		return a;
	}

	public static void display(int[] a) {
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
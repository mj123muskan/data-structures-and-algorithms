import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class he {
	static HashMap<String, HashMap<String, Integer>> dag = new HashMap<>();
	static HashMap<String, HashMap<String, Integer>> rdag = new HashMap<>();
	static HashMap<String, Boolean> processed;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String s = scn.next();
		String t = scn.next();
		// 6 G Z G U 4 U Z 2 G J 2 J Z 4 U J 3 G Z 1
		ArrayList<pair> k = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String x = scn.next();
			String y = scn.next();
			int z = scn.nextInt();
			pair p = new pair();
			p.v1name = x;
			p.v2name = y;
			p.x = z;
			k.add(p);
		}
		for(pair p:k)
		{
			dag.put(p.v1name, new HashMap<>());
			dag.put(p.v2name, new HashMap<>());
			rdag.put(p.v1name, new HashMap<>());
			rdag.put(p.v2name, new HashMap<>());
		}
		
		for(pair h:k)
		{
			dag.get(h.v1name).put(h.v2name,h.x);
			dag.get(h.v2name).put(h.v1name,h.x);
			rdag.get(h.v1name).put(h.v2name,h.x);
			rdag.get(h.v2name).put(h.v1name,h.x);
		}
		
		int flow = 0;
		while (true) {
			processed = new HashMap<>();
			int pathflow = fordfulkerson(s, t, Integer.MAX_VALUE);
			flow += pathflow;
			if (pathflow == 0) {
				break;
			}
		}
		processed = new HashMap<>();
		dft(s);

		int mincut = 0;
		ArrayList<String> reachables = new ArrayList<>(processed.keySet());
		for (String reachable : reachables) {
			ArrayList<String> nbrs = new ArrayList<>(dag.get(reachable).keySet());
			for (String nbr : nbrs) {
				if (!processed.containsKey(nbr)) {
					
					mincut += dag.get(reachable).get(nbr);
				}
			}
		}
		System.out.println(mincut);

	}

	private static class pair {
		String v1name;
		String v2name;
		int x;
	}

	private static void dft(String src) {
		LinkedList<String> stack = new LinkedList<>();
		stack.addFirst(src);

		while (!stack.isEmpty()) {
			String removed = stack.removeFirst();
			if (processed.containsKey(removed)) {
				continue;
			}
			processed.put(removed, true);
			ArrayList<String> nbrs = new ArrayList<>(dag.get(removed).keySet());
			for (String nbr : nbrs) {
				if (!processed.containsKey(nbr) && rdag.get(removed).get(nbr) > 0) {
					stack.addFirst(nbr);
				}
			}
		}

	}

	private static int fordfulkerson(String v1name, String v2name, int mcap) {
		processed.put(v1name, true);

		if (v1name.equals(v2name)) {
			return mcap;
		}

		ArrayList<String> nbrs = new ArrayList<>(dag.get(v1name).keySet());
		for (String nbr : nbrs) {
			if (!processed.containsKey(nbr) && rdag.get(v1name).get(nbr) > 0) {
				int cap = rdag.get(v1name).get(nbr);
				int revcap = rdag.get(nbr).get(v1name);

				int x = fordfulkerson(nbr, v2name, Math.min(mcap, cap));
				if (x != 0) {
					rdag.get(v1name).put(nbr, cap - x);
					rdag.get(nbr).put(v1name, revcap + x);
					return x;
				}
			}
		}
		// TODO Auto-generated method stub
		return 0;
	}

}

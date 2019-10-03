package dec28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class mincut {//stmincut
	static HashMap<String, HashMap<String, Integer>> dag = new HashMap<>();
	static HashMap<String, HashMap<String, Integer>> rdag = new HashMap<>();
	static HashMap<String, Boolean> processed;

	public static void main(String[] args) {
		dag.put("A", new HashMap<String, Integer>());
		dag.put("B", new HashMap<String, Integer>());
		dag.put("C", new HashMap<String, Integer>());
		dag.put("D", new HashMap<String, Integer>());
		dag.put("S", new HashMap<String, Integer>());
		dag.put("T", new HashMap<String, Integer>());

		rdag.put("A", new HashMap<String, Integer>());
		rdag.put("B", new HashMap<String, Integer>());
		rdag.put("C", new HashMap<String, Integer>());
		rdag.put("D", new HashMap<String, Integer>());
		rdag.put("S", new HashMap<String, Integer>());
		rdag.put("T", new HashMap<String, Integer>());

		dag.get("S").put("A", 10);

		dag.get("S").put("C", 8);

		dag.get("A").put("C", 2);

		dag.get("A").put("B", 5);

		dag.get("C").put("D", 10);

		dag.get("D").put("T", 10);

		dag.get("D").put("B", 8);

		dag.get("B").put("T", 7);

		rdag.get("S").put("A", 10);
		rdag.get("A").put("S", 0);

		rdag.get("S").put("C", 8);
		rdag.get("C").put("S", 0);

		rdag.get("A").put("C", 2);
		rdag.get("C").put("A", 0);

		rdag.get("A").put("B", 5);
		rdag.get("B").put("A", 0);

		rdag.get("C").put("D", 10);
		rdag.get("D").put("C", 0);

		rdag.get("D").put("T", 10);
		rdag.get("T").put("D", 0);

		rdag.get("D").put("B", 8);
		rdag.get("B").put("D", 0);

		rdag.get("B").put("T", 7);
		rdag.get("T").put("B", 0);

		int flow = 0;
		while (true) {
			processed = new HashMap<>();
			int pathflow = fordfulkerson("S", "T", Integer.MAX_VALUE);
			flow += pathflow;
			if (pathflow == 0) {
				break;
			}
		}
		processed = new HashMap<>();
		dft();

		int mincut = 0;
		ArrayList<String> reachables = new ArrayList<>(processed.keySet());
		for (String reachable : reachables) {
			ArrayList<String> nbrs = new ArrayList<>(dag.get(reachable).keySet());
			for (String nbr : nbrs) {
				if (!processed.containsKey(nbr)) {
					System.out.println(reachable + " " + nbr);
					mincut += dag.get(reachable).get(nbr);
				}
			}
		}
		System.out.println(mincut);
	}

	private static void dft() {
		LinkedList<String> stack = new LinkedList<>();
		stack.addFirst("S");

		while (!stack.isEmpty()) {
			String removed = stack.removeFirst();
			if(processed.containsKey(removed))
			{
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

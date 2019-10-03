package dec22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import dec16.Graph;

public class topologicalsort {
	static HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		graph.put("A", new HashMap<>());
		graph.put("B", new HashMap<>());
		graph.put("C", new HashMap<>());
		graph.put("D", new HashMap<>());
		graph.put("E", new HashMap<>());
		graph.put("F", new HashMap<>());

		graph.get("A").put("C", 5);
		graph.get("A").put("F", 10);
		graph.get("B").put("F", 3);
		graph.get("C").put("D", 1);
		graph.get("D").put("E", 5);

		graph.get("B").put("E", 3);

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<String> resultstack = new LinkedList<>();
		ArrayList<String> vnames = new ArrayList<>(graph.keySet());
		for (String vname : vnames) {
			if (processed.containsKey(vname)) {
				continue;
			}

			topologicalsort(vname, processed, resultstack);

		}

		while (!resultstack.isEmpty()) {
			System.out.println(resultstack.removeFirst());
		}
	}

	private static void topologicalsort(String vname, HashMap<String, Boolean> processed, LinkedList<String> stack) {
		if (processed.containsKey(vname)) {
		return;
		}
		processed.put(vname, true);

		ArrayList<String> nbrs = new ArrayList<>(graph.get(vname).keySet());
		for (String nbr : nbrs) {
			
			topologicalsort(nbr, processed, stack);
		}
		stack.addFirst(vname);

	}

}

package aug19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		map.put(1, new ArrayList<>(Arrays.asList(2, 5)));
		map.put(2, new ArrayList<>(Arrays.asList(3, 4)));
		map.put(4, new ArrayList<>(Arrays.asList(3)));
		map.put(5, new ArrayList<>(Arrays.asList(4)));
		map.put(3, new ArrayList<>());

		HashSet<Integer> visited = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= map.size(); i++) {
			if (visited.contains(i)) {
				continue;
			}

			topologicalsort(map, i, visited, stack);

			while (stack.size() != 0) {
				System.out.print(stack.pop() + " ");
			}
		}

	}

	public static void topologicalsort(HashMap<Integer, ArrayList<Integer>> map, int v, HashSet<Integer> visited,
			Stack<Integer> stack) {

		visited.add(v);
		ArrayList<Integer> nbrs = map.get(v);

		for (int nbr : nbrs) {
			if (!visited.contains(nbr)) {
				topologicalsort(map, nbr, visited, stack);
			}
		}

		stack.add(v);

	}

}

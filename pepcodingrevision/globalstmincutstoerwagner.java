import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class globalstmincutstoerwagner {
	static HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();

	private static class phasestmincutpair implements Comparable<phasestmincutpair> {

		ArrayList<String> edges = new ArrayList<>();
		String vname;
		int weightinacquiredset = 0;
		boolean isinpq;

		@Override
		public int compareTo(phasestmincutpair o) {
			// TODO Auto-generated method stub
			return o.weightinacquiredset - this.weightinacquiredset;
		}

	}

	public static void main(String[] args) {

		graph.put("A", new HashMap<>());
		graph.put("B", new HashMap<>());
		graph.put("C", new HashMap<>());
		graph.put("D", new HashMap<>());
		graph.put("E", new HashMap<>());
		graph.put("F", new HashMap<>());

		graph.get("A").put("B", 6);
		graph.get("B").put("A", 6);

		graph.get("B").put("C", 3);
		graph.get("C").put("B", 3);

		graph.get("B").put("D", 8);
		graph.get("D").put("B", 8);

		graph.get("C").put("E", 1);
		graph.get("E").put("C", 1);

		graph.get("E").put("D", 20);
		graph.get("D").put("E", 20);

		graph.get("F").put("E", 2);
		graph.get("E").put("F", 2);

		graph.get("F").put("D", 5);
		graph.get("D").put("F", 5);

		phasestmincutpair globalmincut = new phasestmincutpair();
		globalmincut.weightinacquiredset = Integer.MAX_VALUE;
		while (graph.size() > 1) {
			phasestmincutpair phasestmincut = mincutphase();
			System.out.println(phasestmincut.weightinacquiredset + "  " + phasestmincut.edges);
			if (phasestmincut.weightinacquiredset < globalmincut.weightinacquiredset) {
				globalmincut = phasestmincut;
			}
		}
		System.out.println(globalmincut.weightinacquiredset);
		System.out.println(globalmincut.edges);

	}

	private static phasestmincutpair mincutphase() {
		PriorityQueue<phasestmincutpair> pq = new PriorityQueue<>();
		HashMap<String, phasestmincutpair> totakeobjects = new HashMap<>();
		HashSet<String> acquired = new HashSet<>();
		ArrayList<String> vnames = new ArrayList<>(graph.keySet());
		for (String vname : vnames) {
			phasestmincutpair p = new phasestmincutpair();
			p.vname = vname;
			p.weightinacquiredset = 0;
			p.isinpq = false;
			p.edges = new ArrayList<>();
			totakeobjects.put(vname, p);
		}

		phasestmincutpair p = totakeobjects.get(vnames.get(0));
		pq.add(p);
		totakeobjects.get(vnames.get(0)).isinpq = true;

		// acquiring
		phasestmincutpair sl = null;
		phasestmincutpair l = null;
		while (acquired.size() != graph.size()) {
			phasestmincutpair rp = pq.remove();
			rp.isinpq = false;

			if (acquired.size() == graph.size() - 2) {
				sl = rp;
			} else if (acquired.size() == graph.size() - 1) {
				l = rp;
			}

			acquired.add(rp.vname);

			ArrayList<String> nbrs = new ArrayList<>(graph.get(rp.vname).keySet());
			for (String nbr : nbrs) {
				if (acquired.contains(nbr)) {
					continue;
				}
				phasestmincutpair nbrpair = totakeobjects.get(nbr);

				if (nbrpair.isinpq == false) {
					nbrpair.isinpq = true;
					nbrpair.weightinacquiredset = graph.get(rp.vname).get(nbr);
					nbrpair.edges.add(rp.vname + nbrpair.vname);
					pq.add(nbrpair);
				} else if (nbrpair.isinpq == true) {

					pq.remove(nbrpair);
					nbrpair.weightinacquiredset += graph.get(rp.vname).get(nbr);
					nbrpair.edges.add(rp.vname + nbrpair.vname);
					pq.add(nbrpair);

				}

			}

		}

		// merging

		String newvrtx = sl.vname + l.vname;
		graph.put(newvrtx, new HashMap<>());

		// for secondlast
		ArrayList<String> nbrsofsl = new ArrayList<>(graph.get(sl.vname).keySet());
		for (String nbr : nbrsofsl) {
			if (nbr.equals(l.vname)) {
				continue;
			}

			if (graph.get(newvrtx).containsKey(nbr)) {
				int oweight = graph.get(newvrtx).get(nbr);
				graph.get(newvrtx).put(nbr, oweight + graph.get(sl.vname).get(nbr));
				graph.get(nbr).put(newvrtx, oweight + graph.get(sl.vname).get(nbr));
			} else {
				graph.get(newvrtx).put(nbr, graph.get(sl.vname).get(nbr));
				graph.get(nbr).put(newvrtx, graph.get(sl.vname).get(nbr));
			}

			graph.get(sl.vname).remove(nbr);
			graph.get(nbr).remove(sl.vname);
		}

		// forlast

		ArrayList<String> nbrsofl = new ArrayList<>(graph.get(l.vname).keySet());
		for (String nbr : nbrsofl) {
			if (nbr.equals(sl.vname)) {
				continue;
			}

			if (graph.get(newvrtx).containsKey(nbr)) {
				int oweight = graph.get(newvrtx).get(nbr);
				graph.get(newvrtx).put(nbr, oweight + graph.get(l.vname).get(nbr));
				graph.get(nbr).put(newvrtx, oweight + graph.get(l.vname).get(nbr));
			} else {
				graph.get(newvrtx).put(nbr, graph.get(l.vname).get(nbr));
				graph.get(nbr).put(newvrtx, graph.get(l.vname).get(nbr));
			}

			graph.get(l.vname).remove(nbr);
			graph.get(nbr).remove(l.vname);
		}

		graph.remove(l.vname);
		graph.remove(sl.vname);
		return l;
	}

}

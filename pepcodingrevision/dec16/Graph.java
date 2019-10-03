package dec16;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class Graph {
	private class vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, vertex> vces = new HashMap<>();

	public int numvertices() {
		return vces.size();
	}

	public boolean containsvertex(String vname) {
		if (vces.containsKey(vname)) {
			return true;
		}
		return false;
	}

	public void addvertex(String vname) {
		if (vces.containsKey(vname)) {
			return;
		}
		vertex vtx = new vertex();
		vces.put(vname, vtx);
	}

	public void removevertex(String vname) {
		if (!vces.containsKey(vname)) {
			return;
		}

		ArrayList<String> nbrvtx = new ArrayList<>(vces.get(vname).nbrs.keySet());
		for (String s : nbrvtx) {
			vces.get(s).nbrs.remove(vname);
		}

		vces.remove(vname);
	}

	public int numedges() {
		int sum = 0;
		ArrayList<String> vtx = new ArrayList<>(vces.keySet());
		for (String s : vtx) {
			sum += vces.get(s).nbrs.size();
		}
		return sum / 2;
	}

	public void addedge(String v1name, String v2name, int weight) {
		vertex vrtx1 = vces.get(v1name);
		vertex vrtx2 = vces.get(v2name);

		if (vrtx1 == null || vrtx2 == null) {
			return;
		}
		vrtx1.nbrs.put(v2name, weight);
		vrtx2.nbrs.put(v1name, weight);
	}

	public void removeedge(String v1name, String v2name, int wieght) {
		vertex vrtx1 = vces.get(v1name);
		vertex vrtx2 = vces.get(v2name);

		if (vrtx1 == null || vrtx2 == null) {
			return;
		}
		vrtx1.nbrs.remove(v2name);
		vrtx2.nbrs.remove(v1name);
	}

	public boolean containsedge(String v1name, String v2name) {
		vertex vrtx1 = vces.get(v1name);
		vertex vrtx2 = vces.get(v2name);

		if (vrtx1 == null || vrtx2 == null) {
			return false;
		}
		return vces.get(v1name).nbrs.containsKey(v2name);
	}

	public void display() {
		System.out.println(".................................................................................");
		ArrayList<String> s = new ArrayList<>(vces.keySet());
		for (String k : s) {
			System.out.println(k + " => " + vces.get(k).nbrs);
		}
		System.out.println(
				".............................................................................................");
	}

	public boolean hasPath(String v1name, String v2name) {
		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();
		return hasPathHelper(v1name, v2name, processed, v1name);
	}

	private boolean hasPathHelper(String v1name, String v2name, HashMap<String, Boolean> processed, String psf) {
		if (processed.containsKey(v1name)) {
			return false;
		}
		processed.put(v1name, true);

		// are vtx1 and vtx2 nbrs
		if (containsedge(v1name, v2name) == true) {
			System.out.println(psf + " => " + v2name);
			return true;
		}

		// does a nbr of vtx1 has path till vtx2 - loop
		vertex vtx1 = vces.get(v1name);
		ArrayList<String> nbrnames = new ArrayList<String>(vtx1.nbrs.keySet());
		for (String nbrname : nbrnames) {
			boolean doesNbrHasPath = hasPathHelper(nbrname, v2name, processed, psf + " => " + nbrname);
			if (doesNbrHasPath == true) {
				return true;
			}
		}

		return false;
	}

	public void bft() {
		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			if (processed.containsKey(vname)) {
				continue;
			}
			Pair rootVtxPair = new Pair();
			rootVtxPair.vname = vname;
			rootVtxPair.psf = vname;

			queue.addLast(rootVtxPair);
			while (queue.size() > 0) {
				// 1. dequeue
				Pair rp = queue.removeFirst();

				// 1`. mark it processed
				processed.put(rp.vname, true);

				// 2. work => check dequeued pair and v2 are nbrs or not
				System.out.println(rp.vname + " via " + rp.psf);

				// 3. enqueue the unprocessed nbrs of dequeued pair
				ArrayList<String> nbrnames = new ArrayList<String>(vces.get(rp.vname).nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						Pair np = new Pair();
						np.vname = nbrname;
						np.psf = rp.psf + nbrname;
						queue.add(np);
					}
				}
			}
		}

	}

	public boolean bfsi(String v1name, String v2name) {
		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();
		LinkedList<Pair> queue = new LinkedList<>();

		Pair rootVtxPair = new Pair();
		rootVtxPair.vname = v1name;
		rootVtxPair.psf = v1name;

		queue.addLast(rootVtxPair);
		while (queue.size() > 0) {
			// 1. dequeue
			Pair rp = queue.removeFirst();

			// 1`. mark it processed
			processed.put(rp.vname, true);

			// 2. work => check dequeued pair and v2 are nbrs or not
			System.out.println(rp.vname + " via " + rp.psf);
			if (containsedge(rp.vname, v2name)) {
				return true;
			}

			// 3. enqueue the unprocessed nbrs of dequeued pair
			ArrayList<String> nbrnames = new ArrayList<String>(vces.get(rp.vname).nbrs.keySet());
			for (String nbrname : nbrnames) {
				if (!processed.containsKey(nbrname)) {
					Pair np = new Pair();
					np.vname = nbrname;
					np.psf = rp.psf + nbrname;
					queue.add(np);
				}
			}
		}

		return false;
	}

	public void dft() {

		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();
		LinkedList<Pair> stack = new LinkedList<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			if (processed.containsKey(vname)) {
				continue;
			}
			Pair rootVtxPair = new Pair();
			rootVtxPair.vname = vname;
			rootVtxPair.psf = vname;

			stack.addFirst(rootVtxPair);
			while (stack.size() > 0) {
				// 1. dequeue
				Pair rp = stack.removeFirst();

				// 1`. mark it processed
				processed.put(rp.vname, true);

				// 2. work => check dequeued pair and v2 are nbrs or not
				System.out.println(rp.vname + " via " + rp.psf);

				// 3. enqueue the unprocessed nbrs of dequeued pair
				ArrayList<String> nbrnames = new ArrayList<String>(vces.get(rp.vname).nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						Pair np = new Pair();
						np.vname = nbrname;
						np.psf = rp.psf + nbrname;
						stack.addFirst(np);
					}
				}
			}
		}
	}

	public boolean dfsi(String v1name, String v2name) {
		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();
		LinkedList<Pair> stack = new LinkedList<Graph.Pair>();

		Pair rootVtxPair = new Pair();
		rootVtxPair.vname = v1name;
		rootVtxPair.psf = v1name;

		stack.addFirst(rootVtxPair);
		while (stack.size() > 0) {
			// 1. dequeue
			Pair rp = stack.removeFirst();

			// 1`. mark it processed
			processed.put(rp.vname, true);

			// 2. work => check dequeued pair and v2 are nbrs or not
			System.out.println(rp.vname + " via " + rp.psf);
			if (containsedge(rp.vname, v2name)) {
				return true;
			}

			// 3. enqueue the unprocessed nbrs of dequeued pair
			ArrayList<String> nbrnames = new ArrayList<String>(vces.get(rp.vname).nbrs.keySet());
			for (String nbrname : nbrnames) {
				if (!processed.containsKey(nbrname)) {
					Pair np = new Pair();
					np.vname = nbrname;
					np.psf = rp.psf + nbrname;
					stack.addFirst(np);
				}
			}
		}

		return false;
	}

	public boolean iscyclic() {
		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			if (processed.containsKey(vname)) {
				continue;
			}
			Pair rootVtxPair = new Pair();
			rootVtxPair.vname = vname;
			rootVtxPair.psf = vname;

			queue.addLast(rootVtxPair);
			while (queue.size() > 0) {
				// 1. dequeue
				Pair rp = queue.removeFirst();
				if (processed.containsKey(rp.vname)) {
					return true;
				}
				// 1`. mark it processed
				processed.put(rp.vname, true);

				// 2. work => check dequeued pair and v2 are nbrs or not
				System.out.println(rp.vname + " via " + rp.psf);

				// 3. enqueue the unprocessed nbrs of dequeued pair
				ArrayList<String> nbrnames = new ArrayList<String>(vces.get(rp.vname).nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						Pair np = new Pair();
						np.vname = nbrname;
						np.psf = rp.psf + nbrname;
						queue.add(np);
					}
				}
			}
		}

		return false;
	}

	private class Pair {
		String vname;
		String psf;
	}

	public boolean isbipartite() {
		HashMap<String, String> processed = new HashMap<String, String>();
		LinkedList<pair2> queue = new LinkedList<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			if (processed.containsKey(vname)) {
				continue;
			}
			pair2 rootVtxPair = new pair2();
			rootVtxPair.vname = vname;

			rootVtxPair.color = "red";

			queue.addLast(rootVtxPair);
			while (queue.size() > 0) {
				// 1. dequeue
				pair2 rp = queue.removeFirst();
				if (processed.containsKey(rp.vname) && processed.get(rp.vname) != rp.color) {
					return false;
				}

				processed.put(rp.vname, rp.color);

				// 3. enqueue the unprocessed nbrs of dequeued pair
				ArrayList<String> nbrnames = new ArrayList<String>(vces.get(rp.vname).nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						pair2 np = new pair2();
						np.vname = nbrname;

						if (rp.color == "red") {
							np.color = "green";
						} else
							np.color = "red";
						queue.add(np);
					}
				}
			}
		}

		return true;
	}

	private class pair2 {
		String vname;
		String color;
	}

	public ArrayList<String> gcc()// getconnectedcomponents
	{
		ArrayList<String> result = new ArrayList<>();
		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			if (processed.containsKey(vname)) {
				continue;
			}
			Pair rootVtxPair = new Pair();
			rootVtxPair.vname = vname;
			rootVtxPair.psf = vname;

			queue.addLast(rootVtxPair);
			String comp = "";
			while (queue.size() > 0) {
				// 1. dequeue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}
				// 1`. mark it processed
				processed.put(rp.vname, true);

				comp += rp.vname;

				// 3. enqueue the unprocessed nbrs of dequeued pair
				ArrayList<String> nbrnames = new ArrayList<String>(vces.get(rp.vname).nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						Pair np = new Pair();
						np.vname = nbrname;
						np.psf = rp.psf + nbrname;
						queue.add(np);
					}
				}
			}

			result.add(comp);
		}
		return result;
	}

	public HashMap<String, Djikstrapair> djisktra(String srcvname) {
		HashMap<String, Djikstrapair> h = new HashMap<>();
		PriorityQueue<Djikstrapair> pq = new PriorityQueue<>();

		Djikstrapair p = new Djikstrapair();
		p.vname = srcvname;
		p.csf = 0;
		p.psf = srcvname;
		h.put(srcvname, p);
		pq.add(p);

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			if (!vname.equals(srcvname)) {
				Djikstrapair k = new Djikstrapair();
				k.vname = vname;
				k.psf = null;
				k.csf = Integer.MAX_VALUE;
				h.put(vname, k);
				pq.add(k);

			}
		}
		while (!pq.isEmpty()) {
			Djikstrapair removed = pq.remove();
			ArrayList<String> nbrs = new ArrayList<>(vces.get(removed.vname).nbrs.keySet());

			for (String nbrname : nbrs) {
				Djikstrapair nbrpair = h.get(nbrname);

				int count = removed.csf + vces.get(removed.vname).nbrs.get(nbrpair.vname);
				if (nbrpair.csf > count) {
					nbrpair.csf = count;
					nbrpair.psf = removed.psf + nbrpair.vname;
					// HASHMAP UPDATES ITSELF AS IT HAS ADDRESS OF PAIR OBJECT
					pq.remove(nbrpair);// for updating heap
					pq.add(nbrpair);

				}

			}
		}

		return h;
	}

	public class Djikstrapair implements Comparable<Djikstrapair> {
		String vname;
		String psf;
		int csf;

		@Override
		public int compareTo(Djikstrapair o) {
			// TODO Auto-generated method stub
			return this.csf - o.csf;

		}

		@Override
		public String toString() {
			return "[" + psf + "@" + csf + "]";
		}
	}

	public class primspair implements Comparable<primspair> {
		String vname;
		String parentvname;
		int csf;

		@Override
		public int compareTo(primspair o) {
			// TODO Auto-generated method stub
			return this.csf - o.csf;

		}

	}

	public Graph prims() {
		Graph g = new Graph();
		HashMap<String, primspair> h = new HashMap<>();
		PriorityQueue<primspair> pq = new PriorityQueue<>();

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {

			primspair k = new primspair();
			k.vname = vname;
			k.parentvname = null;
			k.csf = Integer.MAX_VALUE;
			h.put(vname, k);
			pq.add(k);

		}
		while (!pq.isEmpty()) {
			primspair removed = pq.remove();
			ArrayList<String> nbrs = new ArrayList<>(vces.get(removed.vname).nbrs.keySet());
			g.addvertex(removed.vname);
			if (removed.parentvname != null) {
				g.addedge(removed.vname, removed.parentvname, removed.csf);
			}
			for (String nbrname : nbrs) {
				primspair nbrpair = h.get(nbrname);

				int count = vces.get(removed.vname).nbrs.get(nbrpair.vname);
				if (nbrpair.csf > count) {
					nbrpair.csf = count;
					nbrpair.parentvname = removed.vname;

					// HASHMAP UPDATES ITSELF AS IT HAS ADDRESS OF PAIR OBJECT
					pq.remove(nbrpair);// for updating heap
					pq.add(nbrpair);

				}

			}
		}

		return g;

	}

	private class kruskalpair implements Comparable<kruskalpair> {
		String v1name;
		String v2name;
		int wieght;

		@Override
		public int compareTo(kruskalpair o) {
			// TODO Auto-generated method stub
			return this.wieght - o.wieght;

		}
	}

	private class Cluster {
		String data;
		Cluster parent;
		int size;

		public Cluster(String data) {
			// TODO Auto-generated constructor stub
			this.data = data;
			this.parent = this;
			this.size = 1;

		}

		public Cluster find() {
			if (this.parent != this) {
				return this.parent.find();
			} else
				return this;
		}

		public void merge(Cluster other) {
			if (this.size > other.size) {
				other.parent = this;
				this.size += other.size;
			} else {
				this.parent = other;
				other.size += this.size;
			}
		}
	}

	public Graph kruskal() {
		Graph retval = new Graph();
		PriorityQueue<kruskalpair> pq = new PriorityQueue<>();
		HashMap<String, Cluster> partition = new HashMap<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());

		for (String vname : vnames) {
			Cluster cluster = new Cluster(vname);
			partition.put(vname, cluster);

			ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).nbrs.keySet());
			for (String nbrname : nbrs) {
				if (partition.containsKey(nbrname)) {
					continue;
				}
				kruskalpair k = new kruskalpair();
				k.v1name = vname;
				k.v2name = nbrname;
				k.wieght = vces.get(vname).nbrs.get(nbrname);
				pq.add(k);
			}
		}

		while (retval.numedges() != this.numvertices() - 1) {
			kruskalpair p = pq.remove();
			Cluster c1 = partition.get(p.v1name);
			Cluster c2 = partition.get(p.v2name);

			Cluster c1leader = c1.find();
			Cluster c2leader = c2.find();

			if (c1leader != c2leader) {
				retval.addvertex(p.v1name);
				retval.addvertex(p.v2name);
				retval.addedge(p.v1name, p.v2name, p.wieght);

				c1leader.merge(c2leader);
			}

		}

		return retval;
	}

}

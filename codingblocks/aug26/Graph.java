package aug26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

	private class vertex {

		HashMap<String, Integer> edges = new HashMap<>();
	}

	private HashMap<String, vertex> vces = new HashMap<>();

	public int numvertices() {
		return vces.size();
	}

	public boolean containsvertex(String vname) {
		return vces.containsKey(vname);
	}

	public void addvertex(String vname) {
		if (vces.containsKey(vname)) {
			return;
		}
		vertex vtx = new vertex();
		vces.put(vname, vtx);
	}

	public void removevertex(String vname) {
		if (vces.containsKey(vname) == false) {
			return;
		}
		vertex vtx = vces.get(vname);
		ArrayList<String> nbrvtxs = new ArrayList<>(vtx.edges.keySet());
		for (String nbrvtx : nbrvtxs) {
			vertex vtxx = vces.get(nbrvtx);
			vtxx.edges.remove(vname);
		}

		vces.remove(vname);
	}

	public int numedges() {
		int rv = 0;

		ArrayList<String> keys = new ArrayList<>(vces.keySet());

		for (String vnme : keys) {
			vertex vtx = vces.get(vnme);
			rv += vtx.edges.size();
		}
		return rv / 2;
	}

	public boolean containsedge(String v1name, String v2name) {
		vertex vtx1 = vces.get(v1name);
		vertex vtx2 = vces.get(v2name);

		if (vtx1 == null || vtx2 == null) {
			return false;
		}

		return vces.get(v1name).edges.containsKey(v2name);
	}

	public void addedge(String v1name, String v2name, int weight) {
		vertex vtx1 = vces.get(v1name);
		vertex vtx2 = vces.get(v2name);

		if (vtx1 == null && vtx2 == null) {
			return;
		}
		vtx1.edges.put(v2name, weight);
		vtx2.edges.put(v1name, weight);
	}

	public void removeedge(String v1name, String v2name) {
		vertex vtx1 = vces.get(v1name);
		vertex vtx2 = vces.get(v2name);

		if (vtx1 == null && vtx2 == null) {
			return;
		}
		vtx1.edges.remove(v2name);
		vtx2.edges.remove(v1name);
	}

	public void display() {
		System.out.println("----------------------------------------------------------------------------");
		ArrayList<String> vertices = new ArrayList<>(vces.keySet());
		for (String vname : vertices) {
			System.out.println(vname + " => " + vces.get(vname).edges);
		}
		System.out.println("----------------------------------------------------------------------------");
	}

	public boolean haspath(String v1name, String v2name) {
		return haspathhelper(v1name, v2name, new HashMap<>());
	}

	private boolean haspathhelper(String v1name, String v2name, HashMap<String, Boolean> processed) {

		if (processed.containsKey(v1name) == true) {
			return false;
		} else {
			processed.put(v1name, true);
		}
		if (containsedge(v1name, v2name)) {
			return true;
		}

		ArrayList<String> nbrnames = new ArrayList<>(vces.get(v1name).edges.keySet());
		for (String nbrname : nbrnames) {
			boolean rv = haspathhelper(nbrname, v2name, processed);
			if (rv == true) {
				return true;
			}
		}
		return false;
	}

	public boolean bfs(String v1name, String v2name) {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		Pair pair = new Pair(v1name, v1name);
		queue.addLast(pair);
		while (queue.size() != 0) {
			Pair p = queue.removeFirst();
			System.out.println(p.vname + " via " + p.psf);
			if (p.vname.equals(v2name)) {
				return true;
			}
			processed.put(p.vname, true);
			ArrayList<String> nbrnames = new ArrayList<>(vces.get(p.vname).edges.keySet());
			for (String nbrname : nbrnames) {
				if (!processed.containsKey(nbrname)) {
					Pair pairr = new Pair(nbrname, p.psf + nbrname);
					queue.addLast(pairr);
				}
			}

		}
		return false;
	}

	private class Pair {
		String vname;
		String psf;

		public Pair(String vname, String psf) {
			// TODO Auto-generated constructor stub
			this.vname = vname;
			this.psf = psf;
		}

	}

	public boolean isconnected() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		String v1name = vnames.get(0);
		Pair pair = new Pair(v1name, v1name);
		queue.addLast(pair);
		while (queue.size() != 0) {
			Pair p = queue.removeFirst();
			System.out.println(p.vname + " via " + p.psf);

			processed.put(p.vname, true);
			ArrayList<String> nbrnames = new ArrayList<>(vces.get(p.vname).edges.keySet());
			for (String nbrname : nbrnames) {
				if (!processed.containsKey(nbrname)) {
					Pair pairr = new Pair(nbrname, p.psf + nbrname);
					queue.addLast(pairr);
				}
			}

		}
		if (processed.size() == vces.size()) {
			return true;
		} else {
			return false;
		}

	}

	public void bft() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (int i = 0; i < vnames.size(); i++) {
			String v1name = vnames.get(i);
			if (processed.containsKey(v1name)) {
				continue;
			}
			Pair pair = new Pair(v1name, v1name);

			queue.addLast(pair);
			while (queue.size() != 0) {
				Pair p = queue.removeFirst();
				if (processed.containsKey(p.vname)) {
					continue;
				}
				System.out.println(p.vname + " via " + p.psf);

				processed.put(p.vname, true);
				ArrayList<String> nbrnames = new ArrayList<>(vces.get(p.vname).edges.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						Pair pairr = new Pair(nbrname, p.psf + nbrname);
						queue.addLast(pairr);
					}
				}

			}
		}
	}

	public boolean iscyclic() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (int i = 0; i < vnames.size(); i++) {
			String v1name = vnames.get(i);
			if (processed.containsKey(v1name)) {
				continue;
			}
			Pair pair = new Pair(v1name, v1name);

			queue.addLast(pair);
			while (queue.size() != 0) {
				Pair p = queue.removeFirst();
				if (processed.containsKey(p.vname)) {
					return true;
				}
				System.out.println(p.vname + " via " + p.psf);

				processed.put(p.vname, true);
				ArrayList<String> nbrnames = new ArrayList<>(vces.get(p.vname).edges.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						Pair pairr = new Pair(nbrname, p.psf + nbrname);
						queue.addLast(pairr);
					}
				}

			}
		}
		return false;
	}

	public ArrayList<String> gcc() {
		ArrayList<String> result = new ArrayList<>();
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (int i = 0; i < vnames.size(); i++) {
			String v1name = vnames.get(i);
			if (processed.containsKey(v1name)) {
				continue;
			}
			Pair pair = new Pair(v1name, v1name);
			String s = "";
			queue.addLast(pair);
			while (queue.size() != 0) {
				Pair p = queue.removeFirst();
				if (processed.containsKey(p.vname)) {
					continue;
				}
				System.out.println(p.vname + " via " + p.psf);
				s += p.vname;
				processed.put(p.vname, true);
				ArrayList<String> nbrnames = new ArrayList<>(vces.get(p.vname).edges.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {

						Pair pairr = new Pair(nbrname, p.psf + nbrname);
						queue.addLast(pairr);
					}
				}

			}

			result.add(s);
		}
		return result;
	}
	public void dft()
	{
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (int i = 0; i < vnames.size(); i++) {
			String v1name = vnames.get(i);
			if (processed.containsKey(v1name)) {
				continue;
			}
			Pair pair = new Pair(v1name, v1name);

			stack.addFirst(pair);
			while (stack.size() != 0) {
				Pair p = stack.removeFirst();
				if (processed.containsKey(p.vname)) {
					continue;
				}
				System.out.println(p.vname + " via " + p.psf);

				processed.put(p.vname, true);
				ArrayList<String> nbrnames = new ArrayList<>(vces.get(p.vname).edges.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						Pair pairr = new Pair(nbrname, p.psf + nbrname);
						stack.addFirst(pairr);
					}
				}

			}
		}
	}
	
}

package dec21;

import java.util.ArrayList;
import java.util.HashMap;

public class bellmann {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> graphvertices = new ArrayList<>();
		ArrayList<edge> graphedges = new ArrayList<>();

		graphvertices.add("A");
		graphvertices.add("B");
		graphvertices.add("C");
		graphvertices.add("D");

		graphedges.add(new edge("C", "D", 2));
		graphedges.add(new edge("B", "C", 1));
		graphedges.add(new edge("C", "A", -5));
		graphedges.add(new edge("A", "D", 8));
		graphedges.add(new edge("A", "B", 3));

		HashMap<String, blpair> result = new HashMap<>();
		String src = "A";
		for (String vname : graphvertices) {
			blpair pair = new blpair();
			if (vname.equals(src)) {
				pair.csf = 0;
				pair.psf = src;
			} else {
				pair.csf = Integer.MAX_VALUE;
				pair.psf = null;
			}
			result.put(vname, pair);
		}

		for (int i = 1; i <= graphvertices.size() - 1; i++) {
			for (edge edge : graphedges) {
				String v1name = edge.v1name;
				String v2name = edge.v2name;
				int weight = edge.weight;

				blpair sv = result.get(v1name);
				blpair dv = result.get(v2name);
				if (sv.psf == null) {
					continue;
				}

				if (sv.csf + weight < dv.csf) {
					dv.csf = sv.csf + weight;
					dv.psf = sv.psf + v2name;
				}
			}
		}

		for (edge edge : graphedges) {
			String v1name = edge.v1name;
			String v2name = edge.v2name;
			int weight = edge.weight;

			blpair sv = result.get(v1name);
			blpair dv = result.get(v2name);
			if (sv.psf == null) {
				continue;
			}

			if (sv.csf + weight < dv.csf) {
				System.out.println("cycle");
				break;
			}
		}
		System.out.println(result);

	}

	private static class edge {
		String v1name;
		String v2name;
		int weight;

		public edge(String v1name, String v2name, int weight) {
			this.v1name = v1name;
			this.v2name = v2name;
			this.weight = weight;
		}
	}

	private static class blpair {
		String psf;
		int csf;

		@Override
		public String toString() {
			return "[" + this.csf + "=>" + this.psf + "]";
		}
	}

}

package dec21;

import java.util.ArrayList;
import java.util.HashMap;

public class floyd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
		graph.put("A", new HashMap<>());
		graph.put("B", new HashMap<>());
		graph.put("C", new HashMap<>());
		graph.put("D", new HashMap<>());

		graph.get("A").put("B", 5);
		graph.get("A").put("D", 10);
		graph.get("B").put("C", 3);
		graph.get("C").put("D", 1);

		HashMap<String, HashMap<String, fwpair>> result = new HashMap<>();

		ArrayList<String> vnames = new ArrayList<>(graph.keySet());

		for (String svname : vnames) {
			result.put(svname, new HashMap<String, fwpair>());

			for (String dvname : vnames) {

				fwpair fp = new fwpair();
				if (svname.equals(dvname)) {

					fp.dvname = dvname;
					fp.csf = 0;
					fp.psf = dvname;

				} else if (graph.get(svname).containsKey(dvname)) {

					fp.dvname = dvname;
					fp.csf = graph.get(svname).get(dvname);
					fp.psf = svname + dvname;

				} else {
					fp.dvname = dvname;
					fp.csf = Integer.MAX_VALUE;
					fp.psf = null;

				}

				result.get(svname).put(dvname, fp);
			}
		}

		for (String ivname : vnames) {
			for (String svname : vnames) {
				for (String dvname : vnames) {
					if (svname.equals(ivname) || dvname.equals(ivname)) {
						continue;
					}
					fwpair s2d = result.get(svname).get(dvname);
					fwpair s2i = result.get(svname).get(ivname);
					fwpair i2d = result.get(ivname).get(dvname);

					if (s2i.psf == null || i2d.psf == null) {
						continue;
					} else if (s2d.csf > s2i.csf + i2d.csf) {
						s2d.csf = s2i.csf + i2d.csf;
						s2d.psf = s2i.psf + "=>" + i2d.psf;
					}

				}
			}
		}
		System.out.println(result);

	}

	private static class fwpair {
		String dvname;
		int csf;
		String psf;

		@Override
		public String toString() {
			return "[" + this.csf + "@ " + this.psf + "] \n";
		}
	}

}

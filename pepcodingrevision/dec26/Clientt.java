package dec26;//DEC25

import java.util.ArrayList;
import java.util.HashMap;

public class Clientt {
	static HashMap<String, HashMap<String, Integer>> dag = new HashMap<String, HashMap<String, Integer>>();
	static int flow = 0;
	static HashMap<String, Boolean> processed = new HashMap<String, Boolean>();

	public static void main(String[] args) {
		// vertices
				dag.put("A", new HashMap<String, Integer>());
				dag.put("B", new HashMap<String, Integer>());
				dag.put("C", new HashMap<String, Integer>());
				dag.put("D", new HashMap<String, Integer>());
				dag.put("S", new HashMap<String, Integer>());
				dag.put("T", new HashMap<String, Integer>());

				// edges
				dag.get("S").put("A", 10);
				dag.get("A").put("S", 0);
				
				dag.get("S").put("C", 8);
				dag.get("C").put("S", 0);
				
				dag.get("A").put("C", 2);
				dag.get("C").put("A", 0);
				
				dag.get("A").put("B", 5);
				dag.get("B").put("A", 0);
				
				dag.get("C").put("D", 10);
				dag.get("D").put("C", 0);
				
				dag.get("D").put("T", 10);
				dag.get("T").put("D", 0);
				
				dag.get("D").put("B", 8);
				dag.get("B").put("D", 0);
				
				dag.get("B").put("T", 7);
				dag.get("T").put("B", 0);

				while (true) {
					processed = new HashMap<String, Boolean>();
					int localmcap = hasPath("S", "T", Integer.MAX_VALUE);
					if(localmcap == -1){
						break;
					}
				}
				
				System.out.println(flow);
			}

			public static int hasPath(String v1name, String v2name, int mcap) {
				processed.put(v1name, true);

				if (v1name.equals(v2name)) {
					flow += mcap;
					return mcap;
				}

				ArrayList<String> nbrnames = new ArrayList<String>(dag.get(v1name).keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname) && 
						dag.get(v1name).get(nbrname) > 0) {
						int cap = dag.get(v1name).get(nbrname);
						int revcap = dag.get(nbrname).get(v1name);
						int localmcap = hasPath(nbrname, v2name, Math.min(mcap, cap));
						if(localmcap != -1){
							dag.get(v1name).put(nbrname, cap - localmcap);
							dag.get(nbrname).put(v1name, revcap + localmcap);
							return localmcap;
						}
					}
				}

				return -1;
			}

		}

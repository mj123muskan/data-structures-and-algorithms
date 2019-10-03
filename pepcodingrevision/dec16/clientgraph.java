package dec16;

public class clientgraph {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addvertex("A");
		g.addvertex("B");
		g.addvertex("C");
		g.addvertex("D");
		g.addvertex("E");
		g.addvertex("F");
		g.addvertex("G");

		g.addedge("A", "B", 10);
		g.addedge("A", "D", 40);
		g.addedge("B", "C", 10);
		g.addedge("C", "D", 10);
		g.addedge("D", "E", 2);
		g.addedge("E", "F", 3);
		g.addedge("F", "G", 3);
		g.addedge("E", "G", 8);
		g.display();
		g.bft();
//		System.out.println(g.iscyclic());
//		System.out.println(g.isbipartite());
//		System.out.println(g.gcc());
//		System.out.println(g.djisktra("A"));
//		Graph gh=g.prims();
//		gh.display();
		Graph KRUS=g.kruskal();
		KRUS.display();

	}

}

package aug26;

public class clientgraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Graph graph=new Graph();
graph.addvertex("A");
graph.addvertex("B");
graph.addvertex("C");
graph.addvertex("D");
graph.addvertex("E");
graph.addvertex("F");
graph.addvertex("G");
graph.addedge("A", "B", 10);
graph.addedge("C", "D", 10);
graph.addedge("B", "C", 10);
graph.addedge("A", "D", 40);
graph.addedge("D", "E", 2);
graph.addedge("E", "F", 3);
graph.addedge("F", "G", 3);
graph.addedge("E", "G", 8);
graph.display();
//graph.removevertex("A");
//graph.display();
//System.out.println(graph.haspath("A", "G"));
graph.removeedge("D", "C");
graph.removeedge("D", "E");
//System.out.println(graph.haspath("A", "G")););
graph.removeedge("F", "E");
//System.out.println(graph.bfs("A", "G"));
//System.out.println(graph.isconnected());

//graph.bft();
//System.out.println(graph.iscyclic());

System.out.println(graph.gcc());
	}

}

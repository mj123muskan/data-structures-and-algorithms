
public class clienttrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
trie tri=new trie();
tri.addword("art");
tri.addword("arc");
tri.addword("ant");
tri.addword("bet");
tri.addword("be");
tri.addword("bee");
tri.addword("see");
tri.addword("sea");
System.out.println(tri.searchword("art"));
tri.removeword("ant");
System.out.println(tri.searchword("ant"));
	}

}

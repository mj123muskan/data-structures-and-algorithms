import java.util.ArrayList;
import java.util.HashMap;

public class trie {

	private class Node {
		Character data;
		boolean eow;
		HashMap<Character, Node> children = new HashMap<>();

	}

	private Node root = new Node();
	private int numwords = 0;
	private int numnodes = 1;

	public void addword(String word) {
		addword(root, word);
	}

	private void addword(Node parent, String word) {
		if (word.length() == 0) {
			parent.eow = true;
			numwords++;
			return;
		}
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(ch);
		if (child == null) {
			child = new Node();
			child.data = ch;
			parent.children.put(ch, child);
			numnodes++;
		}

		addword(child, ros);

	}

	public boolean searchword(String word) {
		return searchword(root, word);
	}

	private boolean searchword(Node parent, String word) {
		if (word.length() == 0) {
			return parent.eow;
		}
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(ch);
		if (child == null) {
			return false;

		} else {
			return searchword(child, ros);
		}

	}

	public void removeword(String word) {
		removeword(root, word);
	}

	private void removeword(Node parent, String word) {
		if (word.length() == 0) {
			parent.eow = false;
			numwords--;
			return;
		}
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(ch);
		if (child == null) {
			return;
		} else {
			removeword(child, ros);
			if (child.eow == false && child.children.size() == 0) {
				parent.children.remove(child);
				numnodes--;
			}
		}

	}
	public void display() {
		display(root," ");
	}

	private void display(Node parent,String result) {
	
	if(parent.eow==true){
		System.out.println(result);
	}
	
	ArrayList<Character> keys = new ArrayList<>(parent.children.keySet());
	Node keywalachild=parent.children.get(keys);
	
	
	

}

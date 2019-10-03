package aug19;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {

	public class Node {
		char data;
		HashMap<Character, Node> children = new HashMap<>();
		boolean eow;

		Node(char data, boolean eow) {
			this.data = data;
			this.eow = eow;
		}
	}

	Node root;

	public Trie() {
		this.root = new Node('$', false);
	}

	public void addWord(String word) {
		addWord(root, word);
	}

	private void addWord(Node node, String word) {
		if (word.length() == 0) {
			node.eow = true;
			return;
		}
		char c = word.charAt(0);
		if (node.children.size() == 0 || node.children.containsKey(c) == false) {
			Node nc = new Node(c, false);
			node.children.put(c, nc);
		}
		addWord(node.children.get(c), word.substring(1));
	}

	public void displaywords() {
		displaywords(root, "");
	}

	private void displaywords(Node node, String wsf) {
		if (node.eow == true) {
			System.out.println(wsf);
		}
		ArrayList<Character> children = new ArrayList<>(node.children.keySet());
		for (char c : children) {

			displaywords(node.children.get(c), wsf + c);
		}

	}

	public void removeWord(String word) {
		removeWord(root, word);
	}

	private void removeWord(Node node, String word) {
		if (word.length() == 0) {
			node.eow = false;
			return;
		}

		char c = word.charAt(0);
		Node child = node.children.get(c);
		removeWord(node.children.get(c), word.substring(1));
		if (child.children.size() == 0 && child.eow == false) {
			node.children.remove(child);
		}

	}

	public void displayTree() {
		displayTree(root);
	}

	private void displayTree(Node node) {
		// TODO Auto-generated method stub
		ArrayList<Character> children = new ArrayList<>(node.children.keySet());
		System.out.print(node.data + " -> ");
		for (char c : children) {
			System.out.print(" " + c + " , ");

		}
		System.out.println();
		for (char c : children) {
			displayTree(node.children.get(c));
		}

	}

	public boolean searchWord(String word) {
		return searchWord(root, word);
	}

	private boolean searchWord(Node n, String word) {
		if (word.length() == 0) {
			if (n.eow == true) {
				return true;
			} else {
				return false;
			}
		}
		char c = word.charAt(0);
		if (n.children.containsKey(c)) {
			boolean x = searchWord(n.children.get(c), word.substring(1));
			if (x == true) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie t = new Trie();
		t.addWord("are");
		t.addWord("art");
		t.addWord("as");
		t.addWord("ask");
		t.addWord("ant");
		t.addWord("an");
		t.addWord("and");
		t.addWord("seen");
		t.addWord("sea");
		t.addWord("see");
		t.displaywords();
		t.displayTree();
		t.removeWord("seen");
		t.displaywords();
		System.out.println(t.searchWord("art"));
		System.out.println(t.searchWord("seen"));
		

	}

}

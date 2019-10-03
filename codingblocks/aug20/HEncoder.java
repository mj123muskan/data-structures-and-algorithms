package aug20;

import java.util.ArrayList;

public class HEncoder {
	private HashMap<Character, String> encoder = new HashMap<>();
	private HashMap<String, Character> decoder = new HashMap<>();

	private class Node implements Comparable<Node> {
		Character data;
		int freq;
		Node left;
		Node right;

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.freq - o.freq;
		}
	}

	public HEncoder(String feeder) throws Exception {
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < feeder.length(); i++) {
			Character x = feeder.charAt(i);
			if (fmap.containskey(feeder.charAt(i))) {
				fmap.put(x, fmap.get(x) + 1);
			} else {
				fmap.put(x, 1);
			}
		}

		ArrayList<Character> key = new ArrayList<>(fmap.keyset());
		Heap<Node> h = new Heap<>();
		for (Character keys : key) {
			Node node = new Node();
			node.data = keys;
			node.freq = fmap.get(keys);
			h.add(node);
		}

		while (h.size() > 1) {
			Node one = h.remove();
			Node two = h.remove();
			Node merged = new Node();
			merged.freq = one.freq + two.freq;
			merged.left = one;
			merged.right = two;
			h.add(merged);
		}
		Node fn = h.remove();

		traverse(fn, "");
	}

	private void traverse(Node node, String psf) throws Exception {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			encoder.put(node.data, psf);
			decoder.put(psf, node.data);
		}
		traverse(node.left, psf + 0);
		traverse(node.right, psf + 1);

	}

	public String compress(String s) throws Exception {
		String rv = "";
		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);

			rv += encoder.get(ch);

		}
		return rv;
	}

	public String decompress(String s) throws Exception {
		String rv = "";
		String code = "";
		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			code += ch;
			if (decoder.containskey(code)) {
				rv += decoder.get(code);
				code = "";
			}
		}
		return rv;
	}

}

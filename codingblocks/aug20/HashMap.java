package aug20;

import java.util.ArrayList;

public class HashMap<K, V> {
	private class hmnode {
		K key;
		V value;
	}

	private linkedlist<hmnode>[] buckets;// N=buckets.length
	private int size;// n (no of elemebts)

	public HashMap() {
		buckets = new linkedlist[4];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new linkedlist<>();
		}
		this.size = 0;
	}

	private int hashfunction(K key) {
		int hc = key.hashCode();
		hc = Math.abs(hc);
		int bi = hc % (buckets.length);
		return bi;

	}

	private int findwithinbucket(K key, int bi) throws Exception {
		for (int i = 0; i < buckets[bi].size(); i++) {
			hmnode node = buckets[bi].getat(i);
			if (key.equals(node.key)) {
				return i;
			}
		}
		return -1;
	}

	public void put(K key, V value) throws Exception {
		int bi = hashfunction(key);
		int foundinbucket = findwithinbucket(key, bi);

		if (foundinbucket == -1) {
			hmnode n2insert = new hmnode();
			n2insert.key = key;
			n2insert.value = value;
			buckets[bi].addlast(n2insert);
			this.size++;
		} else {
			buckets[bi].getat(foundinbucket).value = value;
		}

		double lambda = (this.size * 1.0) / buckets.length;
		if (lambda > 2.0) {
			rehash();
		}
	}
	private void rehash() throws Exception
	{
		linkedlist<hmnode>[] oa = this.buckets;
		buckets = new linkedlist[2 * oa.length];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new linkedlist<>();
		}
		this.size = 0;

		for (int i = 0; i < oa.length; i++) {
			for (int j = 0; j < oa[i].size(); j++) {
				hmnode node = oa[i].getat(j);
				put(node.key, node.value);
			}

		}
		
	}

	public V get(K key) throws Exception {

		int bi = hashfunction(key);
		int foundinbucket = findwithinbucket(key, bi);

		if (foundinbucket == -1) {
			return null;
		} else {
			return buckets[bi].getat(foundinbucket).value;
		}
	}

	public boolean containskey(K key) throws Exception {
		int bi = hashfunction(key);
		int foundinbucket = findwithinbucket(key, bi);

		if (foundinbucket == -1) {
			return false;
		} else {
			return true;
		}
	}

	public V remove(K key) throws Exception {
		int bi = hashfunction(key);
		int foundinbucket = findwithinbucket(key, bi);

		if (foundinbucket == -1) {
			return null;
		} else {
			this.size--;
			return buckets[bi].removeat(foundinbucket).value;

		}

	}

	public ArrayList<K> keyset() throws Exception {
		ArrayList<K> list = new ArrayList<>();
		for (int i = 0; i < buckets.length; i++) {
			for (int j = 0; j < buckets[i].size(); j++) {
				hmnode node = buckets[i].getat(j);
				list.add(node.key);
			}
		}
		return list;
	}

	public void display() throws Exception {
		System.out.println("----------------");
		for (int i = 0; i < buckets.length; i++) {
			System.out.println();
			System.out.println("B" + i + "=>");
			for (int j = 0; j < buckets[i].size(); j++) {
				System.out.print("[" + buckets[i].getat(j).key + "-" + buckets[i].getat(j).value + "]" + " ");

			}
		}
		System.out.println("----------------");

	}
}

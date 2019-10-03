package jan2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class hungarian {
	static int[][] arr = { { 1500, 4000, 4500 }, { 2000, 6000, 3500 }, { 2000, 4000, 2500 } };
	static HashMap<Integer, HashSet<Integer>> crossedhl;
	static HashMap<Integer, HashSet<Integer>> crossedvl;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean firsttime = true;
		ArrayList<linepair> linestocross = new ArrayList<>();
		while (true) {
			if (firsttime) {
				createzeroesforthefirsttime();
				firsttime = false;
			} else {
				createzerouncovered(linestocross);
			}

			 getminlines();
			if (crossedhl.size()+crossedvl.size() == arr.length) {
				break;
			}

		}
		

	}
	public static void haspath(int row,int col, boolean []rowseen,String psf)
	{
		
	}

	private static void createzerouncovered(ArrayList<linepair> linestocross) {
		int min = Integer.MAX_VALUE;
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				if (crossedhl.containsKey(row)) {
					continue;
				} else if (crossedvl.containsKey(col)) {
					continue;
				} else {
					if (arr[row][col] < min) {
						min = arr[row][col];
					}
				}
			}
		}

		for (int row = 0; row < arr.length; row++) {
			if (crossedhl.containsKey(row) == false) {
				for (int col = 0; col < arr[row].length; col++) {
					arr[row][col] -= min;
				}
			}
		}

		for (int col = 0; col < arr[0].length; col++) {
			if (crossedvl.containsKey(col)) {
				for (int row = 0; row < arr.length; row++) {
					arr[row][col] += min;
				}
			}
		}
	}

	private static void getminlines() {

		HashMap<String, linepair> map = new HashMap<>();
		int countzeroes = 0;

		for (int row = 0; row < arr.length; row++) {
			linepair hline = new linepair(row, 'h');
			for (int col = 0; col < arr[row].length; col++) {
				if (arr[row][col] == 0) {
					countzeroes++;
					hline.zerolocations.add(col);
				}

				map.put("h" + hline.linenum, hline);
			}
		}

		for (int col = 0; col < arr.length; col++) {
			linepair vline = new linepair(col, 'v');
			for (int row = 0; row < arr.length; row++) {
				if (arr[row][col] == 0) {
					vline.zerolocations.add(row);
				}

				map.put("v" + vline.linenum, vline);
			}
		}

		while (countzeroes != 0) {
			linepair relevantline = getrelevantline(new ArrayList<>(map.values()));
			countzeroes -= relevantline.zerolocations.size();

			if (relevantline.linetype == 'h') {
				crossedhl.put(relevantline.linenum, relevantline.zerolocations);
				for (int a : relevantline.zerolocations) {
					map.get("v" + a).zerolocations.remove(relevantline.linenum);
				}
			} else {
				crossedvl.put(relevantline.linenum, relevantline.zerolocations);
				for (int a : relevantline.zerolocations) {
					map.get("h" + a).zerolocations.remove(relevantline.linenum);
				}

			}

			map.remove(relevantline);

		}
	}

	private static linepair getrelevantline(ArrayList<linepair> arrayList) {
		linepair lp = new linepair(-1, ' ');
		for (linepair a : arrayList) {
			if (a.zerolocations.size() > lp.zerolocations.size()) {
				lp = a;
			}
		}
		return lp;
	}

	public static void createzeroesforthefirsttime() {// for rows

		for (int row = 0; row < arr.length; row++) {
			int min = Integer.MAX_VALUE;
			for (int col = 0; col < arr[row].length; col++) {
				if (arr[row][col] < min) {
					min = arr[row][col];
				}

			}

			for (int col = 0; col < arr[row].length; col++) {
				arr[row][col] -= min;

			}
		}

		for (int col = 0; col < arr[0].length; col++) {// for columns
			int min = Integer.MAX_VALUE;
			for (int row = 0; row < arr.length; row++) {
				if (arr[row][col] < min) {
					min = arr[row][col];
				}

			}

			for (int row = 0; row < arr.length; row++) {
				arr[row][col] -= min;

			}
		}

	}

	private static class linepair {
		int linenum;
		char linetype;
		HashSet<Integer> zerolocations = new HashSet<>();

		public linepair(int linenum, char linetype) {
			this.linenum = linenum;
			this.linetype = linetype;
		}
	}
}

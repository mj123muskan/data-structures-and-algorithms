package dec30;

import java.util.HashMap;

public class maxbipartitematching {
	static int[] ajmap;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean[] seen = new boolean[4];
		int[][] em = new int[5][4];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				em[i][j] = 0;
			}
		}
		ajmap = new int[4];
		for (int k = 0; k < 4; k++) {
			ajmap[k] = -1;
		}
		em[0][0] = 1;
		em[1][0] = 1;
		em[1][2] = 1;
		em[2][1] = 1;
		em[2][2] = 1;
		em[2][3] = 1;
		em[3][2] = 1;
		em[4][2] = 1;

		for (int i = 0; i < 5; i++) {//applicants
			seen = new boolean[4];

			boolean x = getjob(em, i, seen);

		}
		for (int i = 0; i < 4; i++) {
			System.out.print(ajmap[i]+"   ");
		}
		System.out.println();

	}

	private static boolean getjob(int[][] em, int a, boolean[] seen) {

		for (int j = 0; j < 4; j++) {//jobs

			if (em[a][j] == 1) {//ifinterestedinjob
			if (seen[j] == true) {//if already seen this job and no use
				continue;
			}
			seen[j]=true;
			
				if (ajmap[j] == -1) {//if interested and job available
					ajmap[j]= a;
					return true;
				} else {
					if (getjob(em, ajmap[j], seen)) {//the job not avaible but the other person takes another job
						ajmap[j]= a;
						return true;
					}
				}
			}

		}
		return false;
	}

}

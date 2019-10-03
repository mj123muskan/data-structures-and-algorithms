package aug19;

public class timeandspace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = new int[31];

		x[0] = -1;
		x[1] = -1;
		for (int i = 2; i * i <= 30; i++) {
			for (int j = i; j * i <= 30; j++) {
				x[i * j] = -1;
			}
		}

		int[] b = new int[31];
		int j = 0;
		for (int i = 0; i < b.length; i++) {
			if (x[i] != -1) {
				b[j] = i;
				j++;
			}
		}

		int k = 0;
		int l = b.length - 1;
		int p = 0;
		while (k < l) {
			if (p == 0) {
				x[b[k]] = b[l];
				p = 1;

			} else {
				x[b[l]] = b[k];
				p = 0;
			}

		}

	}

	

}

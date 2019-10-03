package aug19;

public class KMP_patternmatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src = "aaabaabaaabaababbaabbba";
		String pat = "abaab";
		kmp(src, pat);

	}

	public static void kmp(String src, String pat) {
		int[] lps = getlps(pat);
		int i = 0;
		int j = 0;

		while (i < src.length()) {
			if (src.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
				if (j == pat.length()) {
					System.out.println("found at " + (i - j));
					j = lps[j - 1];
				}
			} else {
				if (j > 0) {
					j = lps[j - 1];
				} else if (j == 0) {
					i++;
				}
			}
		}
	}

	private static int[] getlps(String pat) {
		// TODO Auto-generated method stub
		int i = 1;
		int l = 0;
		int[] lps = new int[pat.length()];
		while (i < pat.length()) {
			
			if (pat.charAt(i) == pat.charAt(l)) {
				lps[i] = l+1;
				i++;
				l++;

			} else {
				if (l > 0) {
					l = lps[l - 1];
				} else {
					i++;
				}
			}
		}
		for (int j = 0; j < lps.length; j++) {
			System.out.print(lps[j] + " ");
		}
		System.out.println();
		return lps;
	}

}

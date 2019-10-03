import java.util.HashMap;
import java.util.Scanner;

public class hack2 {
	public static 	HashMap<Integer, HashMap<Integer, String>> graph = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int i = 0; i < n; i++) {
			graph.put(i, new HashMap<>());
		}
		for (int i = 0; i < n; i++) {
			graph.get(i).put((i + 1) % n, "R");
			graph.get(i).put((i - 1 + n) % n, "L");

		}
		
		int count=0;
		getcount(count,n,'L',0,0);
		HashMap<String,Boolean> processed=new HashMap<>();
	}

	private static void getcount(int count, int n,char ch,int src,int des) {
		
		
	}

}

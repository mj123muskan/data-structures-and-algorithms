import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class graphcolouring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, HashMap<Integer, Integer>> g = new HashMap<>();
		System.out.println("enter no. of vertices");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int i = 0; i < n; i++) {
			g.put(i, new HashMap<>());
		}
		HashMap<Integer, Integer> h = new HashMap<>();
		h.put(2, 0);
		h.put(0, 0);
		g.put(1, h);
		
		h = new HashMap<>();
		h.put(3, 0);
		h.put(1, 0);
		h.put(0, 0);
		g.put(2, h);
		h = new HashMap<>();
		
		h.put(2, 0);
		h.put(0, 0);
		g.put(3, h);
		h = new HashMap<>();
		
		h.put(2, 0);
		h.put(3, 0);
		h.put(1, 0);
		g.put(0, h);
		ArrayList<Integer> colours =new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			
		}
	}

}

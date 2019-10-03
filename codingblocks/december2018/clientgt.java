package december2018;

public class clientgt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
				-1 };
		int[] a = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };
		int[] b = { 10, 40, 100, -1, -1, 30, 90, -1, 80, 120, -1, 110, -1, -1, 70, -1, -1, 20, 60, -1, 50, -1, -1, -1 };
		generictree gt = new generictree(arr);
		//generictree t = new generictree(b);
		gt.display();
		// System.out.println(gt.size());
		// System.out.println(gt.max());
		// System.out.println(gt.height());
		// System.out.println(gt.find(120));
		// System.out.println(gt.serialize());
		// System.out.println(gt.nodetorootPath(100));
		//// gt.removeleaves();
		//// gt.display();
		// System.out.println(".........................");
		// gt.linearize();
		// gt.display();
//		System.out.println(gt.secondlargest());
//		System.out.println(gt.isisomorphic(gt, t));
		//System.out.println(gt.ismirror(gt,t));
		gt.multisolver();
		//System.out.println(gt.predecessor(110));
		gt.multi(110);
	}

}

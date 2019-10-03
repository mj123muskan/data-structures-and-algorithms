package pepcodingrevesion;

public final class clientSegmentTree {

	public static void main(String[] args) {
		int[] arr={2,5,7,8,-2,0,6,3};
		SegmentTree st=new SegmentTree(arr);
		st.display();
		System.out.println(st.getsum(2, 6));

	}

}

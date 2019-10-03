package august5;

public class clientbinarytree {

	public static void main(String[] args) {
//		50 true 25 true 12 false false true 37 true 30 false false true 40 false false true 75 true 62 true 60 false false true 70 false false true 87 false false
//10 true 20 true 40 true 60 false false true 70 false true 100 false false false true 30 false true 50 true 80 true 110 false false false true 90 false false		
	//2 true 1 false false true 3 false false	
		binarytree bt=new binarytree();
		bt.display();
//		bt.pws();
	System.out.println("......................................................................");
//		bt.display();
		//System.out.println(bt.sumofallnodes());
		bt.dublicateq2();
		bt.display();
		System.out.println("......................................................................");
		bt.sumofallroottoleafpaths();

	}

}

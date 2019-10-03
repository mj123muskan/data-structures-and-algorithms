package july29;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class clientgenerictree {

	public static void main(String[] args) {
		//10 3 20 2 50 0 60 0 30 3 70 2 110 0 120 0 80 0 90 2 140 0 150 0 40 1 100 0
//		
//	generictree tree=new generictree();
	generictree tre=new generictree();

	System.out.println("--------------------------------------------------------------------------------");
//System.out.println(tree.size2());
//System.out.println(tree.max2());
//System.out.println(tree.hieght());
//System.out.println(tree.find(6));
//tree.printatdepth(3);
//tree.mirror();
//tree.display();
//tree.linearize();
//tree.display();
//tree.flatten();
//tree.display();
//tree.removeleaf();
//	System.out.println(tree.sumofallnodes());
//tree.display();
	System.out.println(tre.countleaves());
	tre.display();
}
}

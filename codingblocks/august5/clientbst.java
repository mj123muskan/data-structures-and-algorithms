package august5;

public class clientbst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []sa={12,25,37,50,62,75,87};
		bst bst=new bst(sa);
		bst.display();
		bst.pir(13, 80);
		bst.add(65);
		bst.add(90);
		bst.add(2);
		System.out.println(".............................");
		bst.display();
		bst.remove(50);
		System.out.println(".............................");
		bst.display();
		
		

	}

}

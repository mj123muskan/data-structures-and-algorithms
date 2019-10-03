package july19;

public class client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		stack s=new dynamicstack(5);
		System.out.println(s.isempty());
		s.push(10);
		s.display();
		s.push(10);
		s.display();
		s.push(10);
		s.display();
		s.push(10);
		s.display();
		s.push(10);
		s.display();
		s.push(10);
		s.display();
		s.pop();
		s.display();
		s.pop();
		s.display();
		s.pop();
		s.display();
//		s.pop();
//		s.display();
//		s.pop();
//		s.display();
//		s.pop();
//		s.display();
		System.out.println(s.top());
		System.out.println(s.size());
		System.out.println(s.isempty());
		

	}

}

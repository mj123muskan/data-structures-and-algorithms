package july19;

public class clientq {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		qeue q=new dynamicqueue(5);
		q.enqueue(10);
		q.display();
		q.enqueue(20);
		q.display();
		q.enqueue(30);
		q.display();
		q.enqueue(40);
		
		
		q.display();
		q.dequeue();
		q.display();
		q.dequeue();
		q.display();
		
		q.enqueue(50);
		q.display();
		q.enqueue(60);
		q.display();
		q.enqueue(70);
		q.display();
		q.enqueue(80);
		q.display();
		
		

	}

}

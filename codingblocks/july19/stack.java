package july19;

public class stack {
	int [] data;
	int tos =-1;
	
	public stack(int cap)
	{
		this.data=new int[cap];
	}
	public int  top() throws Exception
	{
		if(this.tos==-1)
		{
			 throw new Exception("Stack is empty");
		}
		
		return this.data[this.tos];
		
		
	}
	public void push(int val) throws Exception
	{  if(this.tos==this.data.length-1)
	{
		 throw new Exception("Stack is full");
	}
	
	this.tos++;
	this.data[this.tos]=val;
		
	}
	
	public int pop() throws Exception
	{  if(this.tos==-1)
	{
		 throw new Exception("Stack is empty");
	}
	
		int temp= this.data[this.tos];
		this.data[this.tos]=0;
		this.tos--;
		return temp;
		
	}
	public void display()
	{ System.out.println("-----------");
		for(int i=tos;i>=0;i--)
		{
			System.out.print(this.data[i] + "  ");
		}
		System.out.println(".");
		System.out.println("-----------");
	}
	public int size()
	{  
		return this.tos+1;
		
	}
	public boolean isempty()
	{
		if( this.tos==-1)
			return true;
		else return false;
	}

}

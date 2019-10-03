package july19;

public class dynamicqueue extends qeue {
	public dynamicqueue(int cap)
	{
		super(cap);
	}
	public void enqueue(int val) throws Exception {
		if (this.size == this.data.length) {
			int []oa= this.data;
			this.data=new int [2*oa.length];
			
			for(int i=0;i<size;i++)
			{
				this.data[i]=oa[(front+i)%oa.length];
			}
			front=0;
		}

		int tail = (this.front + this.size) % this.data.length;
		this.data[tail] = val;
		this.size++;

	}

	
	

}

package SegmentTree;

public class SumOperator implements IOperator{
	public int operation(int lhs, int rhs)
	{
		return lhs+rhs;
	}

	public int identity()
	{
		return 0;
	}
}

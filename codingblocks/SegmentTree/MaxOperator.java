package SegmentTree;

public class MaxOperator implements IOperator{
	public int operation(int lhs, int rhs)
	{
		return Math.max(lhs, rhs);
	}

	public int identity()
	{
		return Integer.MIN_VALUE;
	}
}

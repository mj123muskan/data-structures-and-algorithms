package SegmentTree;

public class MinOperator implements IOperator {
	public int operation(int lhs, int rhs)
	{
		return Math.min(lhs, rhs);
	}

	public int identity()
	{
		return Integer.MAX_VALUE;
	}
}

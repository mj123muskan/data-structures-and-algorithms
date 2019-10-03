package SegmentTree;

public interface IOperator {
	int operation(int lhs, int rhs);

	int identity();
}

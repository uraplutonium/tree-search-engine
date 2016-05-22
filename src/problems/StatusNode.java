package problems;

import java.util.List;

public abstract class StatusNode {
	
	private int cost = 0;
	private int parentNumber = -1;
	
	@Override
	public abstract int hashCode();
	
	@Override
	public abstract boolean equals(Object obj);
	
	public abstract List<StatusNode> expand();
	
	public abstract void displayNode();
	
	public abstract int costTo(StatusNode otherNode) throws Exception;
	
	public int h(StatusNode GOAL) {
		return 0;
	}
		
	public boolean isSolved(StatusNode GOAL) {
		return equals(GOAL);
	}
	
	public final void setParentNumber(int num) {
		parentNumber = num;
	}
	
	public final int getParentNumber() {
		return parentNumber;
	}
	
	public final void setCost(int c) {
		cost = c;
	}
	
	public final int getCost() {
		return cost;
	}

}

package algorithms;

import java.util.LinkedList;
import problems.StatusNode;

public class LocalHeuristicOPENTable extends LinkedList<StatusNode> implements OPENTable {

	private static final long serialVersionUID = 1L;
	private static int lastNodeParentNum = -1;

	@Override
	public boolean add(StatusNode node) {
		if(isEmpty()) {
			super.add(node);
		}
		else if(node.getParentNumber() != lastNodeParentNum) {
			addFirst(node);
		}
		else {
			LinkedList<Integer> hList = new LinkedList<Integer>();
			for(StatusNode n : this) {
				if(node.getParentNumber() == n.getParentNumber())
					hList.add(n.h(TreeSearchEngine.GOAL));
				else
					break;
			}
			int hCurrent = node.h(TreeSearchEngine.GOAL);
			int i;
			for(i=0; i<hList.size() && hCurrent > hList.get(i); i++)
				;
			add(i, node);
		}
		lastNodeParentNum = node.getParentNumber();
		return true;
	}

	@Override
	public StatusNode getNextNode() {
		return poll();
	}

}

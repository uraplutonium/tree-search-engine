package algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import problems.StatusNode;

/**
 * @author Felix
 * @see page 52
 */
public class TreeSearchEngine {
	
	private OPENTable OPEN;
	private Map<Integer, StatusNode> CLOSED = new HashMap<Integer, StatusNode>();
	
	public static StatusNode GOAL;
	
	public TreeSearchEngine(OPENTable OPEN) {
		this.OPEN = OPEN;
	}
	
	public boolean search(StatusNode START, StatusNode GOAL) {
		TreeSearchEngine.GOAL = GOAL;
		OPEN.clear();
		CLOSED.clear();
		int parentNumber = 0;
		
		// Step 1
		START.setParentNumber(0);
		START.setCost(0);
		OPEN.add(START);
		
		// Step 2
		while(!OPEN.isEmpty()) {
			displayCLOSED();	// DISPLAY CLOSED
			displayOPEN();		// DISPLAY OPEN
			
			// Step 3
			StatusNode N = OPEN.getNextNode();
			CLOSED.put(++parentNumber, N);
						
			// Step 4
			if(N.isSolved(GOAL)) {	// Note: isSolved(), NOT equals()
				return true;
			}
			else{
				List<StatusNode> children = N.expand();
				// Step 5
				if(children != null) {
					// Step 6
					for(StatusNode n : children) {
						n.setParentNumber(parentNumber);
						try {
							n.setCost(N.getCost() + N.costTo(n));
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						// Step 6.1
						if(!n.equals(CLOSED.get(N.getParentNumber()))) {
							// Step 6.2
							if(OPEN.contains(n) || CLOSED.containsValue(n)) {
								int newCost = 0;
								try {
									newCost = N.getCost()+N.costTo(n);
									
								} catch (Exception e) {
									e.printStackTrace();
								}
								
								if(newCost < n.getCost()) {
									n.setParentNumber(parentNumber);
									n.setCost(newCost);
									
									// Step 6.3
									if(CLOSED.containsValue(n)) {
										n.displayNode();
										
										int key = -1;
										for(int k : CLOSED.keySet())
											if(CLOSED.get(k).equals(n))
												key = k;
										StatusNode nodeToTransfer = CLOSED.remove(key);
										OPEN.add(nodeToTransfer);
									}
								}
							}
							else	// Step 6.4
								OPEN.add(n);
						}
					}
				}
				else
					parentNumber--;
			}
		}
		return false;
	}
	
	public void displayOPEN() {
		System.out.println("========= OPEN =========");
		for(StatusNode n : OPEN) {
			System.out.print("Node: ");
			System.out.println("H: " + n.h(GOAL));
			n.displayNode();
			System.out.print("  cost: " + n.getCost());
			System.out.println("  Parent number: " + n.getParentNumber());
		}
		System.out.println("========================");
	}
	
	public void displayCLOSED() {
		System.out.println("======== CLOSED ========");
		for(int i : CLOSED.keySet()) {
			StatusNode n = CLOSED.get(i);
			System.out.print("N: " + i + "\tNode: ");
			System.out.println("H: " + n.h(GOAL));
			n.displayNode();
			System.out.print("  cost: " + n.getCost());
			System.out.println("  Parent number: " + n.getParentNumber());
		}
	}
	
	public void displayPath() {
		int max = -1;
		for(int i : CLOSED.keySet()) {
			if(i > max)
				max = i;
		}
		StatusNode node =CLOSED.get(max);
		Stack<StatusNode> nodeStack = new Stack<StatusNode>();
		for( ; node.getParentNumber()!=0 ; node=CLOSED.get(node.getParentNumber()))
			nodeStack.push(node);
		nodeStack.push(node);
		int i=0;
		while(!nodeStack.isEmpty()) {
			i++;
			System.out.println(i + ".");
			nodeStack.pop().displayNode();
		}
	}
}

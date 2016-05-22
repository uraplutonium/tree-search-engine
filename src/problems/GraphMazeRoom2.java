package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GraphMazeRoom2 extends StatusNode{
	
	private String name;
	private static Map<String, List<StatusNode>> connectionMap = null;
	
	public GraphMazeRoom2(String name) {
		this.name = name;
		
		if(connectionMap == null) {
			connectionMap = new HashMap<String, List<StatusNode>>();
			
			List<StatusNode> C1 = new ArrayList<StatusNode>();
			C1.add(new GraphMazeRoom2("R2"));
			C1.add(new GraphMazeRoom2("R5"));
			connectionMap.put("R1", C1);
			
			List<StatusNode> C2 = new ArrayList<StatusNode>();
			C2.add(new GraphMazeRoom2("R1"));
			C2.add(new GraphMazeRoom2("R3"));
			connectionMap.put("R2", C2);
			
			List<StatusNode> C3 = new ArrayList<StatusNode>();
			C3.add(new GraphMazeRoom2("R7"));
			connectionMap.put("R3", C3);
			
			List<StatusNode> C4 = new ArrayList<StatusNode>();
			C4.add(new GraphMazeRoom2("R3"));
			connectionMap.put("R4", C4);
			
			List<StatusNode> C5 = new ArrayList<StatusNode>();
			C5.add(new GraphMazeRoom2("R6"));
			connectionMap.put("R5", C5);
			
			List<StatusNode> C6 = new ArrayList<StatusNode>();
			C6.add(new GraphMazeRoom2("R2"));
			connectionMap.put("R6", C6);
			
			List<StatusNode> C7 = new ArrayList<StatusNode>();
			C7.add(new GraphMazeRoom2("R8"));
			C7.add(new GraphMazeRoom2("R11"));
			connectionMap.put("R7", C7);
			
			List<StatusNode> C8 = new ArrayList<StatusNode>();
			C8.add(new GraphMazeRoom2("R4"));
			C8.add(new GraphMazeRoom2("R12"));
			connectionMap.put("R8", C8);
			
			List<StatusNode> C9 = new ArrayList<StatusNode>();
			C9.add(new GraphMazeRoom2("R5"));
			C9.add(new GraphMazeRoom2("R13"));
			connectionMap.put("R9", C9);
			
			List<StatusNode> C10 = new ArrayList<StatusNode>();
			C10.add(new GraphMazeRoom2("R6"));
			C10.add(new GraphMazeRoom2("R9"));
			C10.add(new GraphMazeRoom2("R11"));
			connectionMap.put("R10", C10);
			
			List<StatusNode> C11 = new ArrayList<StatusNode>();
			C11.add(new GraphMazeRoom2("R10"));
			C11.add(new GraphMazeRoom2("R12"));
			connectionMap.put("R11", C11);
			
			List<StatusNode> C12 = new ArrayList<StatusNode>();
			C12.add(new GraphMazeRoom2("R8"));
			connectionMap.put("R12", C12);
			
			List<StatusNode> C13 = new ArrayList<StatusNode>();
			C13.add(new GraphMazeRoom2("R14"));
			connectionMap.put("R13", C13);
			
			List<StatusNode> C14 = new ArrayList<StatusNode>();
			C14.add(new GraphMazeRoom2("R15"));
			connectionMap.put("R14", C14);
			
			List<StatusNode> C15 = new ArrayList<StatusNode>();
			C15.add(new GraphMazeRoom2("R11"));
			C15.add(new GraphMazeRoom2("R16"));
			connectionMap.put("R15", C15);
			
			List<StatusNode> C16 = new ArrayList<StatusNode>();
			C16.add(new GraphMazeRoom2("R12"));
			connectionMap.put("R16", C16);
		}
	}

	/**
	 * @return the children of this node, whose parentNum is -1 and not initialised.
	 */
	@Override
	public List<StatusNode> expand() {
		return connectionMap.get(name);
	}

	public void displayNode() {
		System.out.print(name + '\t');
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof GraphMazeRoom2) {
			GraphMazeRoom2 node = (GraphMazeRoom2)obj;
			return name.equals(node.name);
		}
		else
			return false;
	}

	@Override
	public int costTo(StatusNode otherNode) throws Exception {
		if(connectionMap.get(name).contains(otherNode))
			return 1;
		else
			throw new Exception();
	}

}

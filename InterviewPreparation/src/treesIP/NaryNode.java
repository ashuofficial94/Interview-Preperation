package treesIP;

import java.util.ArrayList;
import java.util.List;

public class NaryNode {

	private int value;
	private List<NaryNode> children;
	
	NaryNode(int value) {
		this.value = value;
		children = new ArrayList<NaryNode>();
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean addChild(NaryNode child) {
		return children.add(child);
	}
	
	public List<NaryNode> getChildren() {
		return children;
	}
}

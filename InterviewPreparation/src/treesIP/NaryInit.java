package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class NaryInit {

	public NaryTree initialize() throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Root : ");
		int root_val = Integer.parseInt(br.readLine());
		
		NaryNode root = new NaryNode(root_val);
		NaryTree nary = new NaryTree(root);
		
		while(true) {
			
			String[] values = br.readLine().split(" ");			
			NaryNode parent = new NaryNode(Integer.parseInt(values[0]));
			if(parent.getValue() == 0) break;
			
			parent = nary.getNode(parent);
			
			if(parent == null) {
				System.out.println("No such node");
				continue;
			}
			
			for(int index=1; index < values.length; index++) {
				int value = Integer.parseInt(values[index]);
				if(value == 0) continue;
				parent.addChild(new NaryNode(Integer.parseInt(values[index])));
			}
			
		}
		
		return nary;
	}
	
	public void printTree(NaryTree nary) {
		
		List<NaryNode> node_list = nary.getNodeList();
		
		System.out.println("\nTree-\n");
		
		for(NaryNode node : node_list) {
			
			if(node.getChildren().size() > 0) {
				System.out.print(node.getValue() + " : ");
				
				for(NaryNode child : node.getChildren()) {
					System.out.print(child.getValue() + " ");
				}

				System.out.println();
			}
			
		}
	}
}

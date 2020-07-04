package treesIP;

//Draw the tree

public class CustomTree {

	public void customTree(NaryTree tree) {
		
		drawNode(tree.getRoot(), 0);
	}
	
	public static void drawNode(NaryNode node, int spaces) {
		
		for(int i=0; i<spaces; i++)
			System.out.print("   |");
				
		System.out.println("-->" + node.getValue());
		
		for(NaryNode child : node.getChildren()) {
			drawNode(child, spaces+1);
		}
	}
}

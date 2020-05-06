package treesIP;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
	/*
	  	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter Root : ");
		int root_val = Integer.parseInt(br.readLine());
		BinaryTree tree = new BinaryTree(new BinaryNode(root_val));
		
		InitializeTree init = new InitializeTree();
		tree = init.initializeTree(tree);
		
		System.out.println("Tree - \n");
		init.printTree(tree);
		
		LevelOrder lo = new LevelOrder();
		
		System.out.println("Level Order : ");
		for(BinaryNode node: lo.levelOrder(tree)) {
			System.out.print(node.getValue()+" ");
		}
	}
	*/
	public List<BinaryNode> levelOrder(BinaryTree tree) {
		
		Queue queue = new Queue();
		queue.enqueue(tree.getRoot());
		List<BinaryNode> levelOrder = new ArrayList<BinaryNode>();
		
		while(queue.getQueue().size() > 0) {
			
			BinaryNode node = queue.dequeue();		
			levelOrder.add(node);
			
			if(node.getLeft() != null)
				queue.enqueue(node.getLeft());
			
			if(node.getRight() != null)
				queue.enqueue(node.getRight());
		}
	
		return levelOrder;
	}

}

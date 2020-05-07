package binarysearchtreeIP;

import java.util.List;


public class InitializeTree {

	public Tree initializeTree(List<Integer> elem) {

		Tree tree = new Tree(new Node(elem.get(0)));
		
		for(int val : elem.subList(1, elem.size())) {
			tree.addNode(new Node(val));
		}
		
		return tree;
	}
	
	public void printTree(Tree tree) {
		
		System.out.println();
		for(Node node: tree.getNodes()) {
			
			if(node.getLeft() == null && node.getRight() == null)
				continue;
			
			System.out.print(node.getValue() + " : ");
			
			if(node.getLeft() != null) 
				System.out.print(node.getLeft().getValue() + " ");
			else
				System.out.print("x ");
			
			if(node.getRight() != null) 
				System.out.print(node.getRight().getValue() + " ");
			else
				System.out.print("x ");
			
			System.out.println();
		}
		return;
	}
}

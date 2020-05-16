package treesIP;

import java.util.*;

public class View {

	private Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	private BinaryTree tree;
	
	View(BinaryTree tree) {
		this.tree = tree;
	}
	
	//Top-View: Vertical Traversal with least depth BinaryNode
	
	public List<BinaryNode> topView() {
        
		List<BinaryNode> top_view = new ArrayList<BinaryNode>();
        findTop(tree.getRoot(), 0, 0);
        int min=0, max=0;
        
        for(int key: map.keySet()) {
            if(key < min) min = key;
            if(key > max) max = key;
        }
        
        for(int target=min; target<=max; target++) 
        	top_view.add(tree.getNode(new BinaryNode(map.get(target).get(0))));
        
        return top_view;
    }

    public void findTop(BinaryNode root, int distance, int level) {

        if(root != null) {
            
            if(map.containsKey(distance)) {

                if(map.get(distance).get(1) > level) {
                    map.get(distance).add(0, root.getValue());
                    map.get(distance).remove(1);
                    map.get(distance).add(1, level);
                    map.get(distance).remove(2);
                }
            }
            
            else {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(root.getValue());
                pair.add(level);
                map.put(distance, pair);
            }
                
            findTop(root.getLeft(), distance-1, level+1);
            findTop(root.getRight(), distance+1, level+1);
        }
    }

    //Left-View : Level order traversal with least horizontal distance
    
    public List<BinaryNode> leftView() {
		
    	map = new HashMap<Integer, List<Integer>>();
		List<BinaryNode> left_view = new ArrayList<BinaryNode>();
		findLeft(tree.getRoot(), 0, 0);
		int max=0;
		
		for(int key: map.keySet())
			if(max < key) max = key;
		
		for(int i=0; i<=max; i++)
			left_view.add(tree.getNode(new BinaryNode(map.get(i).get(0))));
		
		return left_view;
	}
	
	public void findLeft(BinaryNode node, int distance, int level) {
		
		if(node != null) {
			
			if(map.containsKey(level)) {
				if((int)map.get(level).get(1) > distance) {
					
					map.get(level).add(0, node.getValue());
					map.get(level).remove(1);
					map.get(level).add(1, distance);
					map.get(level).remove(2);
				}
			}
			
			else {
				
				List<Integer> pair = new ArrayList<Integer>();
				pair.add(node.getValue());
				pair.add(distance);
				map.put(level, pair);
			}
			
			findLeft(node.getLeft(), distance-1, level+1);
			findLeft(node.getRight(), distance+1, level+1);
		}
	}
	
	//Right-View : Level order traversal with most horizontal distance
	
	public List<BinaryNode> rightView() {
		
		map = new HashMap<Integer, List<Integer>>();
		List<BinaryNode> right_view = new ArrayList<BinaryNode>();
		findRight(tree.getRoot(), 0, 0);
		int max=0;
		
		for(int key: map.keySet())
			if(max < key) max = key;
		
		
		for(int i=0; i<=max; i++)
			right_view.add(tree.getNode(new BinaryNode(map.get(i).get(0))));
		
		return right_view;
	}
	
	public void findRight(BinaryNode node, int distance, int level) {
		
		if(node != null) {
			
			if(map.containsKey(level)) {
				if((int)map.get(level).get(1) <= distance) {
					
					map.get(level).add(0, node.getValue());
					map.get(level).remove(1);
					map.get(level).add(1, distance);
					map.get(level).remove(2);
				}
			}
			
			else {
				
				List<Integer> pair = new ArrayList<Integer>();
				pair.add(node.getValue());
				pair.add(distance);
				map.put(level, pair);
			}
			
			findRight(node.getLeft(), distance-1, level+1);
			findRight(node.getRight(), distance+1, level+1);
		}
	}
	
    //Bottom-View: Vertical Traversal with maximum depth BinaryNode
	
	public List<BinaryNode> bottomView() {
        
		map = new HashMap<Integer, List<Integer>>();
		List<BinaryNode> bottom_view = new ArrayList<BinaryNode>();
        findBottom(tree.getRoot(), 0, 0);
        int min=0, max=0;
        
        for(int key: map.keySet()) {
            if(key < min) min = key;
            if(key > max) max = key;
        }
        
        for(int target=min; target<=max; target++)
            bottom_view.add(tree.getNode(new BinaryNode(map.get(target).get(0))));
        
        return bottom_view;
    }

    public void findBottom(BinaryNode root, int distance, int level) {

        if(root != null) {
            
            if(map.containsKey(distance)) {

                if(map.get(distance).get(1) <= level) {
                    map.get(distance).add(0, root.getValue());
                    map.get(distance).remove(1);
                    map.get(distance).add(1, level);
                    map.get(distance).remove(2);
                }
            }
            
            else {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(root.getValue());
                pair.add(level);
                map.put(distance, pair);
            }

            findBottom(root.getLeft(), distance-1, level+1);
            findBottom(root.getRight(), distance+1, level+1);
        }
    }

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

		View view = new View(tree);
		
		List<BinaryNode> top_view = view.topView();
		List<BinaryNode> bottom_view = view.bottomView();
		List<BinaryNode> left_view = view.leftView();
		List<BinaryNode> right_view = view.rightView();
		
		System.out.print("Top View: ");
		printList(top_view);
		
		System.out.print("Bottom View: ");
		printList(bottom_view);
		
		System.out.print("Left View: ");
		printList(left_view);
		
		System.out.print("Right View: ");
		printList(right_view);
	}
		
	public static void printList(List<BinaryNode> list) {
		
		for(BinaryNode node: list) 
			System.out.print(node.getValue()+" ");
		
		System.out.println();
	}*/
}

package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter postorder : ");
		
		String[] input = br.readLine().trim().split(" ");
		List<Integer> postorder = new ArrayList<Integer>();
		
		for(String val: input) {
			postorder.add(Integer.parseInt(val));
		}
		
		System.out.print("Enter indorder : ");
		
		input = br.readLine().trim().split(" ");
		List<Integer> inorder = new ArrayList<Integer>();
		
		for(String val: input) {
			inorder.add(Integer.parseInt(val));
		}
		
		ConstructPostIn cons = new ConstructPostIn();
		BinaryTree tree = cons.constructPostIn(postorder, inorder);
		
		System.out.println("Tree - ");
		InitializeTree init = new InitializeTree();
		init.printTree(tree);
	}
}

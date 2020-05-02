package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int parent=0;
		List<Integer> children;
		
		System.out.println("Enter -1 as parent or child to exit");
		
		while(true) {
			
			boolean end = false;
			System.out.println("Parent : ");
			parent = Integer.parseInt(br.readLine().trim());
			
			if(parent == -1)
				end = true;
			
			System.out.println("Children : ");
			String[] nodes = br.readLine().trim().split(" ");
			children = new ArrayList<Integer>();
			
			for(String child: nodes) {
				
				children.add(Integer.parseInt(child));
				
				if(children.get(children.size()-1) == -1) {
					end = true;
					break;
				}
			}
			
			if(end)
				break;
			
			
		}
	}
}

package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.Integer;
public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MinElement me = new MinElement();
		
		while(true) {
			String[] buffer = br.readLine().split(" ");
			List<Integer> input = new ArrayList<Integer>();
			for(String str : buffer) input.add(Integer.parseInt(str));
			
			switch(input.remove(0)) {
			
			case 1:
				for(Integer elem : input) {
					me.push(elem);
					System.out.println("Pushed : " + elem);
				}
				break;
				
			case 2:
				int pops = input.size() == 0 ? 1 : input.get(0);
				for(int i=0; i<pops; i++) {
					System.out.println("Popped");
					me.pop();
				}
				break;
				
			case 3:
				System.out.println("Current Min in Stack : " + (me.curr_min));
				break;
				
			case 4:
				System.out.println(me.stack.getStack());
				
			default:
				System.out.println("Enter 1 for push; 2 for pop and 3 to get min");
			}
		}
	}
}

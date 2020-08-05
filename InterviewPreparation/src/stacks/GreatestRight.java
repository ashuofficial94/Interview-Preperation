package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Given an array, find the closest greater element to the right of it 
//I/P - 10, 20, 1,  5, 25, 70, 60
//O/P - 20, 25, 5, 25, 70, -Inf, -Inf 

public class GreatestRight {
	
	public void greatestRight(List<Integer> elements) {

		Stack<Integer> stack = new Stack<Integer>();
//		int[] greater = new int[elements.size()];
		List<Integer> greater = new ArrayList<Integer>();
		for(int elem : elements) greater.add(Integer.MIN_VALUE);
		
		stack.push(0);
		
		for(int index=1; index<elements.size(); index++) {
			while(!stack.isEmpty() && elements.get(stack.getTop()) < elements.get(index)) {
				greater.add(stack.getTop(), elements.get(index));
				greater.remove(stack.pop()+1);
			}
			stack.push(index);
		}

		System.out.println(greater);
	}
}

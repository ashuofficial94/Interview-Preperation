package arrays;

import java.util.List;

public class SumToZero {

	private List<Integer> input;
	
	SumToZero(List<Integer> input) {
		this.input = input;
	}
	
	public int[] bruteForceSolution() {
		
		int[] pair = new int[2];
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i<input.size(); i++) {
			for(int j = i+1; j<input.size(); j++) {
				
				if(Math.abs(input.get(i) + input.get(j)) < min) {
					
					min = Math.abs(input.get(i) + input.get(j));
					pair[0] = input.get(i);
					pair[1] = input.get(j);
				}
			}
		}
		
		System.out.println(min);
		return pair;
	}
}

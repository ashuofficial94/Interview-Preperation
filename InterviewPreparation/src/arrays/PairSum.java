package arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairSum {

	private List<Integer> input;
	Map<Integer, Integer> pairs;
	
	PairSum(List<Integer> input) {
		this.input = input;
	}
	
	public boolean sumFound(int sum) {
		
		Collections.sort(input);
		int left = 0, right = input.size()-1;
		pairs = new HashMap<Integer, Integer>();
		
		while(left<right) {
			
			if(input.get(left) + input.get(right) == sum) {
				pairs.put(input.get(left), input.get(right));
				return true;
			}
			
			else if(input.get(left) + input.get(right) < sum)
				left++;
			
			else
				right--;
		}
		
		return false;
		
	}
	
	public void hashPairSum(int sum) {
		
		pairs = new HashMap<Integer, Integer>();
		int max = Integer.MIN_VALUE;
		
		for(int num: input) {
			if(max < num) {
				max = num;
			}
		}
		
		boolean[] hash = new boolean[max+1];
		
		for(int i=0; i<input.size(); i++) {
			
			int temp = sum - input.get(i);
			
			if(temp >= 0 && hash[temp]) {			
				pairs.put(input.get(i), temp);
			}
			
			hash[input.get(i)] = true;
				
		}
		
		return;
	}
	
	public void nSquarePairSum(int sum) {
		
		pairs = new HashMap<Integer, Integer>();
		
		for(int i=0; i<input.size(); i++) {
			
			if(input.get(i)<=sum) {
				
				for(int j=i+1; j<input.size(); j++) {
					
					if(i!=j && input.get(j)+input.get(i) == sum) {
						pairs.put(input.get(i), input.get(j));
					}
				}
			}
		}
		
		return;
	}
}

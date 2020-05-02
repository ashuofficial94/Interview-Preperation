package dynamic;

import java.util.ArrayList;
import java.util.List;

public class MaxSubArr {

	private List<Integer> input;
	public int start;
	public int end;
	
	MaxSubArr(List<Integer> input) {
		this.input = input;
	}
	
	//Kadane's algorithm - Dynamic Solution
	//Exception: Atleast one element has to be positive for this algorithm to work
	
	public int maxSubArray() {
		
		int max_till_here = 0;
		int max_ryt_now = 0;
		int s = 0;
		
		for(int i=0; i<input.size(); i++) {
			
			max_ryt_now += input.get(i);
			if(max_till_here < max_ryt_now) {
				
				max_till_here = max_ryt_now;
				start = s;
				end = i;
			}
			
			if(max_ryt_now < 0) {
				
				max_ryt_now = 0;
				s = i+1;
			}
		}
		
		return max_till_here;
	}
	
	//Not entirely right as the sub-arrays from index 0 are not getting considered
	public int nSquareMaxSubArray() {
		
		List<Integer> cum_sum = new ArrayList<Integer>();
		cum_sum.add(input.get(0));
		
		for(int i=1; i<input.size(); i++) {
			cum_sum.add(cum_sum.get(i-1) + input.get(i));
		}
		
		for(int elem: cum_sum) {
			System.out.print(elem + " ");
		}
		
		System.out.println();
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<cum_sum.size(); i++) {
			for(int j=i; j<cum_sum.size(); j++) {
				
				if(max < cum_sum.get(j) - cum_sum.get(i)) {
					
					max = cum_sum.get(j) - cum_sum.get(i);
					start = i+1;
					end = j;
				}
			}
				
		}
		
		return max;
	}
}

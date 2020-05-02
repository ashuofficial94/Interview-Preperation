package arrays;

import java.util.ArrayList;
import java.util.List;

//Find maximum difference between element in such a way that 
//larger element appears after the smaller element

public class MaxDifference {
	
	private List<Integer> input;
	
	MaxDifference(List<Integer> input) {
		this.input = input;
	}

	//Dynamic Programming Solution
	//Main Logic - The max difference will be the greatest sum of sub-array from the difference array 
	//i.e. if difference[] = <a[1]-a[0], a[2]-a[1],..., a[i+1]-a[i],..., a[n]-a[n-1]>
	//Sum of the sub-array will be suppose (a[2]-a[1]) + (a[3]-a[2]) + (a[4]-a[3]) = a[4]-a[1] 
	
	public int dynamicSolution() {
		
		List<Integer> diff = new ArrayList<Integer>();
		
		for(int i=0; i<input.size()-1; i++)
			diff.add(input.get(i+1) - input.get(i));
		
		//finding the max sum sub-array of the difference array - Kadane's Algorithm 
		
		int max_diff = 0;
		int curr_diff = 0;
		int s=0, start=0, end=0;
		
		for(int i=1; i<diff.size(); i++) {
			
			curr_diff += diff.get(i);
			
			if(max_diff < curr_diff) {		
				max_diff = curr_diff;
				start = s;
				end = i;
			}
			
			if(curr_diff < 0) {
				s = i+1;
			}
			
		}
		
		System.out.print(input.get(end+1)+" - "+input.get(start+1)+" = ");		
		return max_diff;
	}
	
	public void printList(List<Integer> list) {
		
		for(int x: list)
			System.out.print(x + " ");
		
		System.out.println();
	}
	
	public int bruteForceSolution() {
		
		int max = Integer.MIN_VALUE;
		int keyi = 0, keyj = 0;
		
		for(int i=0; i<input.size(); i++) {
			for(int j=i+1; j<input.size(); j++) {
				
				if(input.get(j) - input.get(i) >= max) {
					keyi = i;
					keyj = j;
					max = input.get(j) - input.get(i);
				}
			}
		}
		
		System.out.print(input.get(keyj) + " - " + input.get(keyi) + " = ");
		
		return max;
	}

	//for b-a to be max, a has to be minimum
	//another solution can be - keep track of minimum element behind the current one
	//take the max difference after reaching the end
	
	public int minMaxDifference() {
		
		int min = Integer.MAX_VALUE;
		int l_key = 0, r_key = 0, min_key=0;
		int max_diff = Integer.MIN_VALUE;
		
		for(int i=1; i<input.size(); i++) {
			
			if(min > input.get(i-1)) {
				min = input.get(i-1);
				min_key = i-1;
			}
			
			if(max_diff < input.get(i) - min) {
				max_diff = input.get(i) - min;
				r_key = i;
				l_key = min_key;
			}
		}
		
		System.out.print(input.get(r_key) + " - " + input.get(l_key) + " = ");
		
		return max_diff;
	}
}

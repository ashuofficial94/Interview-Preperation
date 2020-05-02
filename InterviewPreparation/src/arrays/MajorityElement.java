package arrays;

import java.util.List;

public class MajorityElement {
	
	private List<Integer> input;
	
	MajorityElement(List<Integer> input) {
		this.input = input;
	}
	
	public int mooresVoting() {
		
		int votes = 1;
		int voter = input.get(0);
		System.out.print(votes + " ");
		
		for(int i=1; i<input.size(); i++) {
			
			System.out.print(votes + " ");
			
			if(input.get(i) == voter)
				votes++;
			
			else
				votes--;
			
			if(votes < 0) {
				voter = input.get(i);
				votes = 1;
			}
		}
		
		if(isMajority(voter))
			return voter;
		
		return Integer.MIN_VALUE;
	}
	
	public boolean isMajority(int voter) {
		
		int count = 0;
		
		for(int x: input)
			if(x==voter)
				count++;

		return count > input.size()/2;
	}
}

package arrays;

import java.util.ArrayList;
import java.util.List;

public class OddFrequency {

	private List<Integer> input;
	
	OddFrequency(List<Integer> input) {
		this.input = input;
	}
	
	@SuppressWarnings("deprecation")
	public List<Integer> oddFreq() {
		
		List<Integer> odd = new ArrayList<Integer>();
		
		for(int i=0; i<input.size(); i++) {
			
			if(!odd.contains(input.get(i)))
				odd.add(input.get(i));
			
			else
				odd.remove(new Integer(input.get(i)));
		}
		
		return odd;
	}
	
	//Using XOR operator
	//if you xor all the numbers and only one number has odd occurences then only that number will remain
	//A ^ B ^ A ^ C ^ C = B (^ stands for XOR)
	
	public int oddFreqXOR() {
		
		int result = 0;
		
		for(int elem: input)
			result = result ^ elem;
		
		return result;
	}
}

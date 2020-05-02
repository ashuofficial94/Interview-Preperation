package backtracking;

import java.util.ArrayList;
import java.util.List;

public class BitSequence {
	
	//BackTracking Solution
	
	public List<String> bit_seq = new ArrayList<String>();
	
	public void bitSequence(String bit, int num) {
		
		if(bit.length() == num) {
//			if(!bit_seq.contains(bit))
				bit_seq.add(bit);
			return;
		}
		
		bit = bit + "0";
		bitSequence(bit, num);
		bit = bit.substring(0, bit.length()-1) + "1";
		bitSequence(bit, num);

	}
	
	//My solution
	/*
	public String[] bitSequence(int num) {

		String[] bit_seq = new String[(int)Math.pow(2,  num)];
		for(int i=0; i<Math.pow(2, num); i++) {
			bit_seq[i] = "";
			int n = i;
			while(n!=0) {
				bit_seq[i] = n%2 + bit_seq[i];
				n = n/2;
			}
			
			for(int j=bit_seq[i].length(); j<num; j++) {
				bit_seq[i] = "0" + bit_seq[i];
			}
		}
		
		return bit_seq;
	}
	*/
	
}

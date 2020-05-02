package arrays;

import java.util.Collections;
import java.util.List;

public class BinarySearch {

	private List<Integer> input;
	boolean found = false;
	
	BinarySearch(List<Integer> input) {
		
		this.input = input;
		Collections.sort(this.input);
	}
	
	public void bSearch(int key, int start, int end) {
		
		int mid = (start + end) / 2;
		
		if(start <= end) {
			if(key == input.get(mid)) {
				found = true;
				return;
			}
			else if(key > input.get(mid)) {
				bSearch(key, mid+1, end);
			}
			else {
				bSearch(key, start, mid-1);
			}
		}
		return;
	}
}

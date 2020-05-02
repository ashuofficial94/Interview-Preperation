package arrays;

import java.util.List;

public class Seperate01 {

	private List<Integer> input;
	
	Seperate01(List<Integer> input) {
		this.input = input;
	}
	
	//same logic can be used to seperate odd and even numbers
	
	public List<Integer> seperate01() {
		
		int l_index = 0, r_index = input.size()-1;
		
		while(l_index < r_index) {

			if(input.get(l_index) == 1 && input.get(r_index) == 0) {
				swapListElem(l_index, r_index);
				l_index++;
				r_index--;
			}
			
			else if(input.get(l_index) == 0)
				l_index++;
			
			else if(input.get(r_index) == 1)
				r_index--;
		}
		
		return input;
	}
	
	public void swapListElem(int l_index, int r_index) {

		input.add(l_index, input.get(r_index));
		input.add(r_index + 1, input.get(l_index + 1));
		input.remove(l_index + 1);
		input.remove(r_index + 1);
		return;
		
	}
}

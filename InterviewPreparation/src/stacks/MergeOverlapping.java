package stacks;

import java.util.Comparator;
import java.util.List;

//Merge the overlapping intervals. Ex (1, 4) (3, 5) = (1, 5)

class Compare implements Comparator<List<Integer>> {
	public int compare(List<Integer> a, List<Integer> b) {
		return a.get(0) - b.get(0);
	}
}

public class MergeOverlapping {
	
	/*
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<List<Integer>> pairs = new ArrayList<List<Integer>>();
		
		for(int i=0; i<n; i++) {
			String[] buffer = br.readLine().split(" ");
			List<Integer> pair = new ArrayList<Integer>();
			pair.add(Integer.parseInt(buffer[0]));
			pair.add(Integer.parseInt(buffer[1]));
			pairs.add(pair);
		}
		
		MergeOverlapping merge = new MergeOverlapping();
		merge.mergeOverlapping(pairs);
	}
	*/
	
	public List<List<Integer>> mergeOverlapping(List<List<Integer>> pairs) {
		
		pairs.sort(new Compare());
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		stack.push(pairs.get(0));
		
		for(int index = 1; index < pairs.size(); index++) {
			List<Integer> top_pair = stack.getTop();
			List<Integer> cur_pair = pairs.get(index);
			
			if(top_pair.get(1) >= cur_pair.get(0)) {
				top_pair.remove(1);
				top_pair.add(cur_pair.get(1));
			}
			
			else stack.push(cur_pair);
		}
		
		System.out.println(stack.getStack());
		return pairs;
	}
}

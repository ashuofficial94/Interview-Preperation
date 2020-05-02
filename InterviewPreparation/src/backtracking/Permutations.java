package backtracking;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	static List<String> perm = new ArrayList<String>();
	
	/*
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		permutations(input, 0, input.length()-1);
		
		for(String x: perm) {
			System.out.println(x);
		}
		
	}
	*/
	
	//Backtracking solution : 
	
	static void permutations(String input, int start, int end) {

		if(start == end) {
			perm.add(input);
			return;
		}
		
		for(int i=start; i<=end; i++) {
			
			StringBuilder str = new StringBuilder(input);
		
			str.insert(i, str.charAt(0));
			str.insert(0, str.charAt(i+1));
			str.deleteCharAt(1);
			str.deleteCharAt(i+1);
			input = str.toString();
			
			permutations(input, start+1, end);
			
			//restoring the position of charactersbecause of backtracking
			
			str = new StringBuilder(input);
			
			str.insert(i, str.charAt(0));
			str.insert(0, str.charAt(i+1));
			str.deleteCharAt(1);
			str.deleteCharAt(i+1);
			input = str.toString();
			
		}
	}
}

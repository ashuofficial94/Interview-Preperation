package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] buffer = br.readLine().split(" ");
		List<Integer> input = new ArrayList<Integer>();
//		int sum = Integer.parseInt(br.readLine());
		
		for(String x: buffer) {
			input.add(Integer.parseInt(x));
		}

		SumToZero obj = new SumToZero(input);
		
		int[] pair = obj.bruteForceSolution();
		
		System.out.println(pair[0] + " " + pair[1]);
		
	}
}

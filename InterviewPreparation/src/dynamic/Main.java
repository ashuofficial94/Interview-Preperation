package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] buffer = br.readLine().split(" ");
		
		List<Integer> input = new ArrayList<Integer>();
		
		for(String str: buffer) {
			input.add(Integer.parseInt(str));
		}
		
		MaxSubArr obj = new MaxSubArr(input);
		System.out.println(obj.maxSubArray() + " " + obj.start + " " + obj.end);
		System.out.print("SubArray : ");
		
		for(int i=obj.start; i<obj.end+1; i++) {
			System.out.print(input.get(i) + " ");
		}
	}
}

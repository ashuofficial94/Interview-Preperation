package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Integer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String brackets = br.readLine();
		
		BracketReversal obj = new BracketReversal();
		System.out.println(obj.bracketReversal(brackets));
		
		
	}
}

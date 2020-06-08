package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String arge[]) throws IOException{
		
		NaryInit init = new NaryInit();
		NaryTree nary = init.initialize();
		init.printTree(nary);
		
		NarySerialization obj = new NarySerialization();
		List<Integer> serial = obj.narySerialization(nary);
		
		System.out.println();
		for(int node : serial) {
			System.out.print(node + " ");
		}
		
		NaryTree deserialized = obj.naryDeserialization(serial);
		System.out.println();
		init.printTree(deserialized);
		
	}
}

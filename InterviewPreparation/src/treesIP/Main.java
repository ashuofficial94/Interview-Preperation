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
		System.out.println();
		
		CustomTree cust = new CustomTree();
		cust.customTree(nary);
	}
}

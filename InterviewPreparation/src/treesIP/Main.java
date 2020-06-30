package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String arge[]) throws IOException{
		
		NaryInit init = new NaryInit();
		NaryTree tree = init.initialize();
		init.printTree(tree);
		
		LockUnlock lu = new LockUnlock();
		lu.lockUnclock(tree);
		
	}
}

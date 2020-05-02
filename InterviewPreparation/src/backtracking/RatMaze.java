package backtracking;

import java.util.Arrays;
import java.util.List;

public class RatMaze {

	private List<List<Integer>> cells;
	private List<List<Integer>> obstacles;
	private char[][] path;
	private int size=0;
	
	RatMaze(int size) {
		this.size = size;
		path = new char[size][size];
		for(int i=0; i<size; i++)
			Arrays.fill(path[i], '.');
	}
	
	/*public boolean ratMaze(int[][] maze, int row, int col) {
		
		if(col == size-1 && row == size-1)
			return true;
		
		else {
			
		}
	}*/
}

package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] buffer = br.readLine().split(" ");
		List<Integer> prices = new ArrayList<Integer>();
		
		for(String price : buffer) prices.add(Integer.parseInt(price));
		StockSpan stock = new StockSpan();
		stock.stockSpan(prices);
	}
}

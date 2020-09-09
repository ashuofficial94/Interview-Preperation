package stacks;

import java.util.ArrayList;
import java.util.List;

/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {0, 0, 0, 1, 0, 3, 5}
 */

public class StockSpan {

	/*
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] buffer = br.readLine().split(" ");
		List<Integer> prices = new ArrayList<Integer>();
		
		for(String price : buffer) prices.add(Integer.parseInt(price));
		StockSpan stock = new StockSpan();
		stock.stockSpan(prices);
	}
	*/
	
	public List<Integer> stockSpan(List<Integer> prices) {
		
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> span = new ArrayList<Integer>();
		
		//MAX_VALUE will not let the stack get empty saving all the indices
		//If the stack gets empty -- span = index of the element
		
		prices.add(0, Integer.MAX_VALUE);
		stack.push(0);
		
		for(int index = 1; index < prices.size(); index++) {
			while(prices.get(stack.getTop()) <= prices.get(index))
				stack.pop();
			
			span.add(index - stack.getTop() - 1);
			stack.push(index);
		}
		
		System.out.println(span);
		return span;
 	}
}

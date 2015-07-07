package math;

import java.util.Scanner;
/**
 * http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock-ii/
 * Since this problem allows you to do as many transactions as possible,
 * you can always buy at a valley and sell at its next peak.
 * Sum_Profit = profit_1 + profit_2 + ...
 */
public class BSStockII {
	
	/**
	 * Method: if the price - the previous price is positive, 
	 * we add this difference to the profit.
	 * In another word, find all upward intervals 
	 * and add their price difference up.
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			int diff = prices[i + 1] - prices[i];
			if (diff > 0) {
				profit += diff;
			}
		}
		return profit;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Buy and Sell Stock II Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n" +
				"leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		int profit = maxProfit(testArray);
		System.out.println("The max profit derived from the price array is " + profit);
	}
}

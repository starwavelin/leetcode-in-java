package math;

import java.util.Scanner;

/**
 * http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock/
 * Only allow at most one transaction, calculate the maximum profit 
 * ([high price - low price] in a given interval)
 * 
 * Profit calculation: Purchase at valley and sell at peak.
 *
 */
public class BSStockI {
	
	public static int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		int profit = 0;
		for (int i : prices) {
			min = (i < min) ? i : min;
			profit = (i - min) > profit ? (i - min) : profit;
		}
		return profit;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Buy and Sell Stock I Test ***");
		
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

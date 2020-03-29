package array;

public class BuySellStock1 {
	public static class Solution {
		public int maxProfit(int[] prices) {
	        if (prices.length == 0)
	            return 0;
	        int min = Integer.MAX_VALUE;
	        int profit = 0;
	        for (int i = 0; i < prices.length; i++) {
	            if (prices[i] < min)
	                min = prices[i];
	            if (prices[i] - min > profit)
	                profit = prices[i] - min;
	        }
	        return profit;
	    }
	}
}

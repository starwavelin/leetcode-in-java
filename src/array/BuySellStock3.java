package array;

public class BuySellStock3 {
	
	public static class Solution {
		public int maxProfit(int[] prices) {
	        if (prices.length < 2) {
	            return 0;
	        }
	        int profit = 0;
	        int n = prices.length; 
	        int[] leftMax = new int[n];
	        int[] rightMax = new int[n];
	        
	        int min = prices[0];
	        for (int i = 1; i < n; i++) {
	            if (prices[i] < min) {
	                min = prices[i];
	            }
	            leftMax[i] = Math.max(leftMax[i-1], prices[i] - min);
	        }
	        
	        int max = prices[n-1];
	        for (int i = n-2; i >= 0; i--) {
	            if (prices[i] > max) {
	                max = prices[i];
	            }
	            rightMax[i] = Math.max(rightMax[i+1], max - prices[i]);
	        }
	        
	        for (int i = 0; i < n; i++) {
	            profit = Math.max(profit, leftMax[i] + rightMax[i]);
	        }
	        return profit;
	    }
	}
}

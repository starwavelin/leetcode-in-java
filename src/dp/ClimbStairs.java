package dp;

/***************************************************************************
* Problem No. : 70
* Problem Name: Climb Stairs
* Problem URL : https://leetcode.com/problems/climbing-stairs/description/
* Date        : Jan 2 2018
* Author	      : @codingbro
* Notes       : 
* 	Scenario: 
* 		A little different from the original question:
* 		Each time you can either climb 1 or 2 or 3 steps. In how many distinct ways can you climb to the top?
* 	Assumption:
* 		1. 
	Example:
* 	Input: 
* 	Output: 
* 		
* 	Data Structure and Alg:
* 		See Code Comments  
* Complexity  : 
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
* 
* meta        : tag-dp
***************************************************************************/

public class ClimbStairs {
	/*
	 * index:		0	1	2	3	4  5
	 * num of ways: 1   1   2   4   7  13
	 * */
	
	/** Recursion */
	public static class Sol1 {
		public int climbStairs(int n) {
			if (n == 0 || n == 1) {
				return 1;
			}
			if (n == 2) {
				return 2;
			}
			return climbStairs(n - 1) + climbStairs(n - 2) + climbStairs(n - 3); 
		}
	}
	
	/** DP 
	 * Function definition: let dp[n] store the number of ways to reach Step n
	 * Transitive Eq: dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3]
	 * Initialization: dp[0] = dp[1] = 1; dp[2] = 2;
	 * Final Result: return dp[n]
	 * */
	public static class Sol2 {
		public int climbStairs(int n) {
			if (n == 0 || n == 1) {
				return 1;
			}
			if (n == 2) {
				return 2;
			}
			int[] dp = new int[n + 1];
			dp[0] = dp[1] = 1;
			dp[2] = 2;
			for (int i = 3; i < n + 1; i++) {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}
			return dp[n];
		}
	}
	
	/**
	 * Problem No. 747 "Min Cost Climbing Stairs"
	 * Again you can do one step or two steps at a time, 
	 * but a little different from the previous question, you can choose to start from Step 0 or Step 1
	 * 	(cuz they may have different costs and you need to find the best choice)
	 * In this question, the cost.length is the n in the previous question
	 * 
	 * ie 1. cost[] = {10, 15, 20} so n = 3 we want to get to Step 3 
	 * 
	 * ie 2. Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] n = 10 we wanna get to Step 10
		Output: 6
		Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
			which is cost[0] cost[2] cost[4] cost[6] cost[7] cost[9]
			and sum of them is 6
			
	 *	Assumption: cost[]'s length is in range [2, 1000]
			cost[i] is in range [0, 999]
	 */
	public static class MinCost {
		/**
		 * Idea: DP
		 * 	Actually similar to the prev ClimbStairs problem, but 
		 * 	dp[n] has a different meaning here
		 * DP 4 steps
		 * Function definition: let dp[n] store the total cost of reaching n
		 * Transition equation: dp[n] = min(dp[n-1] + curCost, dp[n-2] + curCost)
		 * 		Note: for Step n, curCost is 0!!
		 * Initialization:
		 * 		dp[0] = cost[0]; dp[1] = cost[1]
		 * Final Result:l
		 * 		return dp[n]
		 */
		public int minCostClimbStairs(int[] cost) {
			int n = cost.length; 
			int[] dp = new int[n + 1];
			dp[0] = cost[0];
			dp[1] = cost[1];
			for (int i = 2; i < n + 1; i++) {
				int curCost = (i == n) ? 0 : cost[i];
				dp[i] = Math.min(dp[i - 1] + curCost, dp[i - 2] + curCost);
			}
			return dp[n];
		}
	}
	
	public static void main(String[] args) {
		Sol1 s1 = new Sol1();
		Sol2 s2 = new Sol2();
		System.out.println("How many ways to climb 5 steps? " + s1.climbStairs(5));// should return 13;
		System.out.println("How many ways to climb 5 steps? " + s2.climbStairs(5));// should return 13;
		
		MinCost mc = new MinCost();
		int[] cost1 = new int[]{10, 15, 20};
		int[] cost2 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println("Cost 1: The minumum cost to climb to Step " + cost1.length 
				+ " is: " + mc.minCostClimbStairs(cost1)); // should return 15
		System.out.println("Cost 2: The minumum cost to climb to Step " + cost2.length 
				+ " is: " + mc.minCostClimbStairs(cost2)); // should return 6
	}
}

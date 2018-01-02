package dp;

/***************************************************************************
* Problem No. : 70
* Problem Name: Climb Stairs
* Problem URL : https://leetcode.com/problems/climbing-stairs/description/
* Date        : Jan 2 2018
* Author	      : Xian Lin
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
	
	/**
	 * Recursion
	 */
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
	
	/**
	 * DP
	 */
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
	
	public static void main(String[] args) {
		Sol1 s1 = new Sol1();
		Sol2 s2 = new Sol2();
		System.out.println("How many ways to climb 5 steps? " + s1.climbStairs(5));// should return 13;
		System.out.println("How many ways to climb 5 steps? " + s2.climbStairs(5));// should return 13;
	}
}

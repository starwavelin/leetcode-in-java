package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import utility.ListUtil;

/***************************************************************************
* Problem No. : 204
* Problem Name: Count Primes
* Problem URL : https://leetcode.com/problems/count-primes/description/
* Date        : Oct 20 2017
* Author      :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		#1 The original question just requires me to count the number of prime numbers from 1 to n. n >= 2
* 		#2 Here I also add one more requirement, print these prime numbers out.
* 	Assumption:
* 		1. The numbers from 1 to n are positive integers already naturally ordered
* 		2. n is always greater than or equal to 2
	Example:
* 	Input/Output:
* 		略
* 	Data Structure and Alg:
* 		See solutions in the code comments
* Complexity  : 
* 	Time Complexity: See solutions in the code comments
* 	Space Complexity: See solutions in the code comments   
* 
* meta        : tag-math, tag-two-pointers, tag-array-map
***************************************************************************/
public class PrimeNumbers {

	/* For easier handling the 2 requirements, I created this helper class */
	static class Result {
		List<Integer> primeNumbers;
		int count;
		public Result(List<Integer> primeNums, int count) {
			this.primeNumbers = primeNums;
			this.count = count;
		}
	}
	
	/**
	 * Solution 1:  Reverse thinking - eliminating composite numbers | 逆向思维-消除合数法
	 * 	Idea: Traverse the array of integers from 2 to n, if a number is a prime number, add it to the prime number list and increment the count.
	 * If a number is a composite number, don't add it to the prime number list and do not increment the count. 
	 * This idea sounds like 废话, core part:
	 * 	how to determine if a number is a composite number within 1 to n? And then eliminate it?
	 * Sol: Use an integer array of size n+1 so 1 maps to index 1 and n maps to index n. 
	 *  Initialize all cells to 1 so assume at the very beginning every number is prime.
	 *  Use two pointers. i - slow pointer , j - faster pointer.
	 *  Traverse from integer 2, (i points to 2 at the beginning) 
	 *  	if the value of index i in the array map is 1, it is a prime number, do whatever you need to do with it.
	 *  	and for each (i * j) < n, mark map[i*j] = 0 (not a prime number).
	 * 
	 * Time Complexity: < O(n^2) cuz the inner loop you are using multiplication to traverse the array
	 * Space Complexity: O(n) cuz open a new array of size n+1
	 */
	public static Result getPrimeNumbers1(int n) {
		int[] nums = new int[n + 1];
		List<Integer> primeNums = new ArrayList<>();
		int count = 0;
		Arrays.fill(nums, 1);
		for (int i = 2; i <= n; i++) {
			if (nums[i] == 1) {
				primeNums.add(i);
				count++;
			}
			for (int j = i; j * i <= n; j++) {
				nums[j * i] = 0;
			}
		}
		return new Result(primeNums, count);
	}
	
	
	public static void main(String[] args) {
		int n = 100;
		System.out.println(String.format("For n = %d", n));
		System.out.print(String.format("There are %d prime numbers.", getPrimeNumbers1(n).count));
		System.out.print(" And they are: " );
		ListUtil.display(getPrimeNumbers1(n).primeNumbers);
		
		
	}
}

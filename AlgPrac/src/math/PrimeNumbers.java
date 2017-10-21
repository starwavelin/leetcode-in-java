package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
	
	/**
	 * Solution 2:
	 *  Optimized from Solution 1, we know 2 is a prime number and we then know all other even numbers cannot be prime anymore. 
	 *  So when traverse the outer loop, i += 2.
	 * Time and Space complexity are the same as Solution 1 but the actual running time is < Solution 1's.
	 * 
	 * Note: this solution runs 50-100 ms on LeetCode
	 */
	public static Result getPrimeNumbers2(int n) {
		int[] nums = new int[n + 1];
		List<Integer> primeNums = new ArrayList<>();
		primeNums.add(2);
		int count = 1;
		Arrays.fill(nums, 1);
		for (int i = 3; i <= n; i += 2) {
			if (nums[i] == 1) {
				primeNums.add(i);
				count++;
			}
			for (int j = i; j * i <= n; j += 2) {
				nums[j * i] = 0;
			}
		}
		return new Result(primeNums, count);
	}
	
	/**
	 * Solution 3: 
	 * 	For solution 1 and 2, we use i as the base pointer, and j scans from i all the way to n. 
	 * 		The core goal of doing so is eliminating composite numbers.
	 *  	But the checking condition is j * i <= n.
	 *  Then how about I don't set j as j starts from i to n; instead, when i moves, 
	 *  	I want j starts from the lowest prime number (in the optimal solution this number is 3) 
	 *  	all the way to i (in the optimal solution, moving all the way to square root of i is enough)
	 *  	then if i % j == 0, I know this i is a composite number that can be eliminated.
	 *  So, the core is using MOD.
	 *  
	 *  Time Complexity: O(n) < this time complexity < O(n^2)
	 *  Space Complexity: O(1) - just use two pointers  
	 *  
	 *  Note: this solution time exceeds limit when n = 499,979 on LeetCode
	 *  	Maybe the time complexity is more toward O(n^2) compared with Solution 2 and 1?
	 *  	Maybe Solution 1 and 2 successfully traded space for time so they are faster than this solution.
	 */
	public static Result getPrimeNumbers3(int n) {
		List<Integer> primeNums = new ArrayList<>();
		primeNums.add(2);
		int count = 1;
		for (int i = 3; i <= n; i += 2) {
			boolean isPrime = true;
			for (int j = 3; j <= Math.sqrt(i); j++) {
				if (i % j == 0)
					isPrime = false;
			}
			if (isPrime) {
				primeNums.add(i);
				count++;
			}
		}
		return new Result(primeNums, count);
	}
	
	/**
	 * Scenario: Interview says if I tell you the n is 100 for sure, then can you solve this in one pass O(n) time complexity?
	 * 
	 * YES.
	 * 	From our Math knowledge, the first couple prime numbers are 2, 3, 5, 7, 11, 13. 
	 * And the first composite number that is formed by the multiplication of two prime numbers whose product right above 100
	 * is 121 (11 * 11), cuz 7 * 13 = 91 < 100. 
	 * That said, all the composite numbers within 100 must have a factor from {2, 3, 5, 7}.
	 * Bingo, one for loop one pass solves it.
	 */
	public static Result getPrimeNumbers4(int n) {
		List<Integer> primeNums = new ArrayList<>();
		Collections.addAll(primeNums, 2, 3, 5, 7);
		int count = 4;
		for (int i = 7; i < n; i += 2) {
			if ((i % 3 != 0) && (i % 5 != 0) && (i % 7 != 0)) {
				primeNums.add(i);
				count++;
			}
		}
		return new Result(primeNums, count);
	}
	
	public static void main(String[] args) {
		int n = 100;
		System.out.print(String.format("For n = %d", n));
		/*-- Solution 1 --*/
		System.out.print(String.format("\nThere are %d prime numbers.", getPrimeNumbers1(n).count));
		System.out.print(" And they are: " ); ListUtil.display(getPrimeNumbers1(n).primeNumbers);
		/*-- Solution 2 --*/
		System.out.print(String.format("\nThere are %d prime numbers.", getPrimeNumbers2(n).count));
		System.out.print(" And they are: " ); ListUtil.display(getPrimeNumbers2(n).primeNumbers);
		/*-- Solution 3 --*/
		System.out.print(String.format("\nThere are %d prime numbers.", getPrimeNumbers3(n).count));
		System.out.print(" And they are: " ); ListUtil.display(getPrimeNumbers3(n).primeNumbers);
		/*-- Solution 4 --*/
		System.out.print(String.format("\nThere are %d prime numbers.", getPrimeNumbers4(n).count));
		System.out.print(" And they are: " ); ListUtil.display(getPrimeNumbers4(n).primeNumbers);
	}
}

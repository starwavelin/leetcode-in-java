package bitwise;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
/**
 * LeetCode 137. Single Number II
 * https://leetcode.com/problems/single-number-ii/description/
 * 
 * http://www.lintcode.com/en/problem/single-number-ii/
 * 3n+1 numbers, every number occurs triple times except one, find that number.
 * Method: Ternary addition without carry on.
 * 
 * 012
 * 012
 * 012
 * ---
 * 000  <-- cancel out
 * 
 * commutative, associative
 * a XOR3 0 = a
 * a XOR3 a XOR3 a = 0
 */
public class SingleNumberII {

	public static int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		int res = 0;
		for (int i = 0; i <= 31; i++) {
			int sum = 0;
			for (int n : nums) {
				sum += (n >> i) & 1;
				sum %= 3;
  			}
			res = res | (sum << i);
		}
		return res;
	}
	
	/**
	 * The numbers in the array as key and its occurrence as value;
	 * find the number with occurrence equaling to 1.
	 * @param nums
	 * @return
	 */
	public static int hashMapSol(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				int count = map.get(nums[i]) + 1;
				map.put(nums[i], count);
			}
		}
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Single Number II Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n" +
				"leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		System.out.print("Give your Solution (1--XOR3 or 2--HashMap): ");
		
		int method = sc.nextInt();
		int result = 0;
		switch (method) {
			case 1:
				result = singleNumber(testArray);
				break;
			case 2:
				result = hashMapSol(testArray);
				break;
			default:
				System.out.println("Please check your input for the method number!");
				break;
		}
		
		System.out.println("The single number in your given int array is " + result);
	}
}

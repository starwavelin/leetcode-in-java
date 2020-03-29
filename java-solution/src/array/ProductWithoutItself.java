package array;

import java.util.Scanner;

/***************************************************************************
* Problem No. : 238
* Problem Name: Product of Array Except Self
* Problem URL : https://leetcode.com/problems/product-of-array-except-self/description/
* Date        : May 1, 2018
* Author      : Xian Lin
* Notes       :
* 	Scenario:
* 		
* 	Assumption:
* 		
	Example:
* 	Input/Output:
* 		
* 	Data Structure and Alg:
* 		see code comments
* Complexity  :
* 	Time Complexity: O() -- see code comments
* 	Space Complexity: O() -- see code comments
*
* meta        : tag-array, tag-
***************************************************************************/
public class ProductWithoutItself {

	public static int[] productExcludeItself(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}

		int size = nums.length;
		int[] res = new int[size];

		// initialize ret array
		for (int i = 0; i < size; i++) {
			res[i] = 1;
		}

		// Solve the left part
		for (int i = 1; i < size; i++) {
			res[i] = res[i-1] * nums[i-1];
		}

		// Solve the right part
		int tmp = 1;
		for (int i = size - 1; i >= 0; i--) {
			res[i] = res[i] * tmp;
			tmp = tmp * nums[i];
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println("*** Welcome to Xian's Product Without Itself Test ***");

		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \nleave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}

		int[] result = productExcludeItself(testArray);
		if (result != null) {
			System.out.print("The product array without multiplying itself is: ");
			for (long l : result) {
				System.out.print(l + ", ");
			}
		} else {
			System.out.print("Please check your input array!");
		}
	}

}

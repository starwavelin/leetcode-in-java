package math;

import java.util.Scanner;

/***************************************************************************
* Problem No. : 169
* Problem Name: Majority Element
* Problem URL : https://leetcode.com/problems/majority-element/description/
* Date        : May 1, 2018
* Author      : @codingbro
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
* meta        : tag-, tag-
***************************************************************************/
public class MajorityNumber1 {

	public static int majorityNumber(int[] nums) {
		int candidate = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				candidate = nums[i];
				count++;
			} else {
				if (nums[i] == candidate) {
					count++;
				} else {
					count--;
				}
			}
		}
		return candidate;
	}


	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Majority Number I Test ***");

		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n" +
				"leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}

		int result = majorityNumber(testArray);
		System.out.println("The majority number in your given int array is " + result);
	}

}

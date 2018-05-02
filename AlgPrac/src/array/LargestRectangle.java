package array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;


/***************************************************************************
* Problem No. : 84
* Problem Name: Largest Rectangle in Histogram
* Problem URL : https://leetcode.com/problems/largest-rectangle-in-histogram/description/
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
public class LargestRectangle {
	/**
	 * http://www.lintcode.com/en/problem/largest-rectangle-in-histogram/
	 * Largest Rectangle in Histogram
	 * Solution 1: O(n^3)
	 * Solution 2: O(n^2)
	 * Solution 3: O(n)
	 * @author Guru
	 */

	/*
		TLE at Test Case 95
	*/
	public static int solution1(int[] heights) {
		int size = heights.length;
		int maxArea = 0;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j <= size; j++) {
				int h = heights[i];

				// This loop is for finding the lowest height
				// in the bars of (j-i) region
				for (int k = i; k < j; k++) {
					if (heights[k] < h) {
						h = heights[k];
					}
				}

				if ((j - i ) * h > maxArea) {
					maxArea = (j - i) * h;
				}
			}
		}
		return maxArea;
	}


	/**
	 * Solution 2: AC 741ms
	 * Unlike Solution1, when j is scanning the array,
	 * we keep a variable h to record the lowest height
	 * in the [i, j] range.
	 * @param heights
	 * @return
	 */
	public static int solution2(int[] heights) {
		int size = heights.length;
		int maxArea = 0;

		for (int i = 0; i < size; i++) {
			int minH = heights[i];

			// Use inner loop to get the lowest height of the rectangle formed by [i, j]
			for (int j = i + 1; j <= size; j++) {
				if (heights[j - 1] < minH) {
					minH = heights[j - 1];
				}
				if ((j - i) * minH > maxArea) {
					maxArea = (j - i) * minH;
				}
			}
		}
		return maxArea;
	}

	/**
	* Solution 3: AC 26ms
	* Idea: enumerate the heights of the histogram first.
	* Then, for each height, scan left and right to find the
	* left boundary bar and the right boundary bar with
	* heights less than it.
	* Calculate the area.
	* @param heights
	* @return
	*/
	public static int solution3(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		int maxArea = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i <= heights.length; i++) {
			int curH = (i == heights.length) ? 0 : heights[i];
			while (!stack.isEmpty() && curH <= heights[stack.peek()]) {
				maxArea = Math.max(maxArea, heights[stack.pop()] * (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
			stack.push(i);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Largest Rectangle in Histogram Test ***");

		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n" +
				"leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}

		System.out.print("Give your Solution (1, 2, or 3): ");

		int method = sc.nextInt();
		int result = 0;
		switch (method) {
			case 1:
				result = solution1(testArray);
				break;
			case 2:
				result = solution2(testArray);
				break;
			case 3:
				result = solution3(testArray);
				break;
			default:
				System.out.println("Please check your input for the method number!");
				break;
		}
		System.out.println("The largest rectangle area based on your given int array is " + result);
	}
}

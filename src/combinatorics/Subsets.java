package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/***************************************************************************
* Problem No. : 78
* Problem Name: Subsets
* Problem URL : https://leetcode.com/problems/subsets/description/
* Date        : Dec 17 2017
* Author      :	Xian Lin
* Notes       :
* 	Scenario:
* 		Given an array nums of DISTINCT integers and find all the subsets.
* 	Assumption:
* 		1. distinct integers in the given array
	Example:
* 	Input: [1, 2, 3]
* 	Output: should have 2^3 = 8 elements in the result list.
* 		one possible output is below:
* 		[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
* 	Data Structure and Alg:
* 		See Code Comments
* Complexity  :
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
*
* meta        : tag-combinatorics
***************************************************************************/
public class Subsets {

	/**
	 * Time Complexity: O(2^n)
	 * Space Complexity: O(n) help path list that would hold n elements at most.
	 */
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums); // no matter nums = [2,1,3] or [3,1,2], we start with [1,2,3]
		List<Integer> path = new ArrayList<>();
		dfs(nums, 0, path, res);
		return res;
	}

	private static void dfs(int[] nums, int pos, List<Integer> path, List<List<Integer>> res) {
		res.add(new ArrayList<Integer>(path));
		for (int i = pos; i < nums.length; i++) { // loop counter should starts with pos instead of 0
			path.add(nums[i]);
			dfs(nums, i + 1, path, res); //Note: here is not pos+1 but i+1 !!!
				// cuz the logic here is after adding the ith element, you can only add the next element having index > i
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] {3, 1, 2};
		List<List<Integer>> res = subsets(nums);
		for (List<Integer> l : res) {
			for (int num : l) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}

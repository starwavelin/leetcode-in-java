package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import utility.ListUtil;
/***************************************************************************
* Problem No. : 15
* Problem Name: Three Sum
* Problem URL : https://leetcode.com/problems/3sum/description/
* Date        : Oct 27 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
* 		Find all unique triplets in the array which gives the sum of zero.
* 	Assumption:
* 		0. When there is no answer, return an empty list
* 		1. Duplicate elements could exist in the array S
* 		2. But your solution cannot contain duplicate triplets
	Example:
* 	Input: [-2, -3, -3, 2, -3, 6, 1, 0, 6]
* 	Output: 
* 		[
* 			[-3, -3, 6],
* 			[-3, 1, 2],
* 			[-2, 0, 2]
* 		]
* 	Data Structure and Alg:
* 		See Code Comments  
* Complexity  : 
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
* 
* meta        : tag-array, tag-two-pointers, tag-sort, tag-hash
***************************************************************************/
public class ThreeSum {
	/**
	 * A brute force solution is: for each given num in nums, try to find the other two numbers in nums such that their sum is the 
	 * opposite of the given num. This solution uses 3 nested for loops so time complexity is O(n^3).
	 * We don't want this naive solution.
	 * 
	 * Solution 1:
	 * 	Sort the nums array first, then
	 * 	For each number in nums, we want to find the other two numbers whose sum is the opposite of the given num.
	 *  The outer for loop costs O(n) and the part inside the for loop is a two-sum on a sorted array problem,
	 *  which can be solved in O(n). So total time complexity is O(nlogn) + O(n^2) = O(n^2)
	 * Optimization and De-duplication:
	 * 	 1. The next fixed number in the outer for-loop should be the one which is next greater than current fixed number
	 * 		ie, [-3, -3, -3, -2, 0, 1, 2, 6, 6], cur fixed number is -3, than next fixed number should be -2,
	 * 			cuz [-3, 1, 2] [-3, 1, 2] are the same solution.
	 * 	 2. The left pointer of the two-sum subproblem should start from the one after the current fixed number,
	 * 		ie. If the current fixed number is -3, left pointer should start from -2; 
	 * 			if the cur fixed number is -2, left pointer should start from 0.
	 *   3. How many steps should left pointer move when we found a solution?
	 *   	ie, [-3, -3, -3, -2, 0, 1, 2, 6, 6], and we found one solution [-3, -3, 6] where the middle -3 is from index 1 and 6 is from index nums.lenth-1
	 *   	then if we just move left pointer one index to right and right pointer one index to left, 
	 *   		we will get another [-3, -3, 6] where the middle index is from index 2 and 6 is from index nums.length - 2.
	 *   	Duplication!
	 *   	So, left pointer should start from the next number that is greater than the cur fixed number, and when 
	 *   moving next pointer, we want to move it to the number that is not equal to the number left pointer currently points!!!
	 *   	In this example, once we found [-3, -3, 6], left pointer moves to number -2, right pointer moves to -6 with index nums.length - 2.
	 * 
	 * Space Complexity: O(1)
	 * 
	 * 口诀：	Sort后，cur下一个必找大于当前的，left pointer先为cur之下一个，如有解了，left pointer下一个必为大于当前的。
	 */
	public static List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return res;
		}
		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length - 2) {
			int target = - nums[i];
			int l = i + 1, r = nums.length - 1;
			while (l < r) {
				if (nums[l] + nums[r] > target) {
					r--;
				} else if (nums[l] + nums[r] < target) {
					l++;
				} else {
					List<Integer> rec = new ArrayList<>();
					rec.add(nums[i]);
					rec.add(nums[l++]);
					rec.add(nums[r--]);
					res.add(rec);
					while (l < nums.length && nums[l] == nums[l - 1]) { //while去有解后leftpointer的重，leftpointer不可越界
						l++;
					}
					/* 有解的情况下, 已经对左指针去重了，还要对右指针去重使效率更高吗？
					 * 错误！！
					 * 比如 Input： [-2,0,1,1,2]
					 * 找到解 [-2, 0, 2] 后，如果再对右指针去重，后果会怎么样？ 略去了[-2,1,1]这个答案 */
					/*
					 * while (r > 0 && nums[r] == nums[r - 1]) {
						 r--;
					   }
					 */
				}
			}
			i++;
			while (i < nums.length && nums[i] == nums[i - 1]) { //while去curNumber的重，curNumber不可越界
				i++;
			}
		}
		return res;
	}
	
	/**
	 * Solution 2:
	 * 	Firstly Sort, then
	 * 	Use HashSet<List<Integer>> to dedup
	 * Space Complexity: O(n) cuz used HashSet, not as efficient as Solution 1
	 * Time Complexity is remain O(n^2)
	 */
	public static List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return res;
		}
		Arrays.sort(nums);
		HashSet<List<Integer>> resSet = new HashSet<>();
		int i = 0; 
		while (i < nums.length - 2) {
			int target = -nums[i];
			int l = i + 1, r = nums.length - 1;
			while (l < r) {
				if (nums[l] + nums[r] < target) {
					l++;
				} else if (nums[l] + nums[r] > target) {
					r--;
				} else {
					List<Integer> rec = new ArrayList<>();
					rec.add(nums[i]);
					rec.add(nums[l++]); //注意这一行和下一行的 ++， -- 不可少！！
					rec.add(nums[r--]);
					/* before adding rec to res, check it in set first!! */
					if (!resSet.contains(rec)) {
						resSet.add(rec); // add current record to the set for future dedup purpose
						res.add(rec);
					}
				}
			}
			i++; // You don't need to optimize this if you totally rely on HashSet to do dedup
		}
		return res;
	}
	
	/**
	 * 3Sum without sorting 出于时间关系先不想了，以下解答去重不成功 @needOrganize
	 * Solution 3:
	 * 	Scenario: If I say you are not supposed to sort the input array, can you still solve it in a way better than O(n^3)?
	 * Idea:
	 * 	Based on Solution 2 which uses HashSet, 
	 * For each num being iterated in the outer loop, we found a solution based on two-sum sub-problem.
	 * And for the twoSum sub-problem, we use HashSet to find a solution, and another hashSet to dedup. 
	 * So in total we use three hashsets, the third hashset is the one to dedup the 3Sum solution. 
	 * Then, only non-duplicate triplets can be added to the final result set.
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(n) -- Use three HashSets and each has O(n)
	 */
	public static List<List<Integer>> threeSum3(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return res;
		}
		HashSet<List<Integer>> threeSumSet = new HashSet<>(); //3Sum Set
		int i = 0; 
		while (i < nums.length - 2) {
			int target = -nums[i];
			int j = i + 1; //since we are gonna use HashSet to solve the sub 2Sum problem, one pointer j is enough.
			HashSet<List<Integer>> twoSumSet = new HashSet<>();
			HashSet<Integer> set = new HashSet<>();
			while (j < nums.length) {
				if (set.contains(target - nums[j])) {
					//Dedup twoSum solutions first
					List<Integer> twoSumRec = new ArrayList<>();
					twoSumRec.add(target - nums[j]);
					twoSumRec.add(nums[j]);
					if (!twoSumSet.contains(twoSumRec)) {
						twoSumSet.add(twoSumRec);
						//Dedup threeSum solutions
						List<Integer> threeSumRec = new ArrayList<>();
						threeSumRec.add(nums[i]);
						threeSumRec.add(target - nums[j]);
						threeSumRec.add(nums[j]);
						if (!threeSumSet.contains(threeSumRec)) {
							threeSumSet.add(threeSumRec);
							res.add(threeSumRec);	// add a non duplicate triplet to the final res
						}
					}
				} else {
					set.add(nums[j]);
				}
				j++;
			}
			i++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{-2, -3, 0, -3, -3, 2, 6, 1, 6};
		List<List<Integer>> res = threeSum1(nums);
		for (List<Integer> l : res) {
			System.out.print("One result is: ");
			ListUtil.display(l);
		}
		
		System.out.println();
		nums = new int[]{0, 0, 0};
		res = threeSum1(nums);
		for (List<Integer> l : res) {
			System.out.print("One result is: ");
			ListUtil.display(l);
		}
		
		/* Solution 2 */
		System.out.println();
		nums = new int[]{-2, -3, 0, -3, -3, 2, 6, 1, 6};
		res = threeSum2(nums);
		for (List<Integer> l : res) {
			System.out.print("One result is: ");
			ListUtil.display(l);
		}
		
		System.out.println();
		nums = new int[]{0, 0, 0};
		res = threeSum2(nums);
		for (List<Integer> l : res) {
			System.out.print("One result is: ");
			ListUtil.display(l);
		}
		
		/* Solution 3 */
		System.out.println();
		nums = new int[]{-2, -3, 0, -3, -3, 2, 6, 1, 6};
		res = threeSum3(nums);
		for (List<Integer> l : res) {
			System.out.print("One result is: ");
			ListUtil.display(l);
		}
		
		System.out.println();
		nums = new int[]{-1, 0, 1, 2, -1, 4};
		res = threeSum3(nums);
		for (List<Integer> l : res) {
			System.out.print("One result is: ");
			ListUtil.display(l);
		} // Results should be [-1, -1, 2], [-1, 0, 1].  No dups like [0, 1, -1]
		
		//Test
		/*
		HashSet<List<Integer>> testR = new HashSet<>();
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> l3 = new ArrayList<>();
		l1.add(-3); 
		l1.add(-3);
		l1.add(6);
		l2.add(-3);
		l2.add(6);
		l2.add(-3);
		l3.add(-3); 
		l3.add(-3);
		l3.add(6);
		testR.add(l1);
		testR.add(l2);
		testR.add(l3);
		for (List<Integer> l : testR) {
			System.out.print("One Test result is: ");
			ListUtil.display(l);
		}
		//Only two results in testR: -3, 6, -3 and -3, -3, 6. And for our problem we want to consider these two as one.
		*/
	}
}

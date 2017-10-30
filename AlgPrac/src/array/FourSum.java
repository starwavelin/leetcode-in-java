package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import utility.ListUtil;

/***************************************************************************
* Problem No. : 18
* Problem Name: Four Sum
* Problem URL : https://leetcode.com/problems/4sum/description/
* Date        : Oct 30 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given an array S of n integers, find four integers in S such that their sum equals a given number, target. 
* 		Return all the unique quadruplets.
* 	Assumption:
* 		1. 
	Example:
* 	Input: [1, 0, -1, 0, -2, 2], and target = 0
* 	Output: 
* 		[
  			[-1,  0, 0, 1],
  			[-2, -1, 1, 2],
  			[-2,  0, 0, 2]
		]
* 	Data Structure and Alg:
* 		See Code Comments  
* Complexity  : 
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
* 
* meta        : tag-array, tag-two-pointers, tag-sort, tag-hash
***************************************************************************/
public class FourSum {
	
	/**
	 * Solution 1:
	 * 	Sort the given input array first, then for each element in the outer loop, the inner one becomes a 3Sum problem,
	 * and we solve the 3Sum problem in O(n^2). Then total time complexity is O(n^3). 
	 * And the key point is to de-duplicates.
	 * Space complexity is O(1) cuz we just use several pointers to help us.
	 */
	public static List<List<Integer>> fourSum1(int[] nums, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 4) {
			return res;
		}
		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length - 3) {
			/* 3Sum problem inside */
			int threeSumTarget = k - nums[i];
			int j = i + 1;
			while (j < nums.length - 2) {
				int twoSumTarget = threeSumTarget - nums[j];
				int l = j + 1, r = nums.length - 1;
				while (l < r) {
					if (nums[l] + nums[r] < twoSumTarget) {
						l++;
					} else if (nums[l] + nums[r] > twoSumTarget) {
						r--;
					} else {
						List<Integer> rec = new ArrayList<>();
						rec.add(nums[i]);
						rec.add(nums[j]);
						rec.add(nums[l++]);
						rec.add(nums[r--]);
						res.add(rec);
						while (l < nums.length - 1 && nums[l] == nums[l - 1]) {
							l++;
						}
					}
				}
				j++; //对while loop始终不忘记loop counter的自增
				while (j < nums.length - 2 && nums[j] == nums[j - 1]) {
					j++;
				}
			}
			i++;
			while (i < nums.length - 3 && nums[i] == nums[i - 1]) {
				i++;
			}
		}
		return res;
	}
	
	/**
	 * Solution 2:
	 * 	Decompose this problem into a twice twoSum problem, and use HashMap to buy time.
	 * Procedure as below:
	 * 	Use a HashMap with key = twoSum and value = List of solutions contributing to this twoSum.
	 * 	Then traverse this hashMap and see if (target - key) is also in the hashMap, 
	 * 		if yes, concatenate the solutions from key and (target - key) to form a quadruplet 
	 * 
	 * ie. Input [-3, -3, 0, 1, 2, 6] k = 0
	 * 	HashMap would be 
	 * 		[
	 * 			<-3, [[-3, 0]]>,
	 * 			<-2, [[-3, 1]]>,
	 * 			<-1, [[-3, 2]]>,
	 * 			<3, [[-3, 6], [1, 2]]>,
	 * 			<1, [[0, 1]]>,
	 * 			<2, [[0, 2]]>,
	 * 			<6, [[0, 6]]>,
	 * 			<7, [[1, 6]]>,
	 * 			<8, [[2, 6]]>
	 * 		]
	 * Then the solution would be contributed from keys -3 and 3, -2 and 2, -1 and 1
	 * which are primitively [-3, 0, -3, 6], [-3, 0, 1, 2], [-3, 1, 0, 2], [-3, 2, 0, 1] and after de-dup
	 * [-3, -3, 0, 6], [-3, 0, 1, 2]
	 * 
	 * Note: 
	 * to dedup, I use Collections.sort(formedList) before adding a list to the final solutions set,
	 * and also use a HashSet to avoid duplicates being added in.
	 * But still  @needCorrection, see code below...
	 * 
	 * Time Complexity: Best case O(n^2) if the solution sets for key and and (target - key) are even; worst case can still be O(n^3)
	 * Space Complexity: O(n^2) cuz the twoSum hashmap is formed by double loops over the input array of size n 
	 */
	public static List<List<Integer>> fourSum2(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 4) {
			return res;
		}
		Arrays.sort(nums);
		HashSet<List<Integer>> dedupSet = new HashSet<>();
		HashMap<Integer, List<List<Integer>>> twoSumMap = new HashMap<>();
		/* Form TwoSumMap */
		int i = 0;
		while (i < nums.length - 1) {
			int j = i + 1;
			while (j < nums.length) {
				int twoSum = nums[i] + nums[j];
				if (!twoSumMap.containsKey(twoSum)) {
					List<List<Integer>> twoSumList = new ArrayList<>();
					List<Integer> twoSumRec = Arrays.asList(nums[i], nums[j]);
					twoSumList.add(twoSumRec);
					twoSumMap.put(twoSum, twoSumList);
				} else {
					twoSumMap.get(twoSum).add(Arrays.asList(nums[i], nums[j]));
				}
				j++;
				while (j < nums.length && nums[j] == nums[j - 1]) {
					j++;
				}
			}
			i++;
			while (i < nums.length - 1 && nums[i] == nums[i - 1]) {
				i++;
			}
		}
		/* Form Solutions */
		for (Integer key: twoSumMap.keySet()) {
			if (twoSumMap.containsKey(target - key)) {
				List<Integer> rec = new ArrayList<>();
				for (i = 0; i < twoSumMap.get(key).size(); i++) {
					rec.addAll(twoSumMap.get(key).get(i));
					for (int j = 0; j < twoSumMap.get(target - key).size(); j++) {
						rec.addAll(twoSumMap.get(target - key).get(j));
						Collections.sort(rec);
						if (!dedupSet.contains(rec)) {
							dedupSet.add(rec);
							res.add(rec);
						}
						/* @needCorrection
						 * Dedup not success yet
						 * reset the two numbers that contribute to the 2nd twoSum */
						//rec.remove(twoSumMap.get(target - key).get(j).get(0));
						//rec.remove(twoSumMap.get(target - key).get(j).get(1));
					}
					/* reset the two numbers that contribute to the 1st twoSum */
					rec = new ArrayList<>();
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{1, 0, -1, 0, -2, 2};
		int k = 0;
		List<List<Integer>> res = fourSum1(nums, k); /* toggle here to change the solution you wanna use */
		for (List<Integer> l : res) {
			System.out.print("One result is: ");
			ListUtil.display(l);
		}
		
		System.out.println();
		nums = new int[]{-3, -3, 0, 1, 2, 6};
		res = fourSum2(nums, k);		/* toggle here to change the solution you wanna use */
		for (List<Integer> l : res) {
			System.out.print("One result is: ");
			ListUtil.display(l); // should be [-3, -3, 0, 6], [-3, 0, 1, 2]
		}
	}
}
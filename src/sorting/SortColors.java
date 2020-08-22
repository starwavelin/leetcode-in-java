package sorting;

import java.util.HashMap;

/***************************************************************************
* Problem No. : 75
* Problem Name: Sort Colors
* Problem URL : https://leetcode.com/problems/sort-colors/description/
* Date        : Oct 24 2017
* Author      :	@codingbro
* Notes       :
* 	Scenario:
* 		Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
* 		with the colors in the order red, white and blue.
* 		Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
* 	Assumption:
* 		1. Not suppose to use the library's sort function
* 		in other words, the time complexity for this problem should be better than O(nlogn).
	Example:
* 	Input/Output:
* 		Input nums array: [2, 0, 1, 0, 0, 2]
* 		Output nums array: [0, 0, 0, 1, 2, 2]
* 	Data Structure and Alg:
* 		see code comments
* Complexity  :
* 	Time Complexity: O() -- see code comments
* 	Space Complexity: O() -- see code comments
*
* meta        : tag-sort, tag-two-pointers, tag-array
***************************************************************************/
public class SortColors {

	/**
	 * Solution 1:	构建法
	 *  A naive solution using hashmap that I do NOT recommend.
	 * Idea:
	 * 	Use a hashmap to count the frequency of each number and than overwrite the
	 * original array with the occurrence of each number in order.
	 *
	 * Drawback: HashMap is a high overhead data structure and we only have 3 types of colors. Is it worth to use it?
	 * 而且还有个陷阱，要是我的input数字没有0呢？没有1呢？只有2呢？会怎么样？每一个map.get都要写成 map.getOrDefault(x, defaultValue); 麻烦死了！
	 *
	 * Time Complexity: O(n) -- Scan once for putting data to map and scan another time for overwriting nums array.
	 * Space Complexity: O(1) -- hashmap has a constant number of keys, cuz only 3 types of colors, 0, 1, or 2.
	 */
	public static void sortColors1(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		int i = 0;
		while (i < map.getOrDefault(0, 0)) {
			nums[i++] = 0; //写while loop别忘了更新scanner
		}
		while (i < map.getOrDefault(0, 0) + map.getOrDefault(1, 0)) {
			nums[i++] = 1;
		}
		while (i < map.getOrDefault(0, 0) + map.getOrDefault(1, 0) + map.getOrDefault(2, 0)) {
			nums[i++] = 2;
		}
	}

	/**
	 * Solution 2: Construction Way | 构建法
	 *  Based on solution 1, instead of using a hashmap, we just use 3 vars to save the occurrence of each number cuz
	 *  there are 3 diff numbers only.
	 *
	 * Time Complexity O(n) - one pass for count occurrences and the other pass for construction
	 * Space Complexity O(1）- cuz we only use 4 extra vars
	 */
	public static void sortColors2(int[] nums) {
		int count0 = 0, count1 = 0, count2 = 0;
		for (int n : nums) {
			switch (n) {
			case 0:
				count0++;
				break;
			case 1:
				count1++;
				break;
			case 2:
				count2++;
				break;
			default:
				return; // illegal input number, directly return
			}
		}
		int i = 0;
		while (i < count0) {
			nums[i++] = 0; //写while loop别忘了更新scanner
		}
		while (i < count0 + count1) {
			nums[i++] = 1;
		}
		while (i < count0 + count1 + count2) {
			nums[i++] = 2;
		}
	}

	/**
	 * Solution 3: Use the thought of array partition
	 * 	Two pointers plus a traveler pointer, with the two pointers moving toward each other.
	 * 	Use left pointer to denote the pointer for 0, starting from index 0, right pointer to denote the pointer for 2,
	 * starting from index nums.length - 1. Pointer i, the traveler pointer.
	 * 	For the one pass traversal,
	 * 		when i reaches 0, swap the value i points and the value left pointer points, and left++
	 * 		when i reaches 2, swap the value i points and the value right pointer points, and right--, i-- !!!
	 * 		when i reaches 1, continue traverse
	 *
	 * Time Complexity: O(n) and one pass
	 * Space Complexity: O(1)
	 *
	 * Pitfalls:
	 * 	1. Need to handle the case that input is all 1s
	 *  2. handle the case the input array is already sorted
	 *  	So the one pass traversal condition cannot be "while (left < right)"
	 *  but, for (; i <= r, i++), to use the traveler pointer and right pointer to determine stop condition.
	 */
	public static void sortColors3(int[] nums) {
		int i = 0, l = 0, r = nums.length - 1;
		for (; i <= r; i++) {
			if (nums[i] == 0) {
				int t = nums[i];
				nums[i] = nums[l];
				nums[l++] = t;
			} else if (nums[i] == 2) {
				int t = nums[i];
				nums[i--] = nums[r];
				nums[r--] = t;
			}
		}
	}

	public static void displayArray(int[] nums) {
		System.out.print("\nThe sorted array is: ");
		for (int n : nums) {
			System.out.print(n + " ");
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[]{2, 0, 1, 0, 0, 2};

		/* Solution 1 */
		sortColors1(nums);
		displayArray(nums);

		/* Solution 2 */
		nums = new int[]{2, 0, 1, 0, 0, 2};
		sortColors2(nums);
		displayArray(nums);

		/* Solution 3 */
		nums = new int[]{2, 0, 1, 0, 0, 2};
		sortColors3(nums);
		displayArray(nums);

		nums = new int[]{1, 2};
		sortColors3(nums);
		displayArray(nums);

		nums = new int[]{2, 1, 0, 0, 2, 0};
		sortColors3(nums);
		displayArray(nums);

		nums = new int[]{1, 1};
		sortColors3(nums);
		displayArray(nums);

		nums = new int[]{0, 1, 1, 2};
		sortColors3(nums);
		displayArray(nums);
	}
}

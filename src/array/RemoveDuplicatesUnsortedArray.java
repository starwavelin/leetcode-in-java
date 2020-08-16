package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This is a class providing methods
 * for removing duplicates from an unsorted 
 * integer array, with the original order 
 * of elements preserved.
 * 
 * 1. O(n^2) time O(1) space
 * 2. O(n) time with O(1) lookup in HashMap; O(n) space
 * 
 * @author Guru
 *
 */
public class RemoveDuplicatesUnsortedArray {
	private static Scanner sc;

	/**
	 * Solution 1: Naive O(n^2)
	 * This method has a bug:
	 * 3 3 5 3 3 6 returns 3 5 3 6
	 * 3 3 3 6 returns 3 3 6
	 * @param nums
	 * @return
	 */
	public static int removeDup1(int[] nums) {
		int target;
		int size = nums.length;
		for (int i = 0; i < size; i++) {
			target = nums[i];
			for (int j = i + 1; j < size; j++) {
				if (nums[j] == target) {
					for (int k = j; k < size - 1; k++) {
						nums[k] = nums[k + 1];
					}
					size--;
				}
			}
		}
		return size;
	}
	
	/**
	 * Solution 2: O(n) time solution with the help of HashMap
	 * @param nums
	 * @return
	 */
	public static ArrayList<Integer> removeDup2(int[] nums) {
		int size = nums.length;
		ArrayList<Integer> ret = new ArrayList<Integer>();
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < size; i++) {
			if (!hash.containsKey(nums[i])) {
				hash.put(nums[i], 1);
				ret.add(nums[i]);
			}
		}
		return ret;
	}
	
	
	public static void displayArray(int[] nums, int size) {
		for(int i = 0; i < size; i++) {
			System.out.print(" " + nums[i]);
		}
	}
	
	public static void displayArrayList(ArrayList<Integer> ret) {
		int size = ret.size();
		for (int i = 0; i < size; i++) {
			System.out.print(" " + ret.get(i));
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Coding Bro's Remove Duplicates from an Unsorted Array Test ***");
		
		sc = new Scanner(System.in);
		System.out.print("Input your integer Unsorted array, leaving each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		System.out.println("Your input array after duplication removal is: ");
//		int size = removeDup1(testArray);
//		displayArray(testArray, size);
		ArrayList<Integer> ret = removeDup2(testArray);
		displayArrayList(ret);
	} 
	
}

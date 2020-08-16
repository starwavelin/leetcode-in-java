package array;

/***************************************************************************
* Problem No. : 283
* Problem Name: Move Zeros
* Problem URL : https://leetcode.com/problems/move-zeroes/description/
* Date        : Oct 17 2017
* Author      :	Xian Lin
* Notes       :
* 	Scenario:
* 		Given an integer array, move its all zeros into the end of the array but preserve the order of non-zero elements
* 	Assumption:
* 		1. No extra copy of the array, must do this in-place
* 		2. Try minimize the number of operations
	Example:
* 	Input: [0, 89, -13, 0, 7]
* 	Output: [89, -13, 7, 0, 0]
* 	Data Structure and Alg:
* 		Defensive check. Create an insertion position starting with 0,
* 		move non-zero elements to the insertion positions, and fill out the left positions with 0s.
* 	** This is actually a two-pointers method. insertionPointer is to chase traverlerPointer.
* 	yes, we do have a traveler pointer, when we set for (int num: nums), we have a traveler pointer
* 	traverse the array elements one by one. insertionPointer is usually behind travelerPointer cuz
* 	we only increase it when we encounter a non-zero element.
* 	insertionPointer:
* 		1. First Step we use it to fill in non-zero elements
* 		2. Second Step use it to fill in 0s.
* Complexity  :
* 	Time Complexity: O(n) -- traverse the whole array once
* 	Space Complexity: O(1) -- use an extra var insertPos
*
* meta        : tag-array
***************************************************************************/
public class MoveZeros {
	public static class Array {
		public void moveZeros(int[] nums) {
			if (nums == null || nums.length == 0) {
				return;
			}
			int insPos = 0; // insertion position
			for (int num : nums) {
				if (num != 0)
					nums[insPos++] = num;
			}
			while (insPos < nums.length) {
				nums[insPos++] = 0;
			}

			//I only traverse this array once to complete the task in place.
			//The following is for testing purpose; don't need to show in a coding exam
			System.out.print("Now the array is: ");
			for (int num : nums) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Array myArr = new Array();
		int[] arr1 = new int[]{0, 1, -3, 0, 9};
		myArr.moveZeros(arr1);// should see 1, -3, 9, 0, 0
		int[] arr2 = new int[]{5, 9, -8}; // even though the original array doesn't have 0s
		myArr.moveZeros(arr2);// the algo should work by preserve the original order of elements
	}
}

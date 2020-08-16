package math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
/**
 * http://www.lintcode.com/en/problem/majority-number-iii/
 * Exactly one number int he array which appears more than 1/k times
 * Method: Use HashMap.
 * O(n) time and O(k) extra space.
 *
 */
public class MajorityNumberIII {
	
	public static int majorityNumber(int[] nums, int k) {
		if (nums.length == 0) {
			return 0;
		}
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int elem : nums) {
			if (!map.containsKey(elem)) {
				map.put(elem, 1);
			} else {
				map.put(elem, map.get(elem) + 1);
			}
			if (map.size() == k) {
				removeKey(map);
			}
		}
		
		// Scan the hashmap again
		if (map.size() == 0) {
			return Integer.MIN_VALUE;
		}
		int maxKey = 0;
        int max = 0;
        Set<Integer> keySet = map.keySet();
        for (int i : keySet) {
            int count = 0;
            for (int j : nums) {
                if (i == j) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                maxKey = i;
            }
        }
        
        return maxKey;
	}
	
	private static void removeKey(HashMap<Integer, Integer> map) {
		Set<Integer> keyset = map.keySet();
		List<Integer> removeList = new ArrayList<Integer>();
		for (int key : keyset) {
			if (map.get(key) == 1) {
//				map.remove(key);
				
				removeList.add(key);
			} else {
				map.put(key, map.get(key) - 1);
			}
		}
		for (int elem : removeList) {
			map.remove(elem);
		}
		
		/* If we don't use a list to store the keys to be removed
		 * and do the removing process after the 1st for loop, 
		 * we will encoutner the ConcurrentModificationException */
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Majority Number III Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n" +
				"leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		System.out.print("Please input the number k such that the target number"
				+ " appears more than 1/k of the size of the array: ");
		int k = sc.nextInt();
		
		int result = majorityNumber(testArray, k);
		System.out.println("The majority number in your given int array is " + result);
	}

}

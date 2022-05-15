package data_structure;

import java.util.HashMap;
import java.util.Map;


/***************************************************************************
* Problem No. : 170
* Problem Name: Two Sum III - Data structure design
* Problem URL : https://leetcode.com/problems/two-sum-iii-data-structure-design/description/
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
* meta        : tag-data-structure
***************************************************************************/

public class TwoSum {

	private Map<Integer, Integer> hash;

	public TwoSum() {
		hash = new HashMap<>();
	}

	public void add(int num) {
		if (!hash.containsKey(num)) {
			int count = 1;
			hash.put(num, count);
		} else {
			hash.put(num, hash.get(num) + 1);
		}
	}

	public boolean find(int target) {
		for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
			int num = entry.getKey();
			int num2 = target - num;
			if (num == num2) {
				if (hash.get(num2) >= 2) {
					return true;
				}
			} else {
				if (hash.containsKey(num2)) {
					return true;
				}
			}
		}
		return false;
	}


	public static void main(String[] args) {
		TwoSum tsd = new TwoSum(); //tsd = two sum data structure
		tsd.add(1);
		tsd.add(7);
		tsd.add(7);
		tsd.add(3);
		tsd.add(8);
		tsd.add(10);

		System.out.println("The result of finding 14 is " + tsd.find(14));
		System.out.println("The result of finding 18 is " + tsd.find(18));
		System.out.println("The result of finding 5 is " + tsd.find(5));

	}
}

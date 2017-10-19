package dataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides Two Sum Data Structure
 * for adding up two numbers in an array to 
 * aim a target number
 * @author Benjamin Lin
 *
 */

public class TwoSumData {
		
	private Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
	
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
		TwoSumData tsd = new TwoSumData();
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

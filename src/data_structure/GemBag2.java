package data_structure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xianlin
 * Based on class GemBag,
 * 	if this time I just want the HashMap to store only <String, double>, which is <color, prob>
 *  Is it possible?
 *  
 * I think so. Then, for each color's newProb
 * 	newProb = oldSum * oldProb / newSum
 * this is the way to avoid storing count, cuz for a color whose count is not changed, 
 * 	count = oldSum * oldProb
 * But I would also argue this way may not be that accurate cuz oldSum * oldProb may not give us an exact integer, 
 * rounding up/down may cause count being one more or less than its original count.
 *
 */

public class GemBag2 {
	
	private Map<String, Double> map;
	private static int sum;
	
	public GemBag2() {
		map = new HashMap<>();
	}
	
	public String get() {
		double d = Math.random();
		System.out.println("The random number we got is: " + d);
		for (String key : map.keySet()) {
			if (d - map.get(key) <= 0) {
				return key;
			}
			d -= map.get(key);
		}
		return null;
	}
	
	public void set(String color, int count) {
		int origSum = sum;
		System.out.println("origSum: " + origSum);
		if (!map.containsKey(color)) {
			sum += count;
		} else {
			sum += count - map.get(color) * origSum;
		}
		
		/* Update current color's prob -- handle the case when map is empty at the beginning */
		map.put(color, (double) count / sum);
		
		for (String key : map.keySet()) {
			if (!key.equals(color)) {
				map.put(key, map.get(key) * origSum / sum);
			} 
		}
	}
	
	public static void test() {
		GemBag2 gb = new GemBag2();
		gb.set("red", 4);
		gb.set("yellow", 1);
		gb.set("pink", 5);
		
		// Test if the current hashMap has the right data
		for (String key : gb.map.keySet()) {
			System.out.println("Color: " + key + ", Probability: " + gb.map.get(key));
		}
		
		// Test get()
		System.out.println(gb.get());
		
		System.out.println();
		System.out.println();
		
		// Set pink to be 15 and test again
		gb.set("pink", 15);
		for (String key : gb.map.keySet()) {
			System.out.println("Color: " + key + ", Probability: " + gb.map.get(key));
		}
		System.out.println(gb.get());
	}
	
	public static void main(String[] args) {
		test();
	}
}
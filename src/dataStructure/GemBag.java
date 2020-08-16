package dataStructure;

import java.util.HashMap;
import java.util.Map;

/***************************************************************************
* Problem No. : NLC 5
* Problem Name: Gem Bag
* Problem URL :
* Date        : Jan 31 2018
* Author      : Xian Lin
* Notes       : 
* 	Scenario: 
* 		Giving you a bag of gems of different colors, and each color has a certain number of gems. 
* 		Implement two methods so I can get a color based on its probability and I can also add a gem properly.
* 	Methods
* 		1. String get() -- please return a color based on its probability 
* 		2. void set(String color, int count) -- note I want this count be the final number of the color after this set
* 	Assumption:
* 		1. You can assume the count argument in the set() method is always a positive integer
	Example:
	Input:
* 		"red": 4
* 		"yellow": 1
* 		"pink": 5
* 	Output:
* 		red has 0.4 prob to be selected, yellow has 0.1 and pink has 0.5.
* 		And if I update pink's count to be 15, then
* 		red has 0.2, yellow has 0.05 and pink has 0.75 probability to be selected.
* Complexity  : 
* 	Time Complexity: See solutions in the code comments
* 	Space Complexity: See solutions in the code comments   
* 
* meta        : tag-data-structure, tag-twosigma
***************************************************************************/
public class GemBag {

	/**
	 * Thinking:
	 * 	Overall, probability of a color = count / sum; where sum is the total number of gems in the bag at this time.
	 */
	class Data {
		int count;
		double prob;
		public Data(int count, double prob) {
			this.count = count;
			this.prob = prob;
		}
	}
	
	private Map<String, Data> map;
	static int sum = 0;
	
	public GemBag() {
		map = new HashMap<>();
	}
	
	/**
	 * When determining which color of a gem should be picked, instead of using accumulative probability,
	 * we can use a generated random number to minus each color's probability. 
	 * Once we get a negative or 0, we return that color.
	 */
	public String get() {
		double randomNum = Math.random();
		System.out.println("The random number we got is: " + randomNum);
		for (String color: map.keySet()) {
			if (randomNum - map.get(color).prob <= 0) {
				return color;
			}
			randomNum -= map.get(color).prob;
		}
		return null; // The return in the if statement above must be executed due to the nature of probability
	}

	/**
	 * @param color The color whose count is gonna be changed
	 * @param count The new finalized count of a color (not an increment count!)
	 *  Assume count is always a positive integer.
	 */
	public void set(String color, int count) {
		// 1st: update sum
		if (!map.containsKey(color)) {
			sum += count;
		} else {
			sum += count - map.get(color).count;
		}
		
		// 2nd: update this color's count and prob
		map.put(color, new Data(count, (double) count / sum));
		
		// 3rd: update other colors' count and prob
		for (String s : map.keySet()) {
			if (!s.equals(color)) {
				map.put(s, new Data(map.get(s).count, (double) map.get(s).count / sum));
			}
		}
	}
	
	public static void test() {
		GemBag gb = new GemBag();
		gb.set("red", 4);
		gb.set("yellow", 1);
		gb.set("pink", 5);
		
		// Test if the current hashMap has the right data
		for (String key : gb.map.keySet()) {
			System.out.println("Color: " + key + ", Count: " + gb.map.get(key).count + ", Probability: " + gb.map.get(key).prob);
		}
		
		// Test get()
		System.out.println(gb.get());
		
		System.out.println();
		System.out.println();
		
		// Set pink to be 15 and test again
		gb.set("pink", 15);
		for (String key : gb.map.keySet()) {
			System.out.println("Color: " + key + ", Count: " + gb.map.get(key).count + ", Probability: " + gb.map.get(key).prob);
		}
		System.out.println(gb.get());
	}
	
	public static void main(String[] args) {
		test();
	}
}
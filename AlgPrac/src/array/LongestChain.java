package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestChain {
	
	public static class Solution {
		public int getLongestChain(String[] words) {
			if (words == null || words.length == 0) {
				return 0;
			}
			int res = 0;
			
			// Sort the words based on their lengths from smaller to larger
			Arrays.sort(words, (s1, s2) -> (s1.length() - s2.length()));
			
			/**
			 * Use a hashmap to store key - word, value - the longest step this word can hold when changing to another word.
			 * Every word is default to have step number to be 1
			 * ie. ba -> a
			 * At the beginning ba has step 1, a has step 1.
			 * Then after removing b from ba, we get a;
			 * a is already in the map, so we increment b's step number to be 2.
			 * We return 2 (the longest chain) at the end.
			 */
			Map<String, Integer> map = new HashMap<>();
			
			for (String word :words) {
				if (map.containsKey(word)) {
					continue;
				}
				map.put(word, 1);
				for (int i = 0; i < word.length(); i++) {
					StringBuilder sb = new StringBuilder(word);
					sb.deleteCharAt(i);
					String newWord = sb.toString();
					if (map.containsKey(newWord) && map.get(newWord) + 1 > map.get(word)) {
						map.put(word, map.get(newWord) + 1);
					}
				}
				res = Math.max(res, map.get(word));
			}
			return res;
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] words = new String[]{"bdca", "bda", "bca", "ba", "b", "a"};
		System.out.println("The longest chain for the given words is: " + sol.getLongestChain(words)); // should return 4
		words = new String[] {"ba", "b"};
		System.out.println("The longest chain for the given words is: " + sol.getLongestChain(words)); // should return 2
		words = new String[] {"fc", "bc"};
		System.out.println("The longest chain for the given words is: " + sol.getLongestChain(words)); // should return 1
	}
}

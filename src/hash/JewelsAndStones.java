package hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***************************************************************************
* Problem No. : 771
* Problem Name: Jewels and Stones
* Problem URL : https://leetcode.com/problems/jewels-and-stones/
* Date        : March 20 2020
* Author      :	@codingbro
* Notes       :
* 	Scenario:
* 		@needOrganize
* 	Assumption:
*
	Example:
* 	Input/Output:
*
* 	Data Structure and Alg:
* 		See solutions in the code comments
* Complexity  :
* 	Time Complexity: See solutions in the code comments
* 	Space Complexity: See solutions in the code comments
*
* meta        : tag-hash
***************************************************************************/

public class JewelsAndStones {

	class Solution1 {
		public int numJewelsInStones(String J, String S) {
			if (J.length() == 0) {
				return 0;
			}

			int count = 0;
			List<Character> jewelTypes = new ArrayList<>();
			for (int i = 0; i < J.length(); i++) {
				jewelTypes.add(J.charAt(i));
			}
			for (int i = 0; i < S.length(); i++) {
				if (jewelTypes.contains(S.charAt(i))) {
					count++;
				}
			}
			return count;
		}
	}

	class Solution2 {
		public int numJewelsInStones(String J, String S) {
			if (J.length() == 0) {
				return 0;
			}

			int count = 0;
			Set<Character> jewelTypes = new HashSet<>();
			for (char c : J.toCharArray()) {
				jewelTypes.add(c);
			}
			for (char c : S.toCharArray()) {
				if (jewelTypes.contains(c)) {
					count++;
				}
			}
			return count;
		}
	}
}

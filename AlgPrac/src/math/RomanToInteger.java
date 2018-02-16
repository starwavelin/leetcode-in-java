package math;

/**
 * A very cultural dependent question. 
 * 
 * Firstly, we need to know:
 * 罗马字符 与 阿拉伯数字对应关系
 * I - 1， V - 5， X - 10， L - 50， C - 100， D - 500， M - 1000。
 * 	
 * Assumption: 	
 * 	1. The input string is a Roman numeral guaranteed. 
 *  2. The range of the output integer will be between 1 and 3999. 
 *  
 * meta        : tag-math, tag-hash
 */
public class RomanToInteger {
	
	/**
	 * Idea:
	 * 只有 I，X，C，有可能带来负数累加 -1, -10, -100；其余都是带来正数累加。
	 * 我们分类搞清楚什么情况下 累加多少，就可以了。
	 * 为了正确handle累加负数的情况，我们选择从右向左扫描input string
	 */
	public static class Solution {
		public int romanToInt(String s) {
	        if (s == null || s.length() == 0) {
	            return 0;
	        }
	        
	        int res = 0;
	        for (int i = s.length() - 1; i >= 0; i--) {
	            switch(s.charAt(i)) {
	                case 'I':  
	                    res += (res >= 5) ? -1 : 1;
	                    break;
	                case 'V':  
	                    res += 5;
	                    break;
	                case 'X':  
	                    res += (res >= 50) ? -10: 10;
	                    break;
	                case 'L':  
	                    res += 50;
	                    break;
	                case 'C':  
	                    res += (res >= 500) ? -100: 100;
	                    break;
	                case 'D':  
	                    res += 500;
	                    break;
	                case 'M':  
	                    res += 1000;
	                    break;
	                default:
	                    res += 0;
	                    break;
	            }
	        }
	        return res;
	    }
	}
	
	/**
	 * Based on Solution 1, we use the concept of hashmap to do the mapping between each 
	 * character and value, then just need to handle the 3 special cases.
	 * This solution avoids the lengthy case statements.
	 * @author xianlin
	 *
	 */
	public static class Solution2 {
		public int romanToInt(String s) {
			int res = 0; 
			if (s == null || s.length() == 0) {
				return res;
			}
			String str = "IVXLCDM";
			int[] values = new int[] {1, 5, 10, 50, 100, 500, 1000};
			for (int i = s.length() - 1; i >= 0; i--) {
				if (s.charAt(i) == 'I' && res >= 5) {
	                res += -values[str.indexOf('I')];
	            } else if (s.charAt(i) == 'X' && res >= 50) {
	                res += -values[str.indexOf('X')];
	            } else if (s.charAt(i) == 'C' && res >= 500) {
	                res += -values[str.indexOf('C')];
	            } else {
	                res += values[str.indexOf(s.charAt(i))];
	            }
			}
			return res;
		}
	}
	
	public static void main(String[] args) {
		
	}
}

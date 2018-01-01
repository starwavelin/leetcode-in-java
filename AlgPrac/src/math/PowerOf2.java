package math;

public class PowerOf2 {

	/**
	 * Sol 1: while loop do mod and division
	 * Time Complexity: O(log_b(n))
	 * Space Complexity: O(1)
	 */
	public static class SC1 {
		public boolean isPowerOfTwo(int n) {
			if (n > 1) {
				while (n % 2 == 0) {
					n /= 2;
				}
			}
			return n == 1;
		}
	}
	
	/**
	 * Sol 2: Base Change Formula
	 * If n is power of 2, then 2^x = n -> xlog_10(2) = log_10(n) -> x = log_10(n) / log_10(2)
	 * We can test if x is an integer to determine if n is power of 2.
	 * 
	 * Time Complexity: depends on the complexity of Math.log10() calculation
	 * Space Complexity: O(1)
	 */
	public static class SC2 {
		public boolean isPowerOfTwo(int n) {
			return (n > 0) && (Math.log10(n) / Math.log10(2)) % 1 == 0;
		}
	}
	
	/**
	 * Solution 3: Bit Manipulation Strategy. (n & (n - 1)) trick.
	 * 2 in binary is 10, 4 in binary is 100, 8 in binary is 100.
	 * So any power of two will have 10...0
	 * any power of two minus 1 will be 01...1
	 * So if we AND the power of two and the power of two minus 1, we must get 0
	 */
	public static class SC3 {
		public boolean isPowerOfTwo(int n) {
			if (n <= 0) {
				return false;
			}
			return  (n & (n - 1)) == 0 ? true : false;
		}
	}
	
	public static void main(String[] args) {
		SC1 sc1 = new SC1();
		SC2 sc2 = new SC2();
		SC3 sc3 = new SC3();
		int n1 = -1, n2 = 2, n3 = 6, n4 = 8;
		System.out.println("Is power of 2? " + sc1.isPowerOfTwo(n1) + " " + sc1.isPowerOfTwo(n2) 
			+ " " + sc1.isPowerOfTwo(n3) + " " + sc1.isPowerOfTwo(n4)); // false, true, false, true
		System.out.println("Is power of 2? " + sc2.isPowerOfTwo(n1) + " " + sc2.isPowerOfTwo(n2) 
		+ " " + sc2.isPowerOfTwo(n3) + " " + sc2.isPowerOfTwo(n4)); // false, true, false, true
		System.out.println("Is power of 2? " + sc3.isPowerOfTwo(n1) + " " + sc3.isPowerOfTwo(n2) 
		+ " " + sc3.isPowerOfTwo(n3) + " " + sc3.isPowerOfTwo(n4)); // false, true, false, true
	}
}

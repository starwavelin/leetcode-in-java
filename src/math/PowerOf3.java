package math;

public class PowerOf3 {
	/**
	 * Sol 1: while loop do mod and division
	 * Time Complexity: O(log_b(n)) -- here is O(log_3(n))
	 * Space Complexity: O(1)
	 */
	public static class SC1 {
		public boolean isPowerOfThree(int n) {
			if (n > 1) {
				while (n % 3 == 0) {
					n /= 3;
				}
			}
			return n == 1;
		}
	}
	
	/**
	 * Sol 2: Base Change Formula
	 * If n is power of 3, then 3^x = n -> xlog_10(3) = log_10(n) -> x = log_10(n) / log_10(3)
	 * We can test if x is an integer to determine if n is power of 3.
	 * 
	 * Time Complexity: depends on the complexity of Math.log10() calculation
	 * Space Complexity: O(1)
	 */
	public static class SC2 {
		public boolean isPowerOfThree(int n) {
			return (n > 0) && (Math.log10(n) / Math.log10(3)) % 1 == 0;
		}
	}
	
	public static void main(String[] args) {
		SC1 sc1 = new SC1();
		SC2 sc2 = new SC2();
		int n1 = -3, n2 = 3, n3 = 6, n4 = 9;
		System.out.println("Is power of 3? " + sc1.isPowerOfThree(n1) + " " + sc1.isPowerOfThree(n2) 
			+ " " + sc1.isPowerOfThree(n3) + " " + sc1.isPowerOfThree(n4)); // false, true, false, true
		System.out.println("Is power of 3? " + sc2.isPowerOfThree(n1) + " " + sc2.isPowerOfThree(n2) 
		+ " " + sc2.isPowerOfThree(n3) + " " + sc2.isPowerOfThree(n4)); // false, true, false, true
	}
}

package hash;

import java.math.BigInteger;
import java.util.Scanner;

public class HashCode {
	
	private static final int HASH_SIZE = 1007;
	
	/**
	 * hashCode1 method, where long is enough to solve the input char[]
	 * Deprecated. For the reason, see hashCode2() !!!
	 * @param key
	 * @param HASH_SIZE
	 * @return
	 */
	public static int hashCode1(char[] key, int HASH_SIZE) {
		int size = key.length;
		long sum = 0;
		for (int i = 0; i < size; i++) {
			sum += key[i] * Math.pow(33, size-1-i);
		}
		return (int) (sum % HASH_SIZE);
	}
	
	/**
	 * hashCode2 method deals better than hashCode1 in overflow issue, 
	 * where
	 * we utilize the property of modular multiplication/addition
	 * (a + b) % p = (a % p + b % p) % p
	 * (a * b) % p = (a % p * b % p) % p
	 * a ^ b % p = ((a % p)^b) % p
	 * 
	 * but, hashCode3 deals better than hashCode2, for instance, a char[] like
	 * "abcdefghijklmnopqrstuvwxyz" cannot be solved by hashCode2
	 */
	public static int hashCode2(char[] key, int HASH_SIZE) {
		int size = key.length;
		long sum = 0;
		for (int i = 0; i < size; i++) {
			sum += key[i] * Math.pow(33, size-1-i) % HASH_SIZE;
		}
		return (int) (sum % HASH_SIZE);
	}
	
	/**
	 * hashCode3 uses modMultiplication to deal with the
	 * exponent of 33 overflow issue.
	 * So, we don't use Math.pow(33, exp) directly.
	 * @param key
	 * @param HASH_SIZE
	 * @return
	 */
	public static int hashCode3(char[] key, int HASH_SIZE) {
		int ret = 0;
		int base = 1;
		for (int i = key.length - 1; i >=0; i--) {
			ret += modMultiply(key[i], base, HASH_SIZE);
			ret %= HASH_SIZE;
			base = modMultiply(base, 33, HASH_SIZE);
		}
		return ret % HASH_SIZE;
	}
	private static int modMultiply(int a, int b, int c) {
		long tmp = (long) a * b;
		return (int) (tmp % c);
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's HashCode Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your String, I will convert it to char[]: ");
		String s = sc.next();
		char[] key = new char[s.length()];
		for (int i = 0; i < key.length; i++) {
			key[i] = s.charAt(i);
		}
		
		int ret = hashCode3(key, HASH_SIZE);
		System.out.print("Your input String " + s + " has hash code value " + ret);
	}
	
}

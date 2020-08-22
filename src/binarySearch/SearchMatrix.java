package binarySearch;

import java.util.Scanner;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 1. Integers in each row are sorted from left to right.
 * 2. The first integer of each row is greater than the last integer of the previous row.
 * http://www.lintcode.com/en/problem/search-a-2d-matrix/
 */
public class SearchMatrix {
	
	/**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
    		int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        
        int start = 0, end = m * n - 1, mid, rowNum, colNum;
        while (start + 1 < end) {
            mid = (start + end) >> 1;
            rowNum = mid / n;
            colNum = mid % n;
            if (matrix[rowNum][colNum] == target) {
                return true;
            } else if (matrix[rowNum][colNum] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[start / n][start % n] == target || matrix[end / n][end % n] == target) {
            return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Search Matrix Test ***");
		
		int[][] matrix = new int[][] {
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Give your target number: ");
		int target = sc.nextInt();
		
		boolean ret = searchMatrix(matrix, target);
		if (ret) {
			System.out.println("The target number " + target + " is in the input matrix." );
		} else {
			System.out.println("The target number " + target + " is NOT in the input matrix." );
		}
	}
}

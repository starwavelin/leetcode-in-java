package binary_search;

import java.util.Scanner;
/**
 * Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
 * This matrix has the following properties:
    * Integers in each row are sorted from left to right.
    * Integers in each column are sorted from up to bottom.
    * No duplicate integers in each row or column.
 *
 */
public class SearchMatrix2 {
	/**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public static int searchMatrix(int[][] matrix, int target) {
        // Idea: From the lower left corner, move either to the right or up to find target
    		// O(n + m)
    		int count = 0;
        int m = matrix.length;
        if (m == 0) {
            return count;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return count;
        }
        
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                count++;
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Search Matrix II Test ***");
		
		int[][] matrix = new int[][] {
				{0, 1, 2, 4},
				{1, 2, 5, 7},
				{3, 5, 7, 10},
				{7, 8, 9, 11}
		};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Give your target number: ");
		int target = sc.nextInt();

		int ret = searchMatrix(matrix, target);
		System.out.println("The target number " + target + 
					" occurred in the matrix " + ret + " time(s)");
	}
}

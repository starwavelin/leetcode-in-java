package binarySearchSortedArray;

import java.util.Scanner;

/**
 * 
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
        // idea: binary search to compare the pos 0 of each row to determine in which row the target should be
    	// then, on that particular row, run binary search again.
    	if (matrix == null || matrix.length == 0 || matrix[0][0] > target) {
    		return false;
    	}
    	int numCols = matrix[0].length;
		int numRows = matrix.length;
    	
		int start, end, mid, targetRow, targetCol;
		start = 0;
		end = numRows - 1;
		targetRow = targetCol = 0;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (matrix[mid][0] == target) {
				return true;
			} else if (matrix[mid][0] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (matrix[start][0] > target) {
			targetRow = start - 1;
		} else if (matrix[end][0] > target) {
			targetRow = end - 1;
		} else {
			targetRow = end;
		}
		
		int[] arr = matrix[targetRow];
		start = 0; 
		end = arr.length - 1;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == target) {
				return true;
			} else if (arr[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (arr[start] == target) {
			return true;
		} else if (arr[end] == target) {
			return true;
		}
		
		return false;
    }
    
    
    public static boolean searchMatrixII(int[][] matrix, int target) {
    	boolean flag = false; 
    	return flag;
    }
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Search Matrix Test ***");
		
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

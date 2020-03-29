package dp;

/**
 * http://www.lintcode.com/en/problem/triangle
 * 
 * Use dfs to recursively get the minSum;
 * The time complexity of this solution is O(3^n).
 * 
 * You can see the time complexity by using 
 * dfs recursion is so large, we have try 
 * to use dynamic programming to solve it. 
 * 
 * See Triangle.java
 */

public class TriangleRec {
	
	int minSum;
	int[][] tri;
	int level;
	
	public TriangleRec() {
		minSum = Integer.MAX_VALUE;
		
		/* MODIFY HERE: 
		 * tri is the test case and you can modify it. */
//		tri = new int[][] {
//				{2},
//				{4, 3}
//		};
		
		tri = new int[][] {
				{2},
				{4, 3},
				{5, 6, 7},
				{4, 1, 8, 3}
		};	// minPathSum should be 11
		
		level = tri.length;
	}
	
	
	
	// Row Number is from 0 to n-1; Col's boundary is equal to Row Number
	/**
	 * @param x: the row number
	 * @param y: the col number
	 * @param sum: the intermediate sum
	 * @param tri: the given triangle passed into this method
	 */
	private void dfs(int x, int y, int sum, int level) {
		if (x == level) {
			if (sum < minSum) {
				minSum = sum;
			}
			return;
		}
		
		if (x < level && y >= 0 && y <= x) {
			dfs(x + 1, y, sum + tri[x][y], level);
			dfs(x + 1, y - 1, sum + tri[x][y], level);
			dfs(x + 1, y + 1, sum + tri[x][y], level);
		}
		
		// Time complexity: 
		// Think like this, from each node (integer cell) going downwardly, you 
		// have 3 choices to pick the next node (including the possible null one). 
		// And there are n levels of nodes. So, how many different paths you can choose?
		// Answer: 3^n
	}	
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Triangle (Minimum Path Sum) Test "
				+ "using Recursion ***");

		TriangleRec tr = new TriangleRec();
		
		//System.out.println("tri[0][0] is " + tri[0][0]);
		//System.out.println("tri[0][1] is " + tri[0][1]); array index out of bound
		
		tr.dfs(0, 0, 0, tr.level);
		System.out.println("The minimum path sum from the given triangle is " + tr.minSum);
	}
}

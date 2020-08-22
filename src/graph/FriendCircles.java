package graph;

/***************************************************************************
* Problem No. : 547
* Problem Name: Friend Circles
* Problem URL : https://leetcode.com/problems/friend-circles/description/
* Date        : Dec 30 2017
* Author      : @codingbro
* Notes       : 
* 	Scenario: 
* 		Given a matrix M of n*n representing the friendship of n students in a class. 
* 		And we define the friendship are transitive. 
* 		Find out the number of friend circles in this class. 
* 	Assumption:
* 		1. N is in range [1, 200]
* 		2. M[i][i] = 1 for all students
* 		3. if M[i][j] = 1, then M[j][i] = 1 as well
	Example: 
* 	Input: 
* 	Output: 
* 		
* 	Data Structure and Alg:
* 		See Code Comments  
* Complexity  : 
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
* 
* meta        : tag-graph, tag-twosigma
***************************************************************************/
public class FriendCircles {
	/**	 
	 * Solution 1: using DFS
	 */
	public static class FC1 {
		public int findCircleNum(int[][] M) {
			int n = M.length;
			if (n == 0) {
				return 0;
			}
			int res = 0;
			boolean[] visited = new boolean[n];
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					dfs(M, visited, i, n);
					res++;
				}
			}
			return res;
		}
		
		private void dfs(int[][] M, boolean[] visited, int i, int n) {
			for (int j = 0; j < n; j++) {
				if (M[i][j] == 1 && !visited[j]) {
					visited[j] = true; //dye
					dfs(M, visited, j, n);
				}
			}
		}
	}
	
	/**
	 * Solution 2: Using Union Find
	 */
	public static class FC2 {
		public int findCircleNum(int[][] M) {
			int n = M.length;
			if (n == 0) {
				return 0;
			}
			UnionFind1 uf = new UnionFind1(n);
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (M[i][j] == 1) {
						uf.union(i, j);
					}
				}
			}
			return uf.count();
		}
	}
	
	public static void main(String[] args) {
		int[][] M1 = new int[][] {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
		int[][] M2 = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		FC1 fc1 = new FC1();
		System.out.println("Number of Friend Circles for M1: " + fc1.findCircleNum(M1)); //should return 1
		System.out.println("Number of Friend Circles for M1: " + fc1.findCircleNum(M2)); //should return 2
		
		FC2 fc2 = new FC2();
		System.out.println("Number of Friend Circles for M1: " + fc2.findCircleNum(M1)); //should return 1
		System.out.println("Number of Friend Circles for M1: " + fc2.findCircleNum(M2)); //should return 2
	}
}

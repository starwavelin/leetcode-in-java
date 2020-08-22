package graph;

import java.util.ArrayList;
import java.util.List;
/***************************************************************************
* Problem No. : 417
* Problem Name: Pacific Atlantic Water Flow
* Problem URL : https://leetcode.com/problems/pacific-atlantic-water-flow/description/
* Date        : Jan 18 2018
* Author      : @codingbro
* Notes       :
* 	Scenario:
* 		mxn二维非负矩阵记录了水的高度，水可以从上下左右四个方向流向等高的或低于当前水位的格子。
* 		A大洋位于矩阵的上边和左边，B大洋位于矩阵的下边和右边。求所有的能同时流向A和B大洋的点的坐标。
* 	Assumption:
*
	Example:
* 	Input:
*
* 	Output:
*
*
* 	Data Structure and Alg:
* 		See Code Comments
* Complexity  :
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
*
* meta        : tag-graph, tag-bfs, tag-dfs
****************************************************************************/
public class PacificAtlanticWaterFlow {

	public static class DFSSol {
		public List<int[]> pacificAtlantic(int[][] matrix) {
			List<int[]> res = new ArrayList<>();
			int m = matrix.length;
			if (m == 0) {
				return res;
			}
			int n = matrix[0].length;
			boolean[][] pacific = new boolean[m][n];
			boolean[][] atlantic = new boolean[m][n];

			for (int i = 0; i < m; i++) {
				dfs(matrix, pacific, Integer.MIN_VALUE, i, 0); // left border
				dfs(matrix, atlantic, Integer.MIN_VALUE, i, n - 1); // right border
			}
			for (int j = 0; j < n; j++) {
				dfs(matrix, pacific, Integer.MIN_VALUE, 0, j); // top border
				dfs(matrix, atlantic, Integer.MIN_VALUE, m - 1, j); // bottom border
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (pacific[i][j] && atlantic[i][j]) {
						res.add(new int[]{i, j});
					}
				}
			}
			return res;
		}

		private void dfs(int[][] matrix, boolean[][] visited, int pre, int row, int col) {
			int m = matrix.length;
			int n = matrix[0].length;
			if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || matrix[row][col] < pre) {
				return;
			}

			visited[row][col] = true;
			int[] dx = new int[]{-1, 1, 0, 0};
			int[] dy = new int[]{0, 0, -1, 1};
			for (int i = 0; i < 4; i++) {
				int rowNum = row + dx[i];
				int colNum = col + dy[i];
				dfs(matrix, visited, matrix[row][col], rowNum, colNum);
			}
		}
	}


	public static void main(String[] args) {

	}
}

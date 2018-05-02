package graph;

import java.util.ArrayDeque;
import java.util.Queue;

/***************************************************************************
* Problem No. : 130
* Problem Name: Surrounded Regions
* Problem URL :
* Date        : Jan 17 2018
* Author      :	Xian Lin
* Notes       :
* 	Scenario:
*
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
***************************************************************************/
public class SurroundedRegions {
	/**
	 * 思路：思路同200. Number of Islands 是用染色法。只是这题要求OOO部分完全被X包围才算全部染为X。
	 * 假如OOO部分有贴于二维数组边界的，如题中例子左下角的O，那么它就不能被染成X。
	 *
	 * 所以方法是扫两遍二维矩阵。第一遍先找到所有贴边的O，用DFS或BFS将与贴边的O相连的所有O都标为“A”。而后全局扫描，将所有的A还原成O，所有的O标为X.
	 */

	public static class DFSSol {
    public void solve(char[][] board) {
			int m = board.length;
			if (m == 0) {
				return;
			}
			int n = board[0].length;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
						dfs(board, i, j, m, n);
					}
				}
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 'O') {
						board[i][j] = 'X';
					} else if (board[i][j] == 'A') {
						board[i][j] = 'O';
					}
				}
			}
		}

		private void dfs(char[][] board, int row, int col, int m, int n) {
			board[row][col] = 'A';
			int[] dx = new int[]{-1, 1, 0, 0};
			int[] dy = new int[]{0, 0, -1, 1};
			for (int i = 0; i < 4; i++) {
				int rowNum = row + dx[i];
				int colNum = col + dy[i];
				if (rowNum >= 0 && rowNum < m && colNum >= 0 && colNum < n && board[rowNum][colNum] == 'O') {
					dfs(board, rowNum, colNum, m, n);
				}
			}
		}
	}

	public static class BFSSol {
		public void solve(char[][] board) {
			int m = board.length;
			if (m == 0) {
				return;
			}
			int n = board[0].length;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
						bfs(board, i, j, m, n);
					}
				}
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 'O') {
						board[i][j] = 'X';
					} else if (board[i][j] == 'A') {
						board[i][j] = 'O';
					}
				}
			}
		}

		private void bfs(char[][] board, int row, int col, int m, int n) {
			board[row][col] = 'A';
			int[] dx = new int[]{-1, 1, 0, 0};
			int[] dy = new int[]{0, 0, -1, 1};
			Queue<Integer> q = new ArrayDeque<>();
			int pos = row * n + col;
			q.offer(pos);
			while (!q.isEmpty()) {
				pos = q.poll();
				for (int i = 0; i < 4; i++) {
					int rowNum = pos / n + dx[i];
					int colNum = pos % n + dy[i];
					if (rowNum >= 0 && rowNum < m && colNum >= 0 && colNum < n && board[rowNum][colNum] == 'O') {
						board[rowNum][colNum] = 'A';
						q.offer(rowNum * n + colNum);
					}
				}
			}
		}
	}

	public static void main(String[] args) {

	}
}

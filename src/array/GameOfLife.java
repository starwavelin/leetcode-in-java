package array;
/***************************************************************************
* Problem No. : 289
* Problem Name: Game of Life
* Problem URL : https://leetcode.com/problems/game-of-life/description/
* Date        : Jan 1 2018
* Author	      : @codingbro
* Notes       : 
* 	Scenario: 
* 		
* 	Assumption:
* 		1. 
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
* meta        : tag-array
***************************************************************************/
public class GameOfLife {
	
	/**
	 * 细胞自动机，每一个位置有两种状态，1为活细胞，0为死细胞，对于每个位置都满足如下的条件：

		1. 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡

		2. 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活

		3. 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡

		4. 如果死细胞周围正好有三个活细胞，则该位置死细胞复活
		
		我们只能更新原有数组，但是题目中要求所有的位置必须被同时更新，但是在循环程序中我们还是一个位置一个位置更新的，
		那么当一个位置更新了，这个位置成为其他位置的neighbor时，我们怎么知道其未更新的状态呢，我们可以使用状态机转换：

		状态0： 死细胞转为死细胞
		
		状态1： 活细胞转为活细胞
		
		状态2： 活细胞转为死细胞
		
		状态3： 死细胞转为活细胞
		
		最后我们对所有状态对2取余，那么状态0和2就变成死细胞，状态1和3就是活细胞，达成目的。
	 */
	
	public static class Solution {
		public void gameOfLife(int[][] board) {
	        int m = board.length;
	        if (m == 0) {
	            return;
	        }
	        int n = board[0].length;
	        int[] dx = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
	        int[] dy = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                int count = 0;
	                for (int k = 0; k < 8; k++) {
	                    int x = i + dx[k], y = j + dy[k]; // be careful row x ~ i and col y ~ j
	                    if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] == 1 || board[x][y] == 2)) {
	                        count++;
	                    }
	                }
	                if (board[i][j] == 1 && (count < 2 || count > 3)) {
	                    board[i][j] = 2;
	                } else if (board[i][j] == 0 && count == 3) {
	                    board[i][j] = 3;
	                }
	            }
	        }
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                board[i][j] %= 2;
	            }
	        }
	    }
	}
}

package graph;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
        // m - num of rows; n - num of columns
        int m = grid.length; 
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j, m, n); //dye
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid, int row, int col, int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int rowNum = row + dx[i];
            int colNum = col + dy[i];
            dfs(grid, rowNum, colNum, m, n);
        }
    }
}

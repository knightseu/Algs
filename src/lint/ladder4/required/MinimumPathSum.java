package lint.ladder4.required;
/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Have you met this question in a real interview? Yes
Example
Note
You can only move either down or right at any point in time.

 * @author xuanlin
 *
 */
public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * 1.State: f[i][j], the min to (i, j) from top left
	 * 2.Function:  f[i][j] = min(f[i-1][j] , f[i][j-1]) + grid[i][j];
	 * 3.initial: f[0][j] = f[0][j-1]+grid[0][j], f[i][0] = f[i-1][0] + grid[i][0]
	 * 4.goal: f[n-1][m-1]  
	 */
	
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
    	if (grid == null) {
    		return 0;
    	}
        int row = grid.length;
        int col = grid[0].length;
        int [][]path = new int[row][col];
        path[0][0] = grid[0][0];
        for (int i=1; i< row; i++) {
        	path[i][0] = path[i-1][0] + grid[i][0];
        }
        for (int i=1; i< col; i++) {
        	path[0][i] = path[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
        	for (int j = 1; j < col; j++) {
        		path[i][j] = Math.min(path[i-1][j], path[i][j-1]) + grid[i][j];
        	}
        }
        return path[row - 1][col -1];
    }

}

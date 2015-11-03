package lint.ladder4.required;
/*
 * Easy Unique Paths

35% Accepted
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Have you met this question in a real interview? Yes
Example
1,1
1,2
1,3
1,4
1,5
1,6
1,7
2,1






3,1





3,7

Above is a 3 x 7 grid. How many possible unique paths are there?
 */
public class UniquePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int uniquePaths(int m, int n) {
        int [][] path = new int[m][n];
        for (int i = 0; i < m; i++) {
        	path[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
        	path[0][i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		path[i][j] = path[i-1][j] + path[i][j-1];
        	}
        }
        return path[m-1][n-1];
    }

}

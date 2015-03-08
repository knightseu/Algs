package lc.solutions;
/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

 */
public class SearchMatrix {
	/*
	 * 1. try to convert to a 1 D array
	 * 2. the way to get x, y
	 * 3. boundary check for len
	 */
    public boolean searchMatrix(int[][] matrix, int target) {
    	int xLen = matrix[0].length, yLen = matrix.length;
    	if (xLen==0 || yLen ==0) return false;
    	
    	int min = 0, max = xLen*yLen-1, x,y,cur;
    	while (min<=max) {
    		cur = (min+max)/2;
    		y = cur/xLen;
    		x = cur%xLen;
    		if (matrix[y][x] == target) {
    			return true;
    		}
    		else if (matrix[y][x]> target) {
    			max = cur-1;
    		}
    		else {
    			min = cur+1;
    		}
    	}
        return false;
    }
}

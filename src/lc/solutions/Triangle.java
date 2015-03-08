package lc.solutions;

import java.util.ArrayList;

public class Triangle {
/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
 */
	
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	return minTriPath(triangle,0,0);
    }
    
    public int minTriPath(ArrayList<ArrayList<Integer>> triangle, int row, int index){
    	if (row == triangle.size() -1) return triangle.get(row).get(index);
    	return Math.min(minTriPath(triangle, row+1, index), minTriPath(triangle, row+1, index+1)) + triangle.get(row).get(index);
    }
}

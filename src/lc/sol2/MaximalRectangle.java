package lc.sol2;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * @author xuanlin
 * ref:
 *     1.http://huntfor.iteye.com/blog/2086892
 *     2.M*M*N -https://leetcodenotes.wordpress.com/2013/10/19/leetcode-maximal-rectangle-0101%E7%BB%84%E6%88%90%E7%9A%84%E7%9F%A9%E9%98%B5%EF%BC%8C%E6%B1%82%E9%87%8C%E9%9D%A2%E5%85%A8%E6%98%AF1%E7%9A%84%E7%9F%A9%E5%BD%A2%E7%9A%84%E6%9C%80%E5%A4%A7%E9%9D%A2/
 */
public class MaximalRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maximalRectangle(char[][] matrix) {
    	int row = matrix.length;
    	int col = matrix[0].length;
    	
    	int[][] heights = new int[row][col];
    	int count =0;
    	//build the height histo
    	for (int i=0; i<row; i++) {
    		for (int j=0; j<col;j++) {
    			if (i == 0) {
    				heights[i][j] = matrix[i][j];
    			} else {
    				if (matrix[i][j] == 1) {
    				    heights[i][j] =  heights[i][j-1] + 1;
    				} else {
    					heights[i][j] = 0;
    				}
    			}
    		}
    	}
    	
    	//
    	int rst = 0;
    	for (int k = 0; k < row; k++) {
    		int cur = largestRectangleArea(heights[k]);
    		if (cur > rst) {
    			rst = cur;
    		}
    	}
        return  rst;
    }
    
    public  static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int[] copy = new int[height.length + 1];
		copy = Arrays.copyOf(height, height.length + 1);
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int curIndex = 0; 
		while (curIndex < copy.length) {
			/*
			 * 1. if R(m,n) is the max, then height(m) must be greater than height(m-1), otherwise, R(m-1, n) > R(m,n)
			 * 2. if R(m,n) is the max, then height(n) must be greater than height(n+1), otherwise, R(m, n+1) > R(m,n)
			 * 
			 * Thus, we need stack to keep an increasing series
			 */
			
			if (stack.isEmpty() || copy[stack.peek()] <= copy[curIndex]) {
				stack.push(curIndex++);
			} else {
				int num = stack.pop();
				//cur Area = distance between curIndex and num * copy[num]
				maxArea = Math.max(maxArea, copy[num] * (stack.isEmpty() ? curIndex : curIndex - stack.peek() - 1));
			}
		}
		return maxArea;
	}

}

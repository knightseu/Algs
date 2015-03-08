package lc.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5]. 
 * @author xuanlin
 *
 */
public class SpiralMatrix {
	/*
	 * 1. boundary check for matrix length
	 * 2. set the correct value for right and bottom.
	 */
     public List<Integer> spiralOrder(int[][] matrix) {
    	 ArrayList<Integer> rst = new ArrayList<Integer>();
    	 if (matrix.length==0) return rst;
         if (matrix[0].length==0) return rst;
         int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
         while (left<right && top<bottom) {
         	//1.l-r
         	for (int i=left; i<right; i++)
         		rst.add(matrix[top][i]);
         	//2.t-b
         	for (int i=top; i<bottom; i++)
         		rst.add(matrix[i][right]);
         	//3.r-l
         	for (int i=right; i>left; i--)
         		rst.add(matrix[bottom][i]);
         	//4.b-t
         	for (int i=bottom; i>top; i--)
         		rst.add(matrix[i][left]);
         	
         	left++;
         	right--;
         	top++;
         	bottom--;
         }
         return rst;
    }
}

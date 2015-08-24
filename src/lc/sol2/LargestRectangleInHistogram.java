package lc.sol2;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * @author xuanlin
 * ref: 
 *      1.http://zhangzhibiao02005.blog.163.com/blog/static/3736782020118433623459/
 *      2.http://huntfor.iteye.com/blog/2086456
 */
public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 =  {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(a1));
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

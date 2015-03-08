package lc.solutions;
/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container. 
 */
public class LC011_ContainerWithMostWater {
	/*
	 * he idea is : to compute area, we need to take min(height[i],height[j]) as our height. 
	 * Thus if height[i]<height[j], then the expression min(height[i],height[j]) will always lead to at maximum height[i] for all other j(i being fixed), 
	 * hence no point checking them. 
	 * Similarly when height[i]>height[j] then all the other i's can be ignored for that particular j.
	 */
    public int maxArea(int[] height) {
    	if (null == height || height.length < 2) 
    		return 0;
        int max = 0;
        int left = 0, right = height.length -1;
        while (left < right) {
        	max = Math.max(max, (right-left) * Math.min(height[left], height[right]) );
        	if (height[left] < height[right])
        		left++;
        	else
        		right--;
        }
        return max;
    }
}

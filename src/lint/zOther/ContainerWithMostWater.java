package lint.zOther;

/**
 * Created by xuanlin on 2/26/17.
 *
 * http://www.lintcode.com/en/problem/container-with-most-water/
 * http://www.jiuzhang.com/solutions/container-with-most-water/
 *
 * http://blog.csdn.net/ggmfengyangdi/article/details/52034064
 * http://www.debugrun.com/a/bkrH6MY.html
 */
public class ContainerWithMostWater {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if (null == heights || heights.length < 2) {
            return 0;
        }
        int left = 0;
        int right = heights.length - 1;
        int rst = 0;
        while (left < right) {
            rst = Math.max(rst, (right - left) * Math.min(heights[left], heights[right]));
            if (heights[left] < heights[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return rst;
    }
}

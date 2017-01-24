package lint.ad_ladder1;
import java.util.Arrays;

/**
 * Created by xuan on 1/21/17.
 */
public class TwoSumII {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // Write your code here
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int rst = 0;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                rst += right - left;
                right --;
            }
            else {
                left ++;
            }
        }
        return rst;
    }
}

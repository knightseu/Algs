package lint.ladder7;

/**
 * Created by xuanlin on 2/25/17.
 * 609
 * http://www.lintcode.com/en/problem/two-sum-less-than-or-equal-to-target/
 *
 */
import java.util.Arrays;
public class TwoSumLessOrEqual {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length < 2)
            return 0;

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        int rst = 0;
        while (left < right) {
            int v = nums[left] + nums[right];
            if (v > target) {
                right--;
            }
            else {
                // This is the key
                rst += right - left;
                left++;
            }
        }
        return rst;

    }
}

/*
Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number. Please return the number of pairs.

Have you met this question in a real interview? Yes
Example
Given nums = [2, 7, 11, 15], target = 24.
Return 5.
2 + 7 < 24
2 + 11 < 24
2 + 15 < 24
7 + 11 < 24
7 + 15 < 25
 */
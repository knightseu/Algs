package lint.ladder2.required;

/**
 * Created by xuan on 1/22/17.
 */
public class LastPosition {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int lastPosition(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            System.out.println(mid);
            if (nums[mid] < target) {
                start = mid + 1;
            }
            if (nums[mid] <= target) {
                start = mid;
            }
            else {
                end = mid-1;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        LastPosition lp = new LastPosition();
        int[] a ={1,2,2,4,5,5};
        System.out.println(lp.lastPosition(a, 5));
    }
}

/*
Find the last position of a target number in a sorted array. Return -1 if target does not exist.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 2, 4, 5, 5].

For target = 2, return 2.

For target = 5, return 5.

For target = 6, return -1.
 */
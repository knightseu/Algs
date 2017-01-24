package lint.ladder2.required;

/**
 * Created by xuan on 1/23/17.
 */
public class FindMinRotatedSortedArray {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (null == nums || nums.length == 0 ) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[start] && nums[mid] < nums[end]) {
                end = mid;
            }
            if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
                start = mid + 1;
            }
            if (nums[mid] > nums[start] && nums[mid] < nums[end]) {
                return nums[start];
            }
        }

        if (start == end) {
            return nums[start];
        }
        else {
            return nums[start] < nums[end] ? nums[start] : nums[end];
        }

    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        int[] aa = {7, 0, 1, 2, 3, 4, 5, 6};
        int[] aaa = {0, 1, 2, 3, 4, 5, 6, 7};
        FindMinRotatedSortedArray c = new FindMinRotatedSortedArray();
        System.out.println(c.findMin(a));
        System.out.println(c.findMin(aa));
        System.out.println(c.findMin(aaa));
    }
}


/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

 Notice

You may assume no duplicate exists in the array.

Have you met this question in a real interview? Yes
Example
Given [4, 5, 6, 7, 0, 1, 2] return 0
 */
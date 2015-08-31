package lint.ladder2.required;

import java.util.ArrayList;

/**
 * Given a rotated sorted array, recover it to sorted array in-place.

Have you met this question in a real interview? Yes
Example
[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]

Challenge
In-place, O(1) extra space and O(n) time.

Clarification
What is rotated array?

For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]

 * @author xuanlin
 *
 */

public class RecoverRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        if (nums == null) {
            return;
        }
        for (int index = 0; index < nums.size() - 1; index++) {
            if (nums.get(index) > nums.get(index + 1)) {
                revert(nums, 0, index);
                revert(nums, index + 1, nums.size() - 1);
                revert(nums, 0, nums.size() - 1);
                return;
            }   
        }
    }
    
    private void revert(ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }
}

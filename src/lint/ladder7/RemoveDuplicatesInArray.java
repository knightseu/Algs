package lint.ladder7;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by xuanlin on 2/25/17.
 * 521
 * http://www.lintcode.com/en/problem/remove-duplicate-numbers-in-array/
 */
public class RemoveDuplicatesInArray {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // o(n) time
        if (null == nums || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> hash = new HashSet<>();
        int curIndex = 0;
        for (int i=0; i<nums.length; i++) {
            if (!hash.contains(nums[i])) {
                nums[curIndex++] = nums[i];
                hash.add(nums[i]);
            }
        }
        return curIndex;
    }

    public int deduplication_2(int[] nums) {
        // o(lg(n)) time, o(1) space
        // sort first.
        return 0;
    }
}

/*
Given an array of integers, remove the duplicate numbers in it.

You should:
1. Do it in place in the array.
2. Move the unique numbers to the front of the array.
3. Return the total number of the unique numbers.

 Notice

You don't need to keep the original order of the integers.

Have you met this question in a real interview? Yes
Example
Given nums = [1,3,1,4,4,2], you should:

Move duplicate integers to the tail of nums => nums = [1,3,4,2,?,?].
Return the number of unique integers in nums => 4.
Actually we don't care about what you place in ?, we only care about the part which has no duplicate integers.
 */
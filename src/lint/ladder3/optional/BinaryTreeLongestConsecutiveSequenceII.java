package lint.ladder3.optional;

/**
 * Created by xuanlin on 2/26/17.
 * 614
 * http://www.lintcode.com/en/problem/binary-tree-longest-consecutive-sequence-ii/
 */

import common.datastructure.TreeNode;

public class BinaryTreeLongestConsecutiveSequenceII {
    class ResultType {
        public int max_length, max_down, max_up;
        ResultType(int len, int down, int up) {
            max_length = len;
            max_down = down;
            max_up = up;
        }
    }

    public int longestConsecutive2(TreeNode root) {
        // Write your code here
        //return helper(root).max_length;
        return 0;
    }

    public ResultType helper(TreeNode root) {
        return null;
    }
}

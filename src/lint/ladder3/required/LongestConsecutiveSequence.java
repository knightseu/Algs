package lint.ladder3.required;

/**
 * Created by xuan on 1/24/17.
 */
import common.datastructure.Interval;
import common.datastructure.TreeNode;

public class LongestConsecutiveSequence {
    int longest = Integer.MIN_VALUE;
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        // Write your code here
        if (null == root) {
            return 0;
        }
        if (root.left != null) {
            helper(root.left, 1, root.val);
        }
        if (root.right != null) {
            helper(root.right, 1, root.val);
        }
        return longest;
    }

    public void helper(TreeNode root, int len, int last_val) {
        if (root.val - last_val == 1) {
            len++;
        }
        else  {
            if (len > longest) {
                longest = len;
            }
            len = 1;
        }

        if (root.left != null) {
            helper(root.left, len, root.val);
        }
        if (root.right != null) {
            helper(root.right, len, root.val);
        }
    }
}

/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

Have you met this question in a real interview? Yes
Example
For example,

   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    /
   2
  /
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.


 */
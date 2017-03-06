package lint.ladder3.required;

/**
 * Created by xuanlin on 2/26/17.
 */
import common.datastructure.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        return helper(root, null, 0);
    }

    private int helper(TreeNode root, TreeNode parent, int previousLen) {
        if (null == root) {
            return 0;
        }

        int length = 1;
        if (null == parent) {
            length = 1;
        }
        else {
            if (root.val - parent.val == 1) {
                length = previousLen + 1;
            }
            else {
                length = 1;
            }
        }

        int left = helper(root.left, root, length);
        int right = helper(root.right, root, length);
        return Math.max(length, Math.max(left, right));
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
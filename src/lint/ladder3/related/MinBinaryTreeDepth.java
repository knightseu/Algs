package lint.ladder3.related;

/**
 * Created by xuanlin on 2/26/17.
 * 155
 * http://www.lintcode.com/en/problem/minimum-depth-of-binary-tree/
 * http://www.jiuzhang.com/solutions/minimum-depth-of-binary-tree/
 */

import common.datastructure.TreeNode;

public class MinBinaryTreeDepth {
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return getMin(root);
    }

    public int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }
}

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Have you met this question in a real interview? Yes
Example
Given a binary tree as follow:

  1
 / \
2   3
   / \
  4   5
The minimum depth is 2.
 */


// 关键，在 getMin 中， when root == null, return Integer.MAX_VALUE

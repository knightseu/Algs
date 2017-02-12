package lint.ladder3.required;

/**
 * Created by xuan on 1/24/17.
 */
import common.datastructure.TreeNode;

public class SubtreeMaxAverage {
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        return null;
    }

    public int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 0;
        }
        return -1;
    }
}


/*
Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

 Notice

LintCode will print the subtree which root is your return node.
It's guaranteed that there is only one subtree with maximum average.

Have you met this question in a real interview? Yes
Example
Given a binary tree:

     1
   /   \
 -5     11
 / \   /  \
1   2 4    -2
return the node 11.
 */
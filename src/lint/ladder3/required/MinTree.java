package lint.ladder3.required;

/**
 * Created by xuan on 1/24/17.
 */
import common.datastructure.TreeNode;

public class MinTree {
    TreeNode subTree = null;
    int minSum = Integer.MAX_VALUE;
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        subTree = null;
        countTree(root);
        return subTree;
    }

    public int countTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            if (subTree == null || root.val < minSum) {
                minSum = root.val;
                subTree = root;
            }
            return root.val;
        }

        int leftval = 0;
        int rightval = 0;
        if (root.left != null) {
            leftval = countTree(root.left);
        }
        if (root.right !=null) {
            rightval = countTree(root.right);
        }

        int curSum = leftval + rightval + root.val
        if (curSum < minSum) {
            minSum = curSum;
            subTree = root;
        }
        return curSum;
    }
}
/*
Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

 Notice

LintCode will print the subtree which root is your return node.
It's guaranteed that there is only one subtree with minimum sum and the given binary tree is not an empty tree.

Have you met this question in a real interview? Yes
Example
Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   2 -4  -5
return the node 1.


 */
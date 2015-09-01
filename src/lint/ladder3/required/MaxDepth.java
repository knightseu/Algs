package lint.ladder3.required;

import common.datastructure.TreeNode;

/**
 * 
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Have you met this question in a real interview? Yes
Example
Given a binary tree as follow:

  1
 / \ 
2   3
   / \
  4   5
The maximum depth is 3.

 * @author xuanlin
 *
 */
public class MaxDepth {
	
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
    	if (root == null) {
    		return 0;
    	}
    	
    	return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}

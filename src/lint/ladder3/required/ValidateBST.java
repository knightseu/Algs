package lint.ladder3.required;

import common.datastructure.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Have you met this question in a real interview? Yes
Example
An example:

  2
 / \
1   3
   /
  4
   \
    5
The above binary tree is serialized as {2,1,3,#,#,4,#,#,5} (in level order).

 * @author xuanlin
 *
 */
public class ValidateBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
    	return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode root, long lowBound, long upBound) {
    	if (root == null) {
    		return true;
    	}
    	
    	if (root.val >= upBound || root.val <= lowBound) {
    		return false;
    	}
    	
    	return dfs(root.left, lowBound, root.val)
    			&& dfs(root.right, root.val, upBound);
    	
    }

}

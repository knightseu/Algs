package lint.ladder3.required;

import common.datastructure.TreeNode;

/**
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Have you met this question in a real interview? Yes
Example
Given the below binary tree:

  1
 / \
2   3
return 6.
 * @author xuanlin
 *
 */
public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private class ResultType {
        // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
        // maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
        int singlePath, maxPath; 
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
	
	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(0, Integer.MIN_VALUE);
		}
		
		//devide
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		
		//conquer
		int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
		singlePath = Math.max(singlePath, 0); //set min to 0 just because, we do not have to go through this subtree at all if it is less than 0
		
		//max path has two scenarios, 1. pass root, 2. does not pass root
		int maxPath = Math.max(left.maxPath, right.maxPath);
		maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
		
		return new ResultType(singlePath, maxPath);
	}
    public int maxPathSum(TreeNode root) {
        ResultType rst = helper(root);
        return rst.maxPath;
    }

}

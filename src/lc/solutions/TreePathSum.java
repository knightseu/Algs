package lc.solutions;

import common.datastructure.TreeNode;

public class TreePathSum {
	
	//recursive
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if ((root.left == null) && (root.right ==null)) return root.val == sum;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val); 
    }
    
    //non-recursive dfs
    public static boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        if ((root.left == null) && (root.right ==null)) return root.val == sum;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val); 
    }
}
